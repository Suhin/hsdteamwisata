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
import android.widget.ImageView;
import android.widget.TextView;

import com.bluejamesbond.text.DocumentView;
import com.bluejamesbond.text.style.TextAlignment;
import com.google.android.gms.maps.model.LatLng;

public class DetailActivity extends AppCompatActivity {

    private TextView txtdetail;
    private String yourstring;
    private DocumentView dc;
    private Spannable span;
    private ImageView imageSet;
    private LatLng lokasi;
    private LatLng lokasistreetview;
    private String name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

     /*   FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(DetailActivity.this,MapsActivity.class);
                DetailActivity.this.startActivity(i);
            }
        });*/

        txtdetail = (TextView)findViewById(R.id.txt_detail);
        imageSet = (ImageView)findViewById(R.id.imageSet);

        Intent fromIn = getIntent();
        name = fromIn.getStringExtra("name");
        txtdetail.setText(String.valueOf(name));

        //Pantai
        if (name.equalsIgnoreCase("Pantai Indrayanti")) {
            lokasi = new LatLng(-8.1501016,110.6121118);
            yourstring = getResources().getString(R.string.prambanan_text);
            imageSet.setImageResource(R.drawable.prambanan);
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
            imageSet.setImageResource(R.drawable.prambanan);
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
            imageSet.setImageResource(R.drawable.prambanan);
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
            imageSet.setImageResource(R.drawable.prambanan);
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
            imageSet.setImageResource(R.drawable.prambanan);
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
            imageSet.setImageResource(R.drawable.prambanan);
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
            imageSet.setImageResource(R.drawable.prambanan);
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
            imageSet.setImageResource(R.drawable.prambanan);
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
            imageSet.setImageResource(R.drawable.prambanan);
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
            imageSet.setImageResource(R.drawable.prambanan);
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
            imageSet.setImageResource(R.drawable.prambanan);
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
            imageSet.setImageResource(R.drawable.prambanan);
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
            imageSet.setImageResource(R.drawable.prambanan);
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
            imageSet.setImageResource(R.drawable.prambanan);
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
            imageSet.setImageResource(R.drawable.prambanan);
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
