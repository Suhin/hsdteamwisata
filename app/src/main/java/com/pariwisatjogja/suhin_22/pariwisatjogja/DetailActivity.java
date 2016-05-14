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
            //Slider Image
            url_maps = new HashMap<String, String>();
            url_maps.put("Hannibal", "http://cdn3.nflximg.net/images/3093/2043093.jpg");
            url_maps.put("Big Bang Theory", "http://tvfiles.alphacoders.com/100/hdclearart-10.png");
            url_maps.put("House of Cards", "http://cdn3.nflximg.net/images/3093/2043093.jpg");
            url_maps.put("Game of Thrones", "http://images.boomsbeat.com/data/images/full/19640/game-of-thrones-season-4-jpg.jpg");
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
