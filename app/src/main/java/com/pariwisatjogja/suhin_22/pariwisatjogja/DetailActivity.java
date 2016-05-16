package com.pariwisatjogja.suhin_22.pariwisatjogja;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Spannable;
import android.text.SpannableString;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
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
import com.michaldrabik.tapbarmenulib.TapBarMenu;
import com.squareup.picasso.Picasso;

import java.util.HashMap;

public class DetailActivity extends AppCompatActivity implements BaseSliderView.OnSliderClickListener, ViewPagerEx.OnPageChangeListener{

    private TextView txtdetail;
    private String yourstring, location_share;
    private DocumentView dc;
    private Spannable span;
    private LatLng lokasi;
    private LatLng lokasistreetview;
    private String name;
    private SliderLayout mDemoSlider;
    private HashMap<String,String> url_maps;
    private TapBarMenu tapBarMenu;
    private ImageView share, panorama, picasso;
    private Intent share_action;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        picasso = (ImageView) findViewById(R.id.picasso);
        picasso.setVisibility(View.INVISIBLE);

//        Picasso.with(this)
//                .load("https://farm8.staticflickr.com/7672/26729522490_d23a532a3f_z.jpg")
//                .into(picasso);
        //TapBarMenu
        tapBarMenu = (TapBarMenu) findViewById(R.id.tapBarMenu);
        share = (ImageView) findViewById(R.id.share);
        panorama = (ImageView) findViewById(R.id.panorama);
        tapBarMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tapBarMenu.toggle();
            }
        });


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
            Picasso.with(this)
                    .load("https://farm8.staticflickr.com/7672/26729522490_d23a532a3f_z.jpg")
                    .into(picasso);
            url_maps.put("Pantai Indrayanti 1", "https://farm8.staticflickr.com/7672/26729522490_d23a532a3f_z.jpg");
            url_maps.put("Pantai Indrayanti 2", "https://farm8.staticflickr.com/7491/26729521710_7226e9b6dd_z.jpg");
            url_maps.put("Pantai Indrayanti 3", "https://farm8.staticflickr.com/7239/26934795661_800a8b5714_z.jpg");
            url_maps.put("Pantai Indrayanti 4", "https://farm8.staticflickr.com/7375/26729516270_b3051da2df_z.jpg");
            tambahSlidingImage();


            //parsing Latlng to Share
            lokasi = new LatLng(-8.1501016,110.6121118);
            Double l1=lokasi.latitude;
            Double l2=lokasi.longitude;
            location_share = l1.toString() + "," + l2.toString();

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
            Picasso.with(this)
                    .load("https://farm8.staticflickr.com/7672/26729522490_d23a532a3f_z.jpg")
                    .into(picasso);
            url_maps.put("Pantai Parangtritis 1", "https://farm8.staticflickr.com/7583/26729522990_209bc0c760.jpg");
            url_maps.put("Pantai Parangtritis 2", "https://farm8.staticflickr.com/7334/26397611054_71989864ab_b.jpg");
            url_maps.put("Pantai Parangtritis 3", "https://farm8.staticflickr.com/7598/26729516490_c55a1c5185_b.jpg");
            url_maps.put("Pantai Parangtritis 4", "https://farm8.staticflickr.com/7454/26969866236_570cdfbfa1_b.jpg");
            tambahSlidingImage();

            lokasi = new LatLng(-8.0252838,110.33373);
            Double l1=lokasi.latitude;
            Double l2=lokasi.longitude;
            location_share = l1.toString() + "," + l2.toString();


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
            Picasso.with(this)
                    .load("https://farm8.staticflickr.com/7672/26729522490_d23a532a3f_z.jpg")
                    .into(picasso);
            url_maps.put("Pantai Siung 1", "https://farm8.staticflickr.com/7566/26397609744_3ac978d5f6_z.jpg");
            url_maps.put("Pantai Siung 2", "https://farm8.staticflickr.com/7260/26909153892_9e2691c137_z.jpg");
            url_maps.put("Pantai Siung 3", "https://farm8.staticflickr.com/7496/26909152512_7763725873_z.jpg");
            url_maps.put("Pantai Siung 4", "https://farm8.staticflickr.com/7647/26729517250_1829747bd3_z.jpg");
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
            Picasso.with(this)
                    .load("https://farm8.staticflickr.com/7672/26729522490_d23a532a3f_z.jpg")
                    .into(picasso);
            url_maps.put("Museum Keraton Yogyakarta 1", "https://farm8.staticflickr.com/7140/26935173031_c472940875_z.jpg");
            url_maps.put("Museum Keraton Yogyakarta 2", "https://farm8.staticflickr.com/7346/27003644755_41ab06c99e_z.jpg");
            url_maps.put("Museum Keraton Yogyakarta 3", "https://farm8.staticflickr.com/7140/26935173031_c472940875_z.jpg");
            url_maps.put("Museum Keraton Yogyakarta 4", "https://farm8.staticflickr.com/7511/26397961314_19b35421b0_z.jpg");
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
            Picasso.with(this)
                    .load("https://farm8.staticflickr.com/7672/26729522490_d23a532a3f_z.jpg")
                    .into(picasso);
            url_maps.put("Museum Sonobudoyo 1", "https://farm8.staticflickr.com/7543/27040180475_ed438b2320_z.jpg");
            url_maps.put("Museum Sonobudoyo 2", "https://farm8.staticflickr.com/7616/27006732566_b6237bfa51_z.jpg");
            url_maps.put("Museum Sonobudoyo 3", "https://farm8.staticflickr.com/7393/26434488644_8ec2e7a7ea_z.jpg");
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
            Picasso.with(this)
                    .load("https://farm8.staticflickr.com/7672/26729522490_d23a532a3f_z.jpg")
                    .into(picasso);
            url_maps.put("Museum Affandi 1", "https://farm8.staticflickr.com/7209/26765954390_6c48436f97_z.jpg");
            url_maps.put("Museum Affandi 2", "https://farm8.staticflickr.com/7647/26971881101_1914fe3bff_z.jpg");
            url_maps.put("Museum Affandi 3", "https://farm8.staticflickr.com/7245/26971885361_df758d020d_z.jpg");
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
            Picasso.with(this)
                    .load("https://farm8.staticflickr.com/7672/26729522490_d23a532a3f_z.jpg")
                    .into(picasso);
            url_maps.put("Candi Prambanan 1", "https://farm8.staticflickr.com/7178/26935177251_2ab92a7894_z.jpg");
            url_maps.put("Candi Prambanan 2", "https://farm8.staticflickr.com/7754/26399606653_b26ca4c6e4_z.jpg");
            url_maps.put("Candi Prambanan 3", "https://farm8.staticflickr.com/7754/26399606653_b26ca4c6e4_z.jpg");
            url_maps.put("Candi Prambanan 4", "https://farm8.staticflickr.com/7786/26935177991_10da3a6729_z.jpg");
            url_maps.put("Candi Prambanan 5", "https://farm8.staticflickr.com/7786/26935177991_10da3a6729_z.jpg");
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
            Picasso.with(this)
                    .load("https://farm8.staticflickr.com/7672/26729522490_d23a532a3f_z.jpg")
                    .into(picasso);
            url_maps.put("Candi Sambisari 1", "https://farm8.staticflickr.com/7719/27003656345_c0448df394_z.jpg");
            url_maps.put("Candi Sambisari 2", "https://farm8.staticflickr.com/7116/26397964584_8c11c07d15_z.jpg");
            url_maps.put("Candi Sambisari 3", "https://farm8.staticflickr.com/7201/26397965054_cf05f1e163_z.jpg");
            url_maps.put("Candi Sambisari 4", "https://farm8.staticflickr.com/7266/26399605903_15c8e3d335_z.jpg");
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
            Picasso.with(this)
                    .load("https://farm8.staticflickr.com/7672/26729522490_d23a532a3f_z.jpg")
                    .into(picasso);
            url_maps.put("The House of Raminten 1", "https://farm8.staticflickr.com/7258/26397962084_d2bb01be54_z.jpg");
            url_maps.put("The House of Raminten 2", "https://farm8.staticflickr.com/7720/26397961784_e3958a9199_z.jpg");
            url_maps.put("The House of Raminten 3", "https://farm8.staticflickr.com/7487/26397962904_7d7a9b3bb0_z.jpg");
            url_maps.put("The House of Raminten 4", "https://farm8.staticflickr.com/7363/26397962504_a63c3fa262_z.jpg");
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
            Picasso.with(this)
                    .load("https://farm8.staticflickr.com/7672/26729522490_d23a532a3f_z.jpg")
                    .into(picasso);
            url_maps.put("Gudeg Yu Djum 1", "https://farm8.staticflickr.com/7790/26397963224_f116ce55b9_z.jpg");
            url_maps.put("Gudeg Yu Djum 2", "https://farm8.staticflickr.com/7746/26970106746_402e50495a_z.jpg");
            url_maps.put("Gudeg Yu Djum 3", "https://farm8.staticflickr.com/7508/26397963434_c55f8de56f_z.jpg");
            url_maps.put("Gudeg Yu Djum 4", "https://farm8.staticflickr.com/7758/26397964054_518e311003_z.jpg");
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
            Picasso.with(this)
                    .load("https://farm8.staticflickr.com/7672/26729522490_d23a532a3f_z.jpg")
                    .into(picasso);
            url_maps.put("The Kalimilk 1", "https://farm8.staticflickr.com/7653/26773981310_4f0de919e8_z.jpg");
            url_maps.put("The Kalimilk 2", "https://farm8.staticflickr.com/7599/26773981970_858c4d4193_z.jpg");
            url_maps.put("The Kalimilk 3", "https://farm8.staticflickr.com/7516/26979978611_288d28cb4f_z.jpg");
            url_maps.put("The Kalimilk 4", "https://farm8.staticflickr.com/7627/26773981820_8ece33e769_z.jpg");
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
            Picasso.with(this)
                    .load("https://farm8.staticflickr.com/7672/26729522490_d23a532a3f_z.jpg")
                    .into(picasso);
            url_maps.put("Malioboro 1", "https://farm8.staticflickr.com/7388/26399609233_989af95966_z.jpg");
            url_maps.put("Malioboro 2", "https://farm8.staticflickr.com/7579/26399608993_cae4f8eb24_z.jpg");
            url_maps.put("Malioboro 3", "https://farm8.staticflickr.com/7538/27003660585_0c6d878d98_z.jpg");
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
            Picasso.with(this)
                    .load("https://farm8.staticflickr.com/7672/26729522490_d23a532a3f_z.jpg")
                    .into(picasso);
            url_maps.put("Beringharjo 1", "https://farm8.staticflickr.com/7630/26775720500_75ceae0435_z.jpg");
            url_maps.put("Beringharjo 2", "https://farm8.staticflickr.com/7717/26955884372_3d88fd109d_z.jpg");
            url_maps.put("Beringharjo 3", "https://farm8.staticflickr.com/7192/26446572613_f32205180d_z.jpg");
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
            Picasso.with(this)
                    .load("https://farm8.staticflickr.com/7672/26729522490_d23a532a3f_z.jpg")
                    .into(picasso);
            url_maps.put("Kasongan 1", "https://farm8.staticflickr.com/7374/26982348421_b66c44cc0a_z.jpg");
            url_maps.put("Kasongan 2", "https://farm8.staticflickr.com/7253/26776286130_886e0773f6_z.jpg");
            url_maps.put("Kasongan 3", "https://farm8.staticflickr.com/7612/26776286420_a633e9f06d_z.jpg");
            url_maps.put("Kasongan 4", "https://farm8.staticflickr.com/7266/26776286940_0fdc2c1efa_z.jpg");
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

        //Share
        share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tapBarMenu.close();
                setupShareIntent(location_share);
            }
        });

        //panorama
        panorama.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle args = new Bundle();
                args.putParcelable("lokasistreetview", lokasistreetview);
                Intent intent = new Intent(DetailActivity.this, StreetViewActivity.class);
                intent.putExtra("bundle", args);
                startActivity(intent);

                tapBarMenu.close();
            }
        });

        dc = (DocumentView) findViewById(R.id.documentView);
        span = new SpannableString(yourstring);
        dc.getDocumentLayoutParams().setTextAlignment(TextAlignment.JUSTIFIED);
        dc.setText(span);

    }

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

}