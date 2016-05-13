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

        if (name.equalsIgnoreCase("Candi Prambanan")) {
            lokasi = new LatLng(-7.7557, 110.4896);
            yourstring = getResources().getString(R.string.prambanan_text);
            imageSet.setImageResource(R.drawable.prambanan);
            FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
            fab.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent i = new Intent(DetailActivity.this, MapsActivity.class);
                    i.putExtra("namelokasi", "Candi Prambanan");
                    DetailActivity.this.startActivity(i);
                }
            });
        } else if (name.equalsIgnoreCase("Pantai Parangtritis")) {
            yourstring = getResources().getString(R.string.parangtritis_text);
            imageSet.setImageResource(R.drawable.pantaiparangtritis);
        } else if (name.equalsIgnoreCase("Resor Kaliurang")) {
            yourstring = getResources().getString(R.string.resorkaliurang_text);
            imageSet.setImageResource(R.drawable.resorkaliurang);
        }else if (name.equalsIgnoreCase("Malioboro")) {
            yourstring = getResources().getString(R.string.malioboro_text);
            imageSet.setImageResource(R.drawable.malioboro);
        }else if (name.equalsIgnoreCase("Keraton Yogyakarta")) {
            yourstring = getResources().getString(R.string.keraton_text);
            imageSet.setImageResource(R.drawable.kratonyogyakarta2);
        }else if (name.equalsIgnoreCase("Museum Sonobudoyo")) {
            yourstring = getResources().getString(R.string.museum_sonobudoyo_text);
            imageSet.setImageResource(R.drawable.museumsonobudoyo);
        }else if (name.equalsIgnoreCase("Candi Plaosan")) {
            yourstring = getResources().getString(R.string.plaosan_text);
            imageSet.setImageResource(R.drawable.candiplaosan);
        }else if (name.equalsIgnoreCase("Pantai Baron")) {
            yourstring = getResources().getString(R.string.baron_text);
            imageSet.setImageResource(R.drawable.pantaiparangtritis);
        }else if (name.equalsIgnoreCase("Kotagede")) {
            yourstring = getResources().getString(R.string.kotagede_text);
            imageSet.setImageResource(R.drawable.kotagede);
        }else if (name.equalsIgnoreCase("Goa Selarong")) {
            yourstring = getResources().getString(R.string.selarong_text);
            imageSet.setImageResource(R.drawable.goajomblang);
        }else if (name.equalsIgnoreCase("Goa Jomblang")) {
            yourstring = getResources().getString(R.string.prambanan_text);
            imageSet.setImageResource(R.drawable.goajomblang);
        }else if (name.equalsIgnoreCase("Taman Pintar Yogyakarta")) {
            yourstring = getResources().getString(R.string.prambanan_text);
            imageSet.setImageResource(R.drawable.tamanpintar);
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
                if (name.equalsIgnoreCase("Candi Prambanan")) {
                    lokasi = new LatLng(-7.7557, 110.4896);
                }
                Bundle args = new Bundle();
                args.putParcelable("lokasi", lokasi);
                Intent intent = new Intent(this, StreetViewActivity.class);
                intent.putExtra("bundle", args);
                startActivity(intent);
            }
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
