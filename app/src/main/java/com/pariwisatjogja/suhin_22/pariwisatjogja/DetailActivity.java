package com.pariwisatjogja.suhin_22.pariwisatjogja;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.location.Address;
import android.location.Geocoder;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Spannable;
import android.text.SpannableString;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bluejamesbond.text.DocumentView;
import com.bluejamesbond.text.style.TextAlignment;
import com.github.clans.fab.FloatingActionMenu;
import com.google.android.gms.maps.model.LatLng;

import android.util.Log;
import android.widget.Toast;

import com.daimajia.slider.library.Animations.DescriptionAnimation;
import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.TextSliderView;
import com.daimajia.slider.library.Tricks.ViewPagerEx;

import com.squareup.picasso.Picasso;

import java.util.HashMap;

import android.content.Context;

import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;


import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
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

import java.util.Locale;


import org.json.JSONObject;

import android.graphics.Color;
import android.os.AsyncTask;

public class DetailActivity extends AppCompatActivity implements BaseSliderView.OnSliderClickListener, ViewPagerEx.OnPageChangeListener, OnMapReadyCallback, LocationListener {

    private TextView txtdetail;
    private String yourstring, location_share;
    private DocumentView dc;
    private Spannable span;
    private LatLng lokasi;
    private LatLng lokasistreetview;
    private String name;
    private SliderLayout mDemoSlider;
    private HashMap<String,String> url_maps;
    private ImageView picasso;
    private Intent share_action;

    private GoogleMap mMap;
    private final String TAG = "Geolocation";
    private LocationManager locationManager;
    private Location mobileLocation;
    private Location netLocation;

    //Distance
    ArrayList<LatLng> markerPoints;
    private TextView tvDistanceDuration;
    LatLng point;
    private TextView tvlokasisaya;
    private TextView tvlokasitujuan;

    private FloatingActionMenu menuRed;

    private com.github.clans.fab.FloatingActionButton panorama;
    private com.github.clans.fab.FloatingActionButton petunjuklokasi;
    private com.github.clans.fab.FloatingActionButton share;
    private Button petunjukmap;

    private List<FloatingActionMenu> menus = new ArrayList<>();
    private Handler mUiHandler = new Handler();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        ConnectivityManager ConnectionManager=(ConnectivityManager)getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo=ConnectionManager.getActiveNetworkInfo();
        if(networkInfo != null && networkInfo.isConnected()==true )
        {
            Toast.makeText(DetailActivity.this, "Network Available", Toast.LENGTH_LONG).show();
            SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                    .findFragmentById(R.id.map);
            mapFragment.getMapAsync(this);

        }
        else
        {
            Toast.makeText(DetailActivity.this, "Network Not Available", Toast.LENGTH_LONG).show();
            //    finish();
        }

        //Tambah Menu
        menuRed = (FloatingActionMenu)findViewById(R.id.menu_red);

        panorama = (com.github.clans.fab.FloatingActionButton)findViewById(R.id.panorama);
        petunjuklokasi = (com.github.clans.fab.FloatingActionButton)findViewById(R.id.petunjuklokasi);
        share = (com.github.clans.fab.FloatingActionButton)findViewById(R.id.share);
        petunjukmap = (Button) findViewById(R.id.petunjuk);

        panorama.setOnClickListener(clickListener);
        petunjuklokasi.setOnClickListener(clickListener);
        share.setOnClickListener(clickListener);
        petunjukmap.setOnClickListener(clickListener);

        //Distance
        tvDistanceDuration = (TextView) findViewById(R.id.tv_distance_time);
        tvlokasisaya = (TextView) findViewById(R.id.tv_lokasi_saya);
        tvlokasitujuan = (TextView) findViewById(R.id.tv_lokasi_tujuan);
        //distance
        // Initializing
        markerPoints = new ArrayList<LatLng>();

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        picasso = (ImageView) findViewById(R.id.picasso);
        picasso.setVisibility(View.INVISIBLE);

