package com.pariwisatjogja.suhin_22.pariwisatjogja;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Spannable;
import android.text.SpannableString;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.bluejamesbond.text.DocumentView;
import com.bluejamesbond.text.style.TextAlignment;
import com.google.android.gms.maps.model.LatLng;

import android.util.Log;
import android.widget.Toast;

import com.daimajia.slider.library.Animations.DescriptionAnimation;
import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.TextSliderView;
import com.daimajia.slider.library.Tricks.ViewPagerEx;

import java.util.HashMap;

public class DetailActivity extends AppCompatActivity implements BaseSliderView.OnSliderClickListener, ViewPagerEx.OnPageChangeListener{

    private TextView txtdetail;
    private String yourstring;
    private DocumentView dc;
    private Spannable span;
    private LatLng lokasi;
    private LatLng lokasistreetview;
    private String name;
    private SliderLayout mDemoSlider;
    private HashMap<String,String> url_maps;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        txtdetail = (TextView)findViewById(R.id.txt_detail);
        //Slider Image
        mDemoSlider = (SliderLayout)findViewById(R.id.slider);

        Intent fromIn = getIntent();
        name = fromIn.getStringExtra("name");
        txtdetail.setText(String.valueOf(name));

        //Pantai
        if (name.equalsIgnoreCase("Pantai Indrayanti")) {
            //Slider Imagee
            url_maps = new HashMap<String, String>();
            url_maps.put("Pantai Indrayanti 1", "https://farm8.staticflickr.com/7672/26729522490_d23a532a3f_z.jpg");
            url_maps.put("Pantai Indrayanti 2", "https://farm8.staticflickr.com/7491/26729521710_7226e9b6dd_z.jpg");
            url_maps.put("Pantai Indrayanti 3", "https://farm8.staticflickr.com/7239/26934795661_800a8b5714_z.jpg");
            url_maps.put("Pantai Indrayanti 4", "https://farm8.staticflickr.com/7375/26729516270_b3051da2df_z.jpg");
            tambahSlidingImage();

            lokasi = new LatLng(-8.1501016,110.6121118);
            yourstring = getResources().getString(R.string.prambanan_text);
            FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
            fab.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Bundle args = new Bundle();
                    args.putParcelable("lokasi", lokasi);
                    Intent i = new Intent(DetailActivity.this, MapsActivity.class);
                    i.putExtra("namelokasi", "Pantai Indrayanti");
                    i.putExtra("bundle", args);
                    DetailActivity.this.startActivity(i);
                }
            });
        } else if (name.equalsIgnoreCase("Pantai Parangtritis")) {
            //Slider Imagee
            url_maps = new HashMap<String, String>();
            url_maps.put("Pantai Parangtritis 1", "https://farm8.staticflickr.com/7672/26729522490_d23a532a3f_z.jpg");
            url_maps.put("Pantai Parangtritis 2", "https://farm8.staticflickr.com/7491/26729521710_7226e9b6dd_z.jpg");
            url_maps.put("Pantai Parangtritis 3", "https://farm8.staticflickr.com/7239/26934795661_800a8b5714_z.jpg");
            url_maps.put("Pantai Parangtritis 4", "https://farm8.staticflickr.com/7375/26729516270_b3051da2df_z.jpg");
            tambahSlidingImage();

            lokasi = new LatLng(-8.0252838,110.33373);
            yourstring = getResources().getString(R.string.prambanan_text);
            FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
            fab.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Bundle args = new Bundle();
                    args.putParcelable("lokasi", lokasi);

                    Intent i = new Intent(DetailActivity.this, MapsActivity.class);
                    i.putExtra("namelokasi", "Pantai Parangtritis");
                    i.putExtra("bundle", args);
                    DetailActivity.this.startActivity(i);
                }
            });
        } else if (name.equalsIgnoreCase("Pantai Siung")) {
            //Slider Imagee
            url_maps = new HashMap<String, String>();
            url_maps.put("Pantai Siung 1", "https://farm8.staticflickr.com/7672/26729522490_d23a532a3f_z.jpg");
            url_maps.put("Pantai Siung 2", "https://farm8.staticflickr.com/7491/26729521710_7226e9b6dd_z.jpg");
            url_maps.put("Pantai Siung 3", "https://farm8.staticflickr.com/7239/26934795661_800a8b5714_z.jpg");
            url_maps.put("Pantai Siung 4", "https://farm8.staticflickr.com/7375/26729516270_b3051da2df_z.jpg");
            tambahSlidingImage();

            lokasi = new LatLng(-8.1813422,110.6823995);
            yourstring = getResources().getString(R.string.prambanan_text);
            FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
            fab.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Bundle args = new Bundle();
                    args.putParcelable("lokasi", lokasi);

                    Intent i = new Intent(DetailActivity.this, MapsActivity.class);
                    i.putExtra("namelokasi", "Pantai Siung");
                    i.putExtra("bundle", args);
                    DetailActivity.this.startActivity(i);
                }
            });
        }

        //Museum
        else if (name.equalsIgnoreCase("Museum Keraton Yogyakarta")) {
            //Slider Imagee
            url_maps = new HashMap<String, String>();
            url_maps.put("Museum Keraton Yogyakarta 1", "https://farm8.staticflickr.com/7672/26729522490_d23a532a3f_z.jpg");
            url_maps.put("Museum Keraton Yogyakarta 2", "https://farm8.staticflickr.com/7491/26729521710_7226e9b6dd_z.jpg");
            url_maps.put("Museum Keraton Yogyakarta 3", "https://farm8.staticflickr.com/7239/26934795661_800a8b5714_z.jpg");
            url_maps.put("Museum Keraton Yogyakarta 4", "https://farm8.staticflickr.com/7375/26729516270_b3051da2df_z.jpg");
            tambahSlidingImage();

            lokasi = new LatLng(-7.805224,110.36509);
            yourstring = getResources().getString(R.string.prambanan_text);
            FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
            fab.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Bundle args = new Bundle();
                    args.putParcelable("lokasi", lokasi);

                    Intent i = new Intent(DetailActivity.this, MapsActivity.class);
                    i.putExtra("namelokasi", "Museum Keraton Yogyakarta");
                    i.putExtra("bundle", args);
                    DetailActivity.this.startActivity(i);
                }
            });
        }else if (name.equalsIgnoreCase("Museum Sonobudoyo")) {
            //Slider Imagee
            url_maps = new HashMap<String, String>();
            url_maps.put("Museum Sonobudoyo 1", "https://farm8.staticflickr.com/7672/26729522490_d23a532a3f_z.jpg");
            url_maps.put("Museum Sonobudoyo 2", "https://farm8.staticflickr.com/7491/26729521710_7226e9b6dd_z.jpg");
            url_maps.put("Museum Sonobudoyo 3", "https://farm8.staticflickr.com/7239/26934795661_800a8b5714_z.jpg");
            url_maps.put("Museum Sonobudoyo 4", "https://farm8.staticflickr.com/7375/26729516270_b3051da2df_z.jpg");
            tambahSlidingImage();

            lokasi = new LatLng(-7.802859,110.364003);
            yourstring = getResources().getString(R.string.prambanan_text);
            FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
            fab.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Bundle args = new Bundle();
                    args.putParcelable("lokasi", lokasi);

                    Intent i = new Intent(DetailActivity.this, MapsActivity.class);
                    i.putExtra("namelokasi", "Museum Sonobudoyo");
                    i.putExtra("bundle", args);
                    DetailActivity.this.startActivity(i);
                }
            });
        }else if (name.equalsIgnoreCase("Museum Affandi")) {
            //Slider Imagee
            url_maps = new HashMap<String, String>();
            url_maps.put("Museum Affandi 1", "https://farm8.staticflickr.com/7672/26729522490_d23a532a3f_z.jpg");
            url_maps.put("Museum Affandi 2", "https://farm8.staticflickr.com/7491/26729521710_7226e9b6dd_z.jpg");
            url_maps.put("Museum Affandi 3", "https://farm8.staticflickr.com/7239/26934795661_800a8b5714_z.jpg");
            url_maps.put("Museum Affandi 4", "https://farm8.staticflickr.com/7375/26729516270_b3051da2df_z.jpg");
            tambahSlidingImage();

            lokasi = new LatLng(-7.783114,110.396425);
            yourstring = getResources().getString(R.string.prambanan_text);
            FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
            fab.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Bundle args = new Bundle();
                    args.putParcelable("lokasi", lokasi);

                    Intent i = new Intent(DetailActivity.this, MapsActivity.class);
                    i.putExtra("namelokasi", "Museum Affandi");
                    i.putExtra("bundle", args);
                    DetailActivity.this.startActivity(i);
                }
            });
        }

        //Candi
        else if (name.equalsIgnoreCase("Candi Prambanan")) {
            //Slider Imagee
            url_maps = new HashMap<String, String>();
            url_maps.put("Candi Prambanan 1", "https://farm8.staticflickr.com/7672/26729522490_d23a532a3f_z.jpg");
            url_maps.put("Candi Prambanan 2", "https://farm8.staticflickr.com/7491/26729521710_7226e9b6dd_z.jpg");
            url_maps.put("Candi Prambanan 3", "https://farm8.staticflickr.com/7239/26934795661_800a8b5714_z.jpg");
            url_maps.put("Candi Prambanan 4", "https://farm8.staticflickr.com/7375/26729516270_b3051da2df_z.jpg");
            tambahSlidingImage();

            lokasi = new LatLng(-7.751919,110.492006);
            yourstring = getResources().getString(R.string.prambanan_text);
            FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
            fab.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Bundle args = new Bundle();
                    args.putParcelable("lokasi", lokasi);

                    Intent i = new Intent(DetailActivity.this, MapsActivity.class);
                    i.putExtra("namelokasi", "Candi Prambanan");
                    i.putExtra("bundle", args);
                    DetailActivity.this.startActivity(i);
                }
            });
        }else if (name.equalsIgnoreCase("Candi Borobudur")) {
            //Slider Imagee
            url_maps = new HashMap<String, String>();
            url_maps.put("Candi Borobudur 1", "https://farm8.staticflickr.com/7672/26729522490_d23a532a3f_z.jpg");
            url_maps.put("Candi Borobudur 2", "https://farm8.staticflickr.com/7491/26729521710_7226e9b6dd_z.jpg");
            url_maps.put("Candi Borobudur 3", "https://farm8.staticflickr.com/7239/26934795661_800a8b5714_z.jpg");
            url_maps.put("Candi Borobudur 4", "https://farm8.staticflickr.com/7375/26729516270_b3051da2df_z.jpg");
            tambahSlidingImage();

            lokasi = new LatLng(-7.6081021,110.2037122);
            yourstring = getResources().getString(R.string.prambanan_text);
            FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
            fab.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Bundle args = new Bundle();
                    args.putParcelable("lokasi", lokasi);

                    Intent i = new Intent(DetailActivity.this, MapsActivity.class);
                    i.putExtra("namelokasi", "Candi Borobudur");
                    i.putExtra("bundle", args);
                    DetailActivity.this.startActivity(i);
                }
            });
        }else if (name.equalsIgnoreCase("Candi Sambisari")) {
            //Slider Imagee
            url_maps = new HashMap<String, String>();
            url_maps.put("Candi Sambisari 1", "https://farm8.staticflickr.com/7672/26729522490_d23a532a3f_z.jpg");
            url_maps.put("Candi Sambisari 2", "https://farm8.staticflickr.com/7491/26729521710_7226e9b6dd_z.jpg");
            url_maps.put("Candi Sambisari 3", "https://farm8.staticflickr.com/7239/26934795661_800a8b5714_z.jpg");
            url_maps.put("Candi Sambisari 4", "https://farm8.staticflickr.com/7375/26729516270_b3051da2df_z.jpg");
            tambahSlidingImage();

            lokasi = new LatLng(-7.7625465,110.4468635);
            yourstring = getResources().getString(R.string.prambanan_text);
            FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
            fab.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Bundle args = new Bundle();
                    args.putParcelable("lokasi", lokasi);

                    Intent i = new Intent(DetailActivity.this, MapsActivity.class);
                    i.putExtra("namelokasi", "Candi Sambisari");
                    i.putExtra("bundle", args);
                    DetailActivity.this.startActivity(i);
                }
            });
        }

        //Kuliner
        else if (name.equalsIgnoreCase("The House of Raminten")) {
            //Slider Imagee
            url_maps = new HashMap<String, String>();
            url_maps.put("The House of Raminten 1", "https://farm8.staticflickr.com/7672/26729522490_d23a532a3f_z.jpg");
            url_maps.put("The House of Raminten 2", "https://farm8.staticflickr.com/7491/26729521710_7226e9b6dd_z.jpg");
            url_maps.put("The House of Raminten 3", "https://farm8.staticflickr.com/7239/26934795661_800a8b5714_z.jpg");
            url_maps.put("The House of Raminten 4", "https://farm8.staticflickr.com/7375/26729516270_b3051da2df_z.jpg");
            tambahSlidingImage();

            lokasi = new LatLng(-7.7851471,110.3716593);
            yourstring = getResources().getString(R.string.prambanan_text);
            FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
            fab.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Bundle args = new Bundle();
                    args.putParcelable("lokasi", lokasi);

                    Intent i = new Intent(DetailActivity.this, MapsActivity.class);
                    i.putExtra("namelokasi", "The House of Raminten");
                    i.putExtra("bundle", args);
                    DetailActivity.this.startActivity(i);
                }
            });
        }else if (name.equalsIgnoreCase("Gudeg Yu Djum")) {
            //Slider Imagee
            url_maps = new HashMap<String, String>();
            url_maps.put("Gudeg Yu Djum 1", "https://farm8.staticflickr.com/7672/26729522490_d23a532a3f_z.jpg");
            url_maps.put("Gudeg Yu Djum 2", "https://farm8.staticflickr.com/7491/26729521710_7226e9b6dd_z.jpg");
            url_maps.put("Gudeg Yu Djum 3", "https://farm8.staticflickr.com/7239/26934795661_800a8b5714_z.jpg");
            url_maps.put("Gudeg Yu Djum 4", "https://farm8.staticflickr.com/7375/26729516270_b3051da2df_z.jpg");
            tambahSlidingImage();

            lokasi = new LatLng(-7.8046002,110.3666496);
            yourstring = getResources().getString(R.string.prambanan_text);
            FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
            fab.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Bundle args = new Bundle();
                    args.putParcelable("lokasi", lokasi);

                    Intent i = new Intent(DetailActivity.this, MapsActivity.class);
                    i.putExtra("namelokasi", "Gudeg Yu Djum");
                    i.putExtra("bundle", args);
                    DetailActivity.this.startActivity(i);
                }
            });
        }else if (name.equalsIgnoreCase("The Kalimilk")) {
            //Slider Imagee
            url_maps = new HashMap<String, String>();
            url_maps.put("The Kalimilk 1", "https://farm8.staticflickr.com/7672/26729522490_d23a532a3f_z.jpg");
            url_maps.put("The Kalimilk 2", "https://farm8.staticflickr.com/7491/26729521710_7226e9b6dd_z.jpg");
            url_maps.put("The Kalimilk 3", "https://farm8.staticflickr.com/7239/26934795661_800a8b5714_z.jpg");
            url_maps.put("The Kalimilk 4", "https://farm8.staticflickr.com/7375/26729516270_b3051da2df_z.jpg");
            tambahSlidingImage();

            lokasi = new LatLng(-7.7629085,110.3797544);
            yourstring = getResources().getString(R.string.prambanan_text);
            FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
            fab.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Bundle args = new Bundle();
                    args.putParcelable("lokasi", lokasi);

                    Intent i = new Intent(DetailActivity.this, MapsActivity.class);
                    i.putExtra("namelokasi", "The Kalimilk");
                    i.putExtra("bundle", args);
                    DetailActivity.this.startActivity(i);
                }
            });
        }

        else if (name.equalsIgnoreCase("Malioboro")) {
            //Slider Imagee
            url_maps = new HashMap<String, String>();
            url_maps.put("Malioboro 1", "https://farm8.staticflickr.com/7672/26729522490_d23a532a3f_z.jpg");
            url_maps.put("Malioboro 2", "https://farm8.staticflickr.com/7491/26729521710_7226e9b6dd_z.jpg");
            url_maps.put("Malioboro 3", "https://farm8.staticflickr.com/7239/26934795661_800a8b5714_z.jpg");
            url_maps.put("Malioboro 4", "https://farm8.staticflickr.com/7375/26729516270_b3051da2df_z.jpg");
            tambahSlidingImage();

            lokasi = new LatLng(-7.793229,110.365748);
            yourstring = getResources().getString(R.string.prambanan_text);
            FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
            fab.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Bundle args = new Bundle();
                    args.putParcelable("lokasi", lokasi);

                    Intent i = new Intent(DetailActivity.this, MapsActivity.class);
                    i.putExtra("namelokasi", "Malioboro");
                    i.putExtra("bundle", args);
                    DetailActivity.this.startActivity(i);
                }
            });
        }else if (name.equalsIgnoreCase("Beringharjo")) {
            //Slider Imagee
            url_maps = new HashMap<String, String>();
            url_maps.put("Beringharjo 1", "https://farm8.staticflickr.com/7672/26729522490_d23a532a3f_z.jpg");
            url_maps.put("Beringharjo 2", "https://farm8.staticflickr.com/7491/26729521710_7226e9b6dd_z.jpg");
            url_maps.put("Beringharjo 3", "https://farm8.staticflickr.com/7239/26934795661_800a8b5714_z.jpg");
            url_maps.put("Beringharjo 4", "https://farm8.staticflickr.com/7375/26729516270_b3051da2df_z.jpg");
            tambahSlidingImage();

            lokasi = new LatLng(-7.798672,110.365073);
            yourstring = getResources().getString(R.string.prambanan_text);
            FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
            fab.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Bundle args = new Bundle();
                    args.putParcelable("lokasi", lokasi);

                    Intent i = new Intent(DetailActivity.this, MapsActivity.class);
                    i.putExtra("namelokasi", "Beringharjo");
                    i.putExtra("bundle", args);
                    DetailActivity.this.startActivity(i);
                }
            });
        }else if (name.equalsIgnoreCase("Kasongan")) {
            //Slider Imagee
            url_maps = new HashMap<String, String>();
            url_maps.put("Kasongan 1", "https://farm8.staticflickr.com/7672/26729522490_d23a532a3f_z.jpg");
            url_maps.put("Kasongan 2", "https://farm8.staticflickr.com/7491/26729521710_7226e9b6dd_z.jpg");
            url_maps.put("Kasongan 3", "https://farm8.staticflickr.com/7239/26934795661_800a8b5714_z.jpg");
            url_maps.put("Kasongan 4", "https://farm8.staticflickr.com/7375/26729516270_b3051da2df_z.jpg");
            tambahSlidingImage();

            lokasi = new LatLng(-7.8450784,110.33561);
            yourstring = getResources().getString(R.string.prambanan_text);
            FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
            fab.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Bundle args = new Bundle();
                    args.putParcelable("lokasi", lokasi);

                    Intent i = new Intent(DetailActivity.this, MapsActivity.class);
                    i.putExtra("namelokasi", "Kasongan");
                    i.putExtra("bundle", args);
                    DetailActivity.this.startActivity(i);
                }
            });
        }

        dc = (DocumentView) findViewById(R.id.documentView);
        span = new SpannableString(yourstring);
        dc.getDocumentLayoutParams().setTextAlignment(TextAlignment.JUSTIFIED);
        dc.setText(span);

    }

    private void tambahSlidingImage() {
        // ----------------------Tambah Sliding Image -----------------------------

        for(String name : url_maps.keySet()){
            TextSliderView textSliderView = new TextSliderView(this);
            // initialize a SliderLayout
            textSliderView
                    .description(name)
                    .image(url_maps.get(name))
                    .setScaleType(BaseSliderView.ScaleType.Fit)
                    .setOnSliderClickListener(this);

            //add your extra information
            textSliderView.bundle(new Bundle());
            textSliderView.getBundle()
                    .putString("extra",name);

            mDemoSlider.addSlider(textSliderView);
        }
        mDemoSlider.setPresetTransformer(SliderLayout.Transformer.ZoomOut);
        mDemoSlider.setPresetIndicator(SliderLayout.PresetIndicators.Center_Bottom);
        mDemoSlider.setCustomAnimation(new DescriptionAnimation());
        mDemoSlider.setDuration(4000);
        mDemoSlider.addOnPageChangeListener(this);

        // ----------------- Tambah Sliding Image ---------------------------
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
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        switch (item.getItemId()) {
            case R.id.action_settings: {
                return true;
            }
            case R.id.action_user: {
                if (name.equalsIgnoreCase("Pantai Indrayanti")) {
                    lokasistreetview = new LatLng(-7.6080523,110.2037833);
                } else if (name.equalsIgnoreCase("Pantai Parangtritis")) {
                    lokasistreetview = new LatLng(-8.0252838,110.33373);
                } else if (name.equalsIgnoreCase("Pantai Siung")) {
                    lokasistreetview = new LatLng(-8.1813422,110.6823995);
                }

                //Museum
                else if (name.equalsIgnoreCase("Museum Keraton Yogyakarta")) {
                    lokasistreetview = new LatLng(-7.805224,110.36509);
                }else if (name.equalsIgnoreCase("Museum Sonobudoyo")) {
                    lokasistreetview = new LatLng(-7.802859,110.364003);
                }else if (name.equalsIgnoreCase("Museum Affandi")) {
                    lokasistreetview = new LatLng(-7.783114,110.396425);
                }

                //Candi
                else if (name.equalsIgnoreCase("Candi Prambanan")) {
                    lokasistreetview = new LatLng(-7.751919,110.492006);
                }else if (name.equalsIgnoreCase("Candi Borobudur")) {
                    lokasistreetview = new LatLng(-7.6081021,110.2037122);
                }else if (name.equalsIgnoreCase("Candi Sambisari")) {
                    lokasistreetview = new LatLng(-7.7625465,110.4468635);
                }

                //Kuliner
                else if (name.equalsIgnoreCase("The House of Raminten")) {
                    lokasistreetview = new LatLng(-7.7851471,110.3716593);
                }else if (name.equalsIgnoreCase("Gudeg Yu Djum")) {
                    lokasistreetview = new LatLng(-7.8046002,110.3666496);
                }else if (name.equalsIgnoreCase("The Kalimilk")) {
                    lokasistreetview = new LatLng(-7.7629085,110.3797544);
                }

                //Belanja
                else if (name.equalsIgnoreCase("Malioboro")) {
                    lokasistreetview = new LatLng(-7.793229,110.365748);
                }else if (name.equalsIgnoreCase("Beringharjo")) {
                    lokasistreetview = new LatLng(-7.798672,110.365073);
                }else if (name.equalsIgnoreCase("Kasongan")) {
                    lokasistreetview = new LatLng(-7.8450784,110.33561);
                }

                Bundle args = new Bundle();
                args.putParcelable("lokasistreetview", lokasistreetview);
                Intent intent = new Intent(this, StreetViewActivity.class);
                intent.putExtra("bundle", args);
                startActivity(intent);
            }
            default:
                return super.onOptionsItemSelected(item);
        }

    }
}
