package com.pariwisatjogja.suhin_22.pariwisatjogja;

import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
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


public class MapsActivity extends FragmentActivity implements OnMapReadyCallback, LocationListener {

    private TextView txttitle;
    private GoogleMap mMap;
    private final String TAG = "Geolocation";
    private LocationManager locationManager;
    private Location mobileLocation;
    private Location netLocation;
    private String namalokasi;

    //Distance
    ArrayList<LatLng> markerPoints;
    TextView tvDistanceDuration;
    LatLng point;
    private LatLng lokasi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);

        ConnectivityManager ConnectionManager=(ConnectivityManager)getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo=ConnectionManager.getActiveNetworkInfo();
        if(networkInfo != null && networkInfo.isConnected()==true )
        {
            Toast.makeText(MapsActivity.this, "Network Available", Toast.LENGTH_LONG).show();
            SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                    .findFragmentById(R.id.map);
            mapFragment.getMapAsync(this);

            //Distance
            tvDistanceDuration = (TextView) findViewById(R.id.tv_distance_time);
            //distance
            // Initializing
            markerPoints = new ArrayList<LatLng>();
        }
        else
        {
            Toast.makeText(MapsActivity.this, "Network Not Available", Toast.LENGTH_LONG).show();
        //    finish();
        }
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        Intent fromIn = getIntent();
        namalokasi = fromIn.getStringExtra("namelokasi");


        Bundle bundle = getIntent().getParcelableExtra("bundle");
        lokasi = bundle.getParcelable("lokasi");

        txttitle = (TextView)findViewById(R.id.title);
        txttitle.setText(namalokasi);

        Toast.makeText(MapsActivity.this, namalokasi, Toast.LENGTH_LONG).show();
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
    //    mMap.setTrafficEnabled(true);

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
                lineOptions.color(Color.rgb(244, 143, 177));
            }

            tvDistanceDuration.setText("Distance:"+distance + ", Duration:"+duration);

            // Drawing polyline in the Google Map for the i-th route
            mMap.addPolyline(lineOptions);
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
            } else if (i<2) {
                point = lokasi;
                if (namalokasi.equalsIgnoreCase("Pantai Indrayanti")) {
                    mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(point, 9.0f));
                } else if (namalokasi.equalsIgnoreCase("Pantai Parangtritis")) {
                    mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(point, 10.0f));
                } else if (namalokasi.equalsIgnoreCase("Pantai Siung")) {
                    mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(point, 9.0f));
                }

                //Museum
                else if (namalokasi.equalsIgnoreCase("Museum Keraton Yogyakarta")) {
                    mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(point, 13.0f));
                }else if (namalokasi.equalsIgnoreCase("Museum Sonobudoyo")) {
                    mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(point, 13.0f));
                }else if (namalokasi.equalsIgnoreCase("Museum Affandi")) {
                    mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(point, 14.0f));
                }

                //Candi
                else if (namalokasi.equalsIgnoreCase("Candi Prambanan")) {
                    mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(point, 11.0f));
                }else if (namalokasi.equalsIgnoreCase("Candi Borobudur")) {
                    mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(point, 10.0f));
                }else if (namalokasi.equalsIgnoreCase("Candi Sambisari")) {
                    mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(point, 12.0f));
                }

                //Kuliner
                else if (namalokasi.equalsIgnoreCase("The House of Raminten")) {
                    mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(point, 13.0f));
                }else if (namalokasi.equalsIgnoreCase("Gudeg Yu Djum")) {
                    mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(point, 12.0f));
                }else if (namalokasi.equalsIgnoreCase("The Kalimilk")) {
                    mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(point, 14.0f));
                }

                //Belanja
                else if (namalokasi.equalsIgnoreCase("Malioboro")) {
                    mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(point, 12.0f));
                }else if (namalokasi.equalsIgnoreCase("Beringharjo")) {
                    mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(point, 12.0f));
                }else if (namalokasi.equalsIgnoreCase("Kasongan")) {
                    mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(point, 11.0f));
                }
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