        txtdetail = (TextView)findViewById(R.id.txt_detail);
        //Slider Image
        mDemoSlider = (SliderLayout)findViewById(R.id.slider);

        Intent fromIn = getIntent();
        name = fromIn.getStringExtra("name");
        txtdetail.setText(String.valueOf("Informasi " + name));

        int delay = 100;
        for (final FloatingActionMenu menu : menus) {
            mUiHandler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    menu.showMenuButton(true);
                }
            }, delay);
            delay += 150;
        }

        menuRed.setOnMenuButtonClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (menuRed.isOpened()) {
                    //Toast.makeText(DetailActivity.this, menuRed.getMenuButtonLabelText(), Toast.LENGTH_SHORT).show();
                }
                menuRed.toggle(true);
            }
        });

        //Pantai
        if (name.equalsIgnoreCase("Pantai Indrayanti")) {
            //Slider Imagee
            url_maps = new HashMap<String, String>();
            Picasso.with(this)
                    .load("https://farm8.staticflickr.com/7672/26729522490_d23a532a3f_z.jpg")
                    .into(picasso);
            url_maps.put("Pantai Indrayanti 1", "https://farm8.staticflickr.com/7672/26729522490_d23a532a3f_z.jpg");
            url_maps.put("Pantai Indrayanti 2", "https://farm8.staticflickr.com/7491/26729521710_7226e9b6dd_z.jpg");
            url_maps.put("Pantai Indrayanti 3", "https://farm8.staticflickr.com/7239/26934795661_800a8b5714_z.jpg");
            url_maps.put("Pantai Indrayanti 4", "https://farm8.staticflickr.com/7375/26729516270_b3051da2df_z.jpg");
            tambahSlidingImage();
            yourstring = getResources().getString(R.string.sample_text);

            //parsing Latlng to Share
            lokasi = new LatLng(-8.1501016,110.6121118);
            lokasistreetview = new LatLng(-7.6080523,110.2037833);
            Double l1=lokasi.latitude;
            Double l2=lokasi.longitude;
            location_share = l1.toString() + "," + l2.toString();

        } else if (name.equalsIgnoreCase("Pantai Parangtritis")) {
            //Slider Imagee
            url_maps = new HashMap<String, String>();
            Picasso.with(this)
                    .load("https://farm8.staticflickr.com/7672/26729522490_d23a532a3f_z.jpg")
                    .into(picasso);
            url_maps.put("Pantai Parangtritis 1", "https://farm8.staticflickr.com/7583/26729522990_209bc0c760.jpg");
            url_maps.put("Pantai Parangtritis 2", "https://farm8.staticflickr.com/7334/26397611054_71989864ab_b.jpg");
            url_maps.put("Pantai Parangtritis 3", "https://farm8.staticflickr.com/7598/26729516490_c55a1c5185_b.jpg");
            url_maps.put("Pantai Parangtritis 4", "https://farm8.staticflickr.com/7454/26969866236_570cdfbfa1_b.jpg");
            tambahSlidingImage();
            yourstring = getResources().getString(R.string.sample_text);

            lokasi = new LatLng(-8.0252838,110.33373);
            lokasistreetview = new LatLng(-8.0252838,110.33373);
            Double l1=lokasi.latitude;
            Double l2=lokasi.longitude;
            location_share = l1.toString() + "," + l2.toString();

        } else if (name.equalsIgnoreCase("Pantai Siung")) {
            //Slider Imagee
            url_maps = new HashMap<String, String>();
            Picasso.with(this)
                    .load("https://farm8.staticflickr.com/7672/26729522490_d23a532a3f_z.jpg")
                    .into(picasso);
            url_maps.put("Pantai Siung 1", "https://farm8.staticflickr.com/7566/26397609744_3ac978d5f6_z.jpg");
            url_maps.put("Pantai Siung 2", "https://farm8.staticflickr.com/7260/26909153892_9e2691c137_z.jpg");
            url_maps.put("Pantai Siung 3", "https://farm8.staticflickr.com/7496/26909152512_7763725873_z.jpg");
            url_maps.put("Pantai Siung 4", "https://farm8.staticflickr.com/7647/26729517250_1829747bd3_z.jpg");
            tambahSlidingImage();
            yourstring = getResources().getString(R.string.sample_text);

            lokasi = new LatLng(-8.1813422,110.6823995);
            lokasistreetview = new LatLng(-8.1813422,110.6823995);
            Double l1=lokasi.latitude;
            Double l2=lokasi.longitude;
            location_share = l1.toString() + "," + l2.toString();

        }
        //Museum
        else if (name.equalsIgnoreCase("Museum Keraton Yogyakarta")) {
            //Slider Imagee
            url_maps = new HashMap<String, String>();
            Picasso.with(this)
                    .load("https://farm8.staticflickr.com/7672/26729522490_d23a532a3f_z.jpg")
                    .into(picasso);
            url_maps.put("Museum Keraton Yogyakarta 1", "https://farm8.staticflickr.com/7140/26935173031_c472940875_z.jpg");
            url_maps.put("Museum Keraton Yogyakarta 2", "https://farm8.staticflickr.com/7346/27003644755_41ab06c99e_z.jpg");
            url_maps.put("Museum Keraton Yogyakarta 3", "https://farm8.staticflickr.com/7140/26935173031_c472940875_z.jpg");
            url_maps.put("Museum Keraton Yogyakarta 4", "https://farm8.staticflickr.com/7511/26397961314_19b35421b0_z.jpg");
            tambahSlidingImage();
            yourstring = getResources().getString(R.string.sample_text);

            lokasi = new LatLng(-7.805224,110.36509);
            lokasistreetview = new LatLng(-7.805224,110.36509);
            Double l1=lokasi.latitude;
            Double l2=lokasi.longitude;
            location_share = l1.toString() + "," + l2.toString();

        }else if (name.equalsIgnoreCase("Museum Sonobudoyo")) {
            //Slider Imagee
            url_maps = new HashMap<String, String>();
            Picasso.with(this)
                    .load("https://farm8.staticflickr.com/7672/26729522490_d23a532a3f_z.jpg")
                    .into(picasso);
            url_maps.put("Museum Sonobudoyo 1", "https://farm8.staticflickr.com/7543/27040180475_ed438b2320_z.jpg");
            url_maps.put("Museum Sonobudoyo 2", "https://farm8.staticflickr.com/7616/27006732566_b6237bfa51_z.jpg");
            url_maps.put("Museum Sonobudoyo 3", "https://farm8.staticflickr.com/7393/26434488644_8ec2e7a7ea_z.jpg");
            tambahSlidingImage();
            yourstring = getResources().getString(R.string.sample_text);

            lokasi = new LatLng(-7.802859,110.364003);
            lokasistreetview = new LatLng(-7.802859,110.364003);
            Double l1=lokasi.latitude;
            Double l2=lokasi.longitude;
            location_share = l1.toString() + "," + l2.toString();

        }else if (name.equalsIgnoreCase("Museum Affandi")) {
            //Slider Imagee
            url_maps = new HashMap<String, String>();
            Picasso.with(this)
                    .load("https://farm8.staticflickr.com/7672/26729522490_d23a532a3f_z.jpg")
                    .into(picasso);
            url_maps.put("Museum Affandi 1", "https://farm8.staticflickr.com/7209/26765954390_6c48436f97_z.jpg");
            url_maps.put("Museum Affandi 2", "https://farm8.staticflickr.com/7647/26971881101_1914fe3bff_z.jpg");
            url_maps.put("Museum Affandi 3", "https://farm8.staticflickr.com/7245/26971885361_df758d020d_z.jpg");
            tambahSlidingImage();
            yourstring = getResources().getString(R.string.sample_text);

            lokasi = new LatLng(-7.783114,110.396425);
            lokasistreetview = new LatLng(-7.783114,110.396425);
            Double l1=lokasi.latitude;
            Double l2=lokasi.longitude;
            location_share = l1.toString() + "," + l2.toString();

        }

        //Candi
        else if (name.equalsIgnoreCase("Candi Prambanan")) {
            //Slider Imagee
            url_maps = new HashMap<String, String>();
            Picasso.with(this)
                    .load("https://farm8.staticflickr.com/7672/26729522490_d23a532a3f_z.jpg")
                    .into(picasso);
            url_maps.put("Candi Prambanan 1", "https://farm8.staticflickr.com/7178/26935177251_2ab92a7894_z.jpg");
            url_maps.put("Candi Prambanan 2", "https://farm8.staticflickr.com/7754/26399606653_b26ca4c6e4_z.jpg");
            url_maps.put("Candi Prambanan 3", "https://farm8.staticflickr.com/7754/26399606653_b26ca4c6e4_z.jpg");
            url_maps.put("Candi Prambanan 4", "https://farm8.staticflickr.com/7786/26935177991_10da3a6729_z.jpg");
            url_maps.put("Candi Prambanan 5", "https://farm8.staticflickr.com/7786/26935177991_10da3a6729_z.jpg");
            tambahSlidingImage();
            yourstring = getResources().getString(R.string.sample_text);

            lokasi = new LatLng(-7.751919,110.492006);
            lokasistreetview = new LatLng(-7.751919,110.492006);
            Double l1=lokasi.latitude;
            Double l2=lokasi.longitude;
            location_share = l1.toString() + "," + l2.toString();

        }else if (name.equalsIgnoreCase("Candi Borobudur")) {
            //Slider Imagee
            url_maps = new HashMap<String, String>();
            Picasso.with(this)
                    .load("https://farm8.staticflickr.com/7672/26729522490_d23a532a3f_z.jpg")
                    .into(picasso);
            url_maps.put("Candi Borobudur 1", "https://farm8.staticflickr.com/7432/27003660335_02487dc1ab_z.jpg");
            url_maps.put("Candi Borobudur 2", "https://farm8.staticflickr.com/7636/26399608263_f1ba34de8e_z.jpg");
            url_maps.put("Candi Borobudur 3", "https://farm8.staticflickr.com/7183/27003659935_508c0fe48a_z.jpg");
            url_maps.put("Candi Borobudur 4", "https://farm8.staticflickr.com/7742/26399607823_b245194614_z.jpg");
            url_maps.put("Candi Borobudur 5", "https://farm8.staticflickr.com/7023/26399607543_5e74e825d1_z.jpg");
            url_maps.put("Candi Borobudur 6", "https://farm8.staticflickr.com/7513/26397967854_915f9c1585_z.jpg");
            tambahSlidingImage();
            yourstring = getResources().getString(R.string.sample_text);

            lokasi = new LatLng(-7.6081021,110.2037122);
            lokasistreetview = new LatLng(-7.6081021,110.2037122);
            Double l1=lokasi.latitude;
            Double l2=lokasi.longitude;
            location_share = l1.toString() + "," + l2.toString();

        }else if (name.equalsIgnoreCase("Candi Sambisari")) {
            //Slider Imagee
            url_maps = new HashMap<String, String>();
            Picasso.with(this)
                    .load("https://farm8.staticflickr.com/7672/26729522490_d23a532a3f_z.jpg")
                    .into(picasso);
            url_maps.put("Candi Sambisari 1", "https://farm8.staticflickr.com/7719/27003656345_c0448df394_z.jpg");
            url_maps.put("Candi Sambisari 2", "https://farm8.staticflickr.com/7116/26397964584_8c11c07d15_z.jpg");
            url_maps.put("Candi Sambisari 3", "https://farm8.staticflickr.com/7201/26397965054_cf05f1e163_z.jpg");
            url_maps.put("Candi Sambisari 4", "https://farm8.staticflickr.com/7266/26399605903_15c8e3d335_z.jpg");
            tambahSlidingImage();
            yourstring = getResources().getString(R.string.sample_text);

            lokasi = new LatLng(-7.7625465,110.4468635);
            lokasistreetview = new LatLng(-7.7625465,110.4468635);
            Double l1=lokasi.latitude;
            Double l2=lokasi.longitude;
            location_share = l1.toString() + "," + l2.toString();

        }

        //Kuliner
        else if (name.equalsIgnoreCase("The House of Raminten")) {
            //Slider Imagee
            url_maps = new HashMap<String, String>();
            Picasso.with(this)
                    .load("https://farm8.staticflickr.com/7672/26729522490_d23a532a3f_z.jpg")
                    .into(picasso);
            url_maps.put("The House of Raminten 1", "https://farm8.staticflickr.com/7258/26397962084_d2bb01be54_z.jpg");
            url_maps.put("The House of Raminten 2", "https://farm8.staticflickr.com/7720/26397961784_e3958a9199_z.jpg");
            url_maps.put("The House of Raminten 3", "https://farm8.staticflickr.com/7487/26397962904_7d7a9b3bb0_z.jpg");
            url_maps.put("The House of Raminten 4", "https://farm8.staticflickr.com/7363/26397962504_a63c3fa262_z.jpg");
            tambahSlidingImage();
            yourstring = getResources().getString(R.string.sample_text);

            lokasi = new LatLng(-7.7851471,110.3716593);
            lokasistreetview = new LatLng(-7.7851471,110.3716593);
            Double l1=lokasi.latitude;
            Double l2=lokasi.longitude;
            location_share = l1.toString() + "," + l2.toString();

        }else if (name.equalsIgnoreCase("Gudeg Yu Djum")) {
            //Slider Imagee
            url_maps = new HashMap<String, String>();
            Picasso.with(this)
                    .load("https://farm8.staticflickr.com/7672/26729522490_d23a532a3f_z.jpg")
                    .into(picasso);
            url_maps.put("Gudeg Yu Djum 1", "https://farm8.staticflickr.com/7790/26397963224_f116ce55b9_z.jpg");
            url_maps.put("Gudeg Yu Djum 2", "https://farm8.staticflickr.com/7746/26970106746_402e50495a_z.jpg");
            url_maps.put("Gudeg Yu Djum 3", "https://farm8.staticflickr.com/7508/26397963434_c55f8de56f_z.jpg");
            url_maps.put("Gudeg Yu Djum 4", "https://farm8.staticflickr.com/7758/26397964054_518e311003_z.jpg");
            tambahSlidingImage();
            yourstring = getResources().getString(R.string.sample_text);

            lokasi = new LatLng(-7.8046002,110.3666496);
            lokasistreetview = new LatLng(-7.8046002,110.3666496);
            Double l1=lokasi.latitude;
            Double l2=lokasi.longitude;
            location_share = l1.toString() + "," + l2.toString();

        }else if (name.equalsIgnoreCase("The Kalimilk")) {
            //Slider Imagee
            url_maps = new HashMap<String, String>();
            Picasso.with(this)
                    .load("https://farm8.staticflickr.com/7672/26729522490_d23a532a3f_z.jpg")
                    .into(picasso);
            url_maps.put("The Kalimilk 1", "https://farm8.staticflickr.com/7653/26773981310_4f0de919e8_z.jpg");
            url_maps.put("The Kalimilk 2", "https://farm8.staticflickr.com/7599/26773981970_858c4d4193_z.jpg");
            url_maps.put("The Kalimilk 3", "https://farm8.staticflickr.com/7516/26979978611_288d28cb4f_z.jpg");
            url_maps.put("The Kalimilk 4", "https://farm8.staticflickr.com/7627/26773981820_8ece33e769_z.jpg");
            tambahSlidingImage();
            yourstring = getResources().getString(R.string.sample_text);

            lokasi = new LatLng(-7.7629085,110.3797544);
            lokasistreetview = new LatLng(-7.7629085,110.3797544);
            Double l1=lokasi.latitude;
            Double l2=lokasi.longitude;
            location_share = l1.toString() + "," + l2.toString();
        }

        else if (name.equalsIgnoreCase("Malioboro")) {
            //Slider Imagee
            url_maps = new HashMap<String, String>();
            Picasso.with(this)
                    .load("https://farm8.staticflickr.com/7672/26729522490_d23a532a3f_z.jpg")
                    .into(picasso);
            url_maps.put("Malioboro 1", "https://farm8.staticflickr.com/7388/26399609233_989af95966_z.jpg");
            url_maps.put("Malioboro 2", "https://farm8.staticflickr.com/7579/26399608993_cae4f8eb24_z.jpg");
            url_maps.put("Malioboro 3", "https://farm8.staticflickr.com/7538/27003660585_0c6d878d98_z.jpg");
            tambahSlidingImage();
            yourstring = getResources().getString(R.string.sample_text);

            lokasi = new LatLng(-7.793229,110.365748);
            lokasistreetview = new LatLng(-7.793229,110.365748);
            Double l1=lokasi.latitude;
            Double l2=lokasi.longitude;
            location_share = l1.toString() + "," + l2.toString();

        }else if (name.equalsIgnoreCase("Beringharjo")) {
            //Slider Imagee
            url_maps = new HashMap<String, String>();
            Picasso.with(this)
                    .load("https://farm8.staticflickr.com/7672/26729522490_d23a532a3f_z.jpg")
                    .into(picasso);
            url_maps.put("Beringharjo 1", "https://farm8.staticflickr.com/7630/26775720500_75ceae0435_z.jpg");
            url_maps.put("Beringharjo 2", "https://farm8.staticflickr.com/7717/26955884372_3d88fd109d_z.jpg");
            url_maps.put("Beringharjo 3", "https://farm8.staticflickr.com/7192/26446572613_f32205180d_z.jpg");
            tambahSlidingImage();
            yourstring = getResources().getString(R.string.sample_text);

            lokasi = new LatLng(-7.798672,110.365073);
            lokasistreetview = new LatLng(-7.798672,110.365073);
            Double l1=lokasi.latitude;
            Double l2=lokasi.longitude;
            location_share = l1.toString() + "," + l2.toString();

        }else if (name.equalsIgnoreCase("Kasongan")) {
            //Slider Imagee
            url_maps = new HashMap<String, String>();
            Picasso.with(this)
                    .load("https://farm8.staticflickr.com/7672/26729522490_d23a532a3f_z.jpg")
                    .into(picasso);
            url_maps.put("Kasongan 1", "https://farm8.staticflickr.com/7374/26982348421_b66c44cc0a_z.jpg");
            url_maps.put("Kasongan 2", "https://farm8.staticflickr.com/7253/26776286130_886e0773f6_z.jpg");
            url_maps.put("Kasongan 3", "https://farm8.staticflickr.com/7612/26776286420_a633e9f06d_z.jpg");
            url_maps.put("Kasongan 4", "https://farm8.staticflickr.com/7266/26776286940_0fdc2c1efa_z.jpg");
            tambahSlidingImage();
            yourstring = getResources().getString(R.string.sample_text);

            lokasi = new LatLng(-7.8450784,110.33561);
            lokasistreetview = new LatLng(-7.8450784,110.33561);
            Double l1=lokasi.latitude;
            Double l2=lokasi.longitude;
            location_share = l1.toString() + "," + l2.toString();

        }

        dc = (DocumentView) findViewById(R.id.documentView);
        span = new SpannableString(yourstring);
        dc.getDocumentLayoutParams().setTextAlignment(TextAlignment.JUSTIFIED);
        dc.setText(span);
    }

    private void tambahSlidingImage() {
        // ----------------------Tambah Sliding Image -----------------------------

        for(String nameSliding : url_maps.keySet()){
            TextSliderView textSliderView = new TextSliderView(this);
            // initialize a SliderLayout
            textSliderView
                    .description(name)
                    .image(url_maps.get(nameSliding))
                    .setScaleType(BaseSliderView.ScaleType.Fit)
                    .setOnSliderClickListener(this);

            //add your extra information
            textSliderView.bundle(new Bundle());
            textSliderView.getBundle()
                    .putString("extra",nameSliding);

            mDemoSlider.addSlider(textSliderView);

        }
        mDemoSlider.setPresetTransformer(SliderLayout.Transformer.ZoomOut);
        mDemoSlider.setPresetIndicator(SliderLayout.PresetIndicators.Center_Bottom);
        mDemoSlider.setCustomAnimation(new DescriptionAnimation());
        mDemoSlider.setDuration(4000);
        mDemoSlider.addOnPageChangeListener(this);

        // ----------------- Tambah Sliding Image ---------------------------
    }

    private View.OnClickListener clickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.panorama:
                    Bundle args = new Bundle();
                    args.putParcelable("lokasistreetview", lokasistreetview);
                    Intent intent = new Intent(DetailActivity.this, StreetViewActivity.class);
                    intent.putExtra("bundle", args);
                    startActivity(intent);
                    break;
                case R.id.petunjuklokasi:
                    Bundle args2 = new Bundle();
                    args2.putParcelable("lokasi", lokasi);
                    Intent i = new Intent(DetailActivity.this, MapsActivity.class);
                    i.putExtra("namelokasi", "Pantai Indrayanti");
                    i.putExtra("bundle", args2);
                    DetailActivity.this.startActivity(i);
                    break;
                case R.id.share:
                    setupShareIntent(location_share);
                    break;
                case R.id.petunjuk:
                    Bundle args3 = new Bundle();
                    args3.putParcelable("lokasi", lokasi);
                    Intent petunjukmap = new Intent(DetailActivity.this, MapsActivity.class);
                    petunjukmap.putExtra("namelokasi", "Pantai Indrayanti");
                    petunjukmap.putExtra("bundle", args3);
                    DetailActivity.this.startActivity(petunjukmap);
                    break;
            }
        }
    };

    //Share Methode
    private void setupShareIntent(String deskripsi) {
        picasso = (ImageView) findViewById(R.id.picasso);

        Drawable mDrawable = picasso.getDrawable();
        Bitmap mBitmap = ((BitmapDrawable)mDrawable).getBitmap();

        String path = MediaStore.Images.Media.insertImage(getContentResolver(),
                mBitmap, "Image Description", null);

        Uri google_map = Uri.parse("geo:"+deskripsi);


        Uri uri = Uri.parse(path);
        share_action = new Intent();
        //share_action.setType("text/plain");
        share_action.setAction(Intent.ACTION_SEND);
        share_action.putExtra(Intent.EXTRA_STREAM, uri);

        share_action.putExtra(Intent.EXTRA_SUBJECT,"Link");
        share_action.putExtra(Intent.EXTRA_TEXT, "http://maps.google.co.in/maps?q="+deskripsi);
        //share_action.putExtra(Intent.EXTRA_TEXT, deskripsi);
        share_action.setType("image/*");
        //share_action.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
        startActivity(Intent.createChooser(share_action, "Share Image"));


    }

    @Override
    protected void onStop() {
        // To prevent a memory leak on rotation, make sure to call stopAutoCycle() on the slider before activity or fragment is destroyed
        mDemoSlider.stopAutoCycle();
        super.onStop();
    }

    @Override
    public void onSliderClick(BaseSliderView slider) {
        Toast.makeText(this,slider.getBundle().get("extra") + "",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {}

    @Override
    public void onPageSelected(int position) {
        Log.d("Slider Demo", "Page Changed: " + position);
    }

    @Override
    public void onPageScrollStateChanged(int state) {}

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_detail, menu);
        return true;
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
        mMap.setMyLocationEnabled(true);
        //    mMap.setTrafficEnabled(true);

        // Add a marker in Sydney and move the camera

        //to show current location in the map

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

                try {
                    Geocoder geo = new Geocoder(this.getApplicationContext(), Locale.getDefault());
                    List<Address> addresses = geo.getFromLocation(location.getLatitude(), location.getLongitude(), 1);
                    if (addresses.isEmpty()) {
                        tvlokasisaya.setText("Waiting for Location");
                    }
                    else {
                        if (addresses.size() > 0) {
                            tvlokasisaya.setText(addresses.get(0).getFeatureName() + ", " + addresses.get(0).getLocality() +", " + addresses.get(0).getAdminArea() + ", " + addresses.get(0).getCountryName());
                            //Toast.makeText(getApplicationContext(), "Address:- " + addresses.get(0).getFeatureName() + addresses.get(0).getAdminArea() + addresses.get(0).getLocality(), Toast.LENGTH_LONG).show();
                        }
                    }
                }
                catch (Exception e) {
                    e.printStackTrace(); // getFromLocation() may sometimes fail
                }
            } else if (i<2) {
                point = lokasi;

                try {
                    Geocoder geo = new Geocoder(this.getApplicationContext(), Locale.getDefault());
                    List<Address> addresses = geo.getFromLocation(lokasi.latitude, lokasi.longitude, 1);
                    if (addresses.isEmpty()) {
                        tvlokasitujuan.setText("Waiting for Location");
                    }
                    else {
                        if (addresses.size() > 0) {
                            tvlokasitujuan.setText(addresses.get(0).getFeatureName() + ", " + addresses.get(0).getLocality() +", " + addresses.get(0).getAdminArea() + ", " + addresses.get(0).getCountryName());
                            //Toast.makeText(getApplicationContext(), "Address:- " + addresses.get(0).getFeatureName() + addresses.get(0).getAdminArea() + addresses.get(0).getLocality(), Toast.LENGTH_LONG).show();
                        }
                    }
                }
                catch (Exception e) {
                    e.printStackTrace(); // getFromLocation() may sometimes fail
                }

                if (name.equalsIgnoreCase("Pantai Indrayanti")) {
                    mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(point, 9.0f));
                } else if (name.equalsIgnoreCase("Pantai Parangtritis")) {
                    mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(point, 10.0f));
                } else if (name.equalsIgnoreCase("Pantai Siung")) {
                    mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(point, 9.0f));
                }

                //Museum
                else if (name.equalsIgnoreCase("Museum Keraton Yogyakarta")) {
                    mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(point, 13.0f));
                }else if (name.equalsIgnoreCase("Museum Sonobudoyo")) {
                    mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(point, 13.0f));
                }else if (name.equalsIgnoreCase("Museum Affandi")) {
                    mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(point, 14.0f));
                }

                //Candi
                else if (name.equalsIgnoreCase("Candi Prambanan")) {
                    mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(point, 11.0f));
                }else if (name.equalsIgnoreCase("Candi Borobudur")) {
                    mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(point, 10.0f));
                }else if (name.equalsIgnoreCase("Candi Sambisari")) {
                    mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(point, 12.0f));
                }

                //Kuliner
                else if (name.equalsIgnoreCase("The House of Raminten")) {
                    mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(point, 13.0f));
                }else if (name.equalsIgnoreCase("Gudeg Yu Djum")) {
                    mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(point, 12.0f));
                }else if (name.equalsIgnoreCase("The Kalimilk")) {
                    mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(point, 14.0f));
                }

                //Belanja
                else if (name.equalsIgnoreCase("Malioboro")) {
                    mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(point, 12.0f));
                }else if (name.equalsIgnoreCase("Beringharjo")) {
                    mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(point, 12.0f));
                }else if (name.equalsIgnoreCase("Kasongan")) {
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

}