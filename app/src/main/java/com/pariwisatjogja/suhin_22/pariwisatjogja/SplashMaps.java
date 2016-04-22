package com.pariwisatjogja.suhin_22.pariwisatjogja;


import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Handler;
import android.provider.Settings;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.google.android.gms.maps.model.PolylineOptions;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import java.util.HashMap;


import org.json.JSONObject;

import android.graphics.Color;
import android.os.AsyncTask;


public class SplashMaps extends FragmentActivity implements OnMapReadyCallback, LocationListener {

    private static int SPLASH_TIME_OUT = 3000;

    private GoogleMap mMap;
    private final String TAG = "Geolocation";
    private LocationManager locationManager;
    private Location mobileLocation;
    private Location netLocation;

    private String jarak;
    private String waktu;

    //Distance
    ArrayList<LatLng> markerPoints;
    TextView tvDistanceDuration;
    LatLng point;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        ConnectivityManager ConnectionManager=(ConnectivityManager)getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo=ConnectionManager.getActiveNetworkInfo();
        if(networkInfo != null && networkInfo.isConnected()==true )
        {
            Toast.makeText(SplashMaps.this, "Network Available", Toast.LENGTH_LONG).show();
        }
        else
        {
            Toast.makeText(SplashMaps.this, "Network Not Available", Toast.LENGTH_LONG).show();
            finish();
        }

        locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);

        boolean isGPSEnabled = locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER);

        if(!isGPSEnabled)
        {
            AlertDialog.Builder alertDialog = new AlertDialog.Builder(SplashMaps.this);

            // Setting Dialog Title
            alertDialog.setTitle("GPS settings");

            // Setting Dialog Message
            alertDialog.setMessage("GPS is not enabled. Do you want to go to settings menu?");

            // On pressing Settings button
            alertDialog.setPositiveButton("Settings", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog,int which) {
                    Intent intent = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
                    startActivity(intent);
                }
            });

            // on pressing cancel button
            alertDialog.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int which) {
                    dialog.cancel();
                }
            });

            // Showing Alert Message
            alertDialog.show();
        }
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        //Distance
        tvDistanceDuration = (TextView) findViewById(R.id.tv_distance_time);
        //distance
        // Initializing
        markerPoints = new ArrayList<LatLng>();
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
        mMap.setMyLocationEnabled(true);
        mMap.setTrafficEnabled(true);

        // Add a marker in Sydney and move the camera

        //to show current location in the map
        mMap.setMyLocationEnabled(true);

        locationManager = (LocationManager)getSystemService(Context.LOCATION_SERVICE);

        if(locationManager.getAllProviders().contains(LocationManager.GPS_PROVIDER))
            locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER,0,0,this);

        if(locationManager.getAllProviders().contains(LocationManager.NETWORK_PROVIDER))
            locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER,0,0,this);

        mobileLocation = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
        if (mobileLocation != null)
        {
            onLocationSet(mobileLocation);
        }

        netLocation = locationManager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);
        if (netLocation != null)
        {
            onLocationSet(netLocation);
        }

        /*mMap.setOnMapClickListener(new GoogleMap.OnMapClickListener() {
            @Override
            public void onMapClick(LatLng latLng) {

                LatLng mobilelocation = new LatLng(mobileLocation.getLatitude(), mobileLocation.getLongitude());
                Toast.makeText(getApplicationContext(), mobilelocation.toString(), Toast.LENGTH_LONG).show();
            }
        });*/

        mMap.setOnMyLocationButtonClickListener(new GoogleMap.OnMyLocationButtonClickListener() {

            @Override
            public boolean onMyLocationButtonClick() {

                if (mobileLocation != null) {
                    LatLng latLng = new LatLng(mobileLocation.getLatitude(), mobileLocation.getLongitude());
                    mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(latLng, 15.0f));

                }

                if (netLocation != null) {
                    LatLng latLng = new LatLng(netLocation.getLatitude(), netLocation.getLongitude());
                    mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(latLng, 15.0f));
                }
                return false;
            }
        });
    }

    private String getDirectionsUrl(LatLng origin,LatLng dest){

        // Origin of route
        String str_origin = "origin="+origin.latitude+","+origin.longitude;

        // Destination of route
        String str_dest = "destination="+dest.latitude+","+dest.longitude;

        // Sensor enabled
        String sensor = "sensor=false";

        // Building the parameters to the web service
        String parameters = str_origin+"&"+str_dest+"&"+sensor;

        // Output format
        String output = "json";

        // Building the url to the web service
        String url = "https://maps.googleapis.com/maps/api/directions/"+output+"?"+parameters;

        return url;
    }

    //**//**//**//**//**//**//**//** A method to download json data from url *//**//**//**//**//**//**//**//*
    private String downloadUrl(String strUrl) throws IOException{
        String data = "";
        InputStream iStream = null;
        HttpURLConnection urlConnection = null;
        try{
            URL url = new URL(strUrl);

            // Creating an http connection to communicate with url
            urlConnection = (HttpURLConnection) url.openConnection();

            // Connecting to url
            urlConnection.connect();

            // Reading data from url
            iStream = urlConnection.getInputStream();

            BufferedReader br = new BufferedReader(new InputStreamReader(iStream));

            StringBuffer sb  = new StringBuffer();

            String line = "";
            while( ( line = br.readLine())  != null){
                sb.append(line);
            }

            data = sb.toString();

            br.close();

        }catch(Exception e){
            Log.e("Exception while downloading url", e.toString());
        }finally{
            iStream.close();
            urlConnection.disconnect();
        }
        return data;
    }

    // Fetches data from url passed
    private class DownloadTask extends AsyncTask<String, Void, String>{

        // Downloading data in non-ui thread
        @Override
        protected String doInBackground(String... url) {

            // For storing data from web service
            String data = "";

            try{
                // Fetching the data from web service
                data = downloadUrl(url[0]);
            }catch(Exception e){
                Log.d("Background Task",e.toString());
            }
            return data;
        }

        // Executes in UI thread, after the execution of
        // doInBackground()
        @Override
        protected void onPostExecute(String result) {
            super.onPostExecute(result);

            ParserTask parserTask = new ParserTask();

            // Invokes the thread for parsing the JSON data
            parserTask.execute(result);
        }
    }

    //**//**//**//**//**//**//**//** A class to parse the Google Places in JSON format *//**//**//**//**//**//**//**//*
    private class ParserTask extends AsyncTask<String, Integer, List<List<HashMap<String,String>>> >{

        // Parsing the data in non-ui thread
        @Override
        protected List<List<HashMap<String, String>>> doInBackground(String... jsonData) {

            JSONObject jObject;
            List<List<HashMap<String, String>>> routes = null;

            try{
                jObject = new JSONObject(jsonData[0]);
                DirectionsJSONParser parser = new DirectionsJSONParser();

                // Starts parsing data
                routes = parser.parse(jObject);
            }catch(Exception e){
                e.printStackTrace();
            }
            return routes;
        }

        // Executes in UI thread, after the parsing process
        @Override
        protected void onPostExecute(List<List<HashMap<String, String>>> result) {
            ArrayList<LatLng> points = null;
            PolylineOptions lineOptions = null;
            MarkerOptions markerOptions = new MarkerOptions();
            String distance = "";
            String duration = "";

            if(result.size()<1){
                Toast.makeText(getBaseContext(), "No Points", Toast.LENGTH_SHORT).show();
                return;
            }

            // Traversing through all the routes
            for(int i=0;i<result.size();i++){
                points = new ArrayList<LatLng>();
                lineOptions = new PolylineOptions();

                // Fetching i-th route
                List<HashMap<String, String>> path = result.get(i);

                // Fetching all the points in i-th route
                for(int j=0;j<path.size();j++){
                    HashMap<String,String> point = path.get(j);

                    if(j==0){    // Get distance from the list
                        distance = (String)point.get("distance");
                        continue;
                    }else if(j==1){ // Get duration from the list
                        duration = (String)point.get("duration");
                        continue;
                    }

                    double lat = Double.parseDouble(point.get("lat"));
                    double lng = Double.parseDouble(point.get("lng"));
                    LatLng position = new LatLng(lat, lng);

                    points.add(position);
                }

                // Adding all the points in the route to LineOptions
                lineOptions.addAll(points);
                lineOptions.width(7);
                lineOptions.color(Color.rgb(121,85,72));
            }

            tvDistanceDuration.setText("Jarak:"+distance + ", Waktu:"+duration);

            // Drawing polyline in the Google Map for the i-th route
        //    mMap.addPolyline(lineOptions);
        }
    }

    public void onLocationSet(Location location) {
        if (location == null) {
            Log.e(TAG, "No Internet Connection");
            return;
        }
        if(markerPoints.size()>1) {
            markerPoints.clear();
            mMap.clear();
        }

        //Point 2 Location
        for (int i=0;i<3;i++) {
            if (i<1) {
                point = new LatLng(location.getLatitude(), location.getLongitude());
                mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(point, 10.0f));
            } else if (i<2) {
                point = new LatLng(-8.0100571, 110.3130087);
            }
            markerPoints.add(point);

            MarkerOptions options = new MarkerOptions();
            options.position(point);

            if(markerPoints.size()==1){
                options.icon(BitmapDescriptorFactory.fromResource(R.mipmap.user));
                mMap.addMarker(options);
            }else if(markerPoints.size()==2){
                options.icon(BitmapDescriptorFactory.fromResource(R.mipmap.destination));
                mMap.addMarker(options);
            }
        }

        // Checks, whether start and end locations are captured
        if(markerPoints.size() >= 2){
            LatLng origin = markerPoints.get(0);
            LatLng dest = markerPoints.get(1);

            // Getting URL to the Google Directions API
            String url = getDirectionsUrl(origin, dest);

            DownloadTask downloadTask = new DownloadTask();

            // Start downloading json data from Google Directions API
            downloadTask.execute(url);

        }

        //Malioboro
        point = new LatLng(-7.7926543, 110.3658036);
        markerPoints.add(point);
        MarkerOptions options = new MarkerOptions();
        options.position(point);
        options.icon(BitmapDescriptorFactory.fromResource(R.mipmap.destination));
    //    options.title("Malioboro");
        mMap.addMarker(options);

        //Perambanan
        point = new LatLng(-7.7520232, 110.4913688);
        markerPoints.add(point);
        MarkerOptions options2 = new MarkerOptions();
        options2.position(point);
        options2.icon(BitmapDescriptorFactory.fromResource(R.mipmap.destination));
        mMap.addMarker(options2);

        //Keraton
        point = new LatLng(-7.8082707, 110.3658832);
        markerPoints.add(point);
        MarkerOptions options3 = new MarkerOptions();
        options3.position(point);
        options3.icon(BitmapDescriptorFactory.fromResource(R.mipmap.destination));
        mMap.addMarker(options3);

        //Taman Pintar
        point = new LatLng(-7.8007394, 110.3678595);
        markerPoints.add(point);
        MarkerOptions options4 = new MarkerOptions();
        options4.position(point);
        options4.icon(BitmapDescriptorFactory.fromResource(R.mipmap.destination));
        mMap.addMarker(options4);

        new Handler().postDelayed(new Runnable() {

			/*
             * Showing splash screen with a timer. This will be useful when you
			 * want to show case your app logo / company
			 */

            @Override
            public void run() {
                // This method will be executed once the timer is over
                // Start your app main activity
                Intent i = new Intent(SplashMaps.this, MainActivity.class);
                startActivity(i);

                // close this activity
                finish();
            }
        }, SPLASH_TIME_OUT);
    }

    @Override
    public void onLocationChanged(Location location) {
        Log.d(TAG, "Location (" + location + ") changed");
    }


    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {
        Log.d(TAG, "status (" + status + ") changed : " + provider);
    }

    @Override
    public void onProviderEnabled(String provider) {
        Log.d(TAG, "provider enabled : " + provider);
    }

    @Override
    public void onProviderDisabled(String provider) {
        Log.d(TAG, "provider disabled : " + provider);
    }
}
