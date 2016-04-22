package com.pariwisatjogja.suhin_22.pariwisatjogja;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Spannable;
import android.text.SpannableString;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bluejamesbond.text.DocumentView;
import com.bluejamesbond.text.style.TextAlignment;

public class DetailActivity extends AppCompatActivity {

    private TextView txtdetail;
    private String yourstring;
    private DocumentView dc;
    private Spannable span;
    private ImageView imageSet;

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
        String name = fromIn.getStringExtra("name");
        txtdetail.setText(String.valueOf(name));

        if (name.equalsIgnoreCase("Candi Prambanan")) {
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
            yourstring = getResources().getString(R.string.prambanan_text);
            imageSet.setImageResource(R.drawable.malioboro);
        }else if (name.equalsIgnoreCase("Keraton Yogyakarta")) {
            yourstring = getResources().getString(R.string.prambanan_text);
            imageSet.setImageResource(R.drawable.kratonyogyakarta2);
        }else if (name.equalsIgnoreCase("Museum Sonobudoyo")) {
            yourstring = getResources().getString(R.string.prambanan_text);
            imageSet.setImageResource(R.drawable.museumsonobudoyo);
        }else if (name.equalsIgnoreCase("Candi Plaosan")) {
            yourstring = getResources().getString(R.string.prambanan_text);
            imageSet.setImageResource(R.drawable.candiplaosan);
        }else if (name.equalsIgnoreCase("Pantai Baron")) {
            yourstring = getResources().getString(R.string.prambanan_text);
            imageSet.setImageResource(R.drawable.pantaiparangtritis);
        }else if (name.equalsIgnoreCase("Kotagede")) {
            yourstring = getResources().getString(R.string.prambanan_text);
            imageSet.setImageResource(R.drawable.kotagede);
        }else if (name.equalsIgnoreCase("Goa Selarong")) {
            yourstring = getResources().getString(R.string.prambanan_text);
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
}
