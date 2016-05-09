package com.pariwisatjogja.suhin_22.pariwisatjogja;

import android.content.Intent;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.astuetz.PagerSlidingTabStrip;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements LocationListener{

    private RecyclerView recyclerView;
    private RecyclerAdapter adapter;
    private ArrayList<DataItem> personArrayList;
    private boolean gender;

    private LocationManager locationManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        toolbar.setNavigationIcon(R.mipmap.pagoda);

        ViewPager pager = (ViewPager) findViewById(R.id.pager);
        pager.setAdapter(new MyPagerAdapter(getSupportFragmentManager()));

        PagerSlidingTabStrip tabs = (PagerSlidingTabStrip)findViewById(R.id.tabs);
        tabs.setViewPager(pager);

//        personArrayList = new ArrayList<>();
//
//        recyclerView = (RecyclerView)findViewById(R.id.recycle_view);
//        recyclerView.setHasFixedSize(true);
//
//        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
//        recyclerView.setLayoutManager(layoutManager);
//
//        setRecyclerViewData(); //adding data to array list
//        adapter = new RecyclerAdapter(this, personArrayList);
//        recyclerView.setAdapter(adapter);

    }

    private void setRecyclerViewData() {
        personArrayList.add(new DataItem("Candi Prambanan", "Prambanan, Daerah Istimewa Yogyakarta", R.drawable.prambanan));
        personArrayList.add(new DataItem("Pantai Parangtritis", "Kecamatan Kretek, Bantul, Daerah Istimewa Yogyakarta", R.drawable.pantaiparangtritis));
        personArrayList.add(new DataItem("Resor Kaliurang", "Desa Hargobinangun, Kec. Pakem, Sleman, Daerah Istimewa Yogyakarta", R.drawable.resorkaliurang));
        personArrayList.add(new DataItem("Malioboro", "Jl. Malioboro, Daerah Istimewa Yogyakarta", R.drawable.malioboro));
        personArrayList.add(new DataItem("Keraton Yogyakarta", "Jl. Alun-Alun Utara, Daerah Istimewa Yogyakarta", R.drawable.kratonyogyakarta2));
        personArrayList.add(new DataItem("Museum Sonobudoyo", "Jl. Trikora No. 6, Pendowoharjo, Daerah Istimewa Yogyakarta", R.drawable.museumsonobudoyo));
        personArrayList.add(new DataItem("Candi Plaosan", "Kokosan, Prambanan, Jawa Tengah", R.drawable.candiplaosan));
        personArrayList.add(new DataItem("Pantai Baron", "Kanigoro, Daerah Istimewa Yogyakarta", R.drawable.pantaiparangtritis));
        personArrayList.add(new DataItem("Kotagede", "Kotagede, Daerah Istimewa Yogyakarta", R.drawable.kotagede));
        personArrayList.add(new DataItem("Goa Selarong", "Guwosari, Pajangan, Bantul, Daerah Istimewa Yogyakarta", R.drawable.goajomblang));

        /*personArrayList.add(new DataItem("Goa Jomblang", "Padukuhan Jetis Wetan, Kabupaten Gunungkidul, Daerah Istimewa Yogyakarta", R.drawable.goajomblang));
        personArrayList.add(new DataItem("Taman Pintar Yogyakarta", "Jalan Senopati No.1-3, Kota Yogyakarta, Daerah Istimewa Yogyakarta", R.drawable.tamanpintar));*/
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        switch (item.getItemId()) {
            case R.id.action_settings: {

                return true;
            }
            default:
                return super.onOptionsItemSelected(item);
        }
    }


    @Override
    public void onLocationChanged(Location location) {

    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {

    }

    @Override
    public void onProviderEnabled(String provider) {

    }

    @Override
    public void onProviderDisabled(String provider) {

    }
}
