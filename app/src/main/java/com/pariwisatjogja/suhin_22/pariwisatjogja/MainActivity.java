package com.pariwisatjogja.suhin_22.pariwisatjogja;

import android.content.Intent;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
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

import com.lapism.searchview.SearchAdapter;
import com.lapism.searchview.SearchItem;
import com.lapism.searchview.SearchView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements LocationListener{

    private SearchView mSearchView;
    private int theme = 0;
    private int style = 1;

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

        mSearchView = (SearchView) findViewById(R.id.search_view);
        mSearchView.setStyle(style);
        mSearchView.setTheme(theme);
        mSearchView.setVoiceSearch(true);
        mSearchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {

            @Override
            public boolean onQueryTextSubmit(String query) {
                // Snackbar.make(getApplicationContext(), "Query: " + query, Snackbar.LENGTH_LONG).show();
                mSearchView.closeSearch(false);
                Toast.makeText(getApplicationContext(), query, Toast.LENGTH_SHORT).show();
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });

        mSearchView.setOnSearchViewListener(new SearchView.SearchViewListener() {

            @Override
            public void onSearchViewShown() {
            }

            @Override
            public void onSearchViewClosed() {
            }
        });

        List<SearchItem> mResultsList = new ArrayList<>();
        List<SearchItem> mSuggestionsList = new ArrayList<>();
        mSuggestionsList.add(new SearchItem(R.drawable.search_ic_search_black_24dp, "Candi Prambanan"));
        mSuggestionsList.add(new SearchItem(R.drawable.search_ic_search_black_24dp, "Pantai Parangtritis"));
        mSuggestionsList.add(new SearchItem(R.drawable.search_ic_search_black_24dp, "Resor Kaliurang"));


/*        mSuggestionsList.add(new SearchItem(R.drawable.search_ic_search_black_24dp, "Malioboro"));
        mSuggestionsList.add(new SearchItem(R.drawable.search_ic_search_black_24dp, "Keraton Yogyakarta"));
        mSuggestionsList.add(new SearchItem(R.drawable.search_ic_search_black_24dp, "Museum Sonobudoyo"));
        mSuggestionsList.add(new SearchItem(R.drawable.search_ic_search_black_24dp, "Candi Plaosan"));
        mSuggestionsList.add(new SearchItem(R.drawable.search_ic_search_black_24dp, "Pantai Baron"));
        mSuggestionsList.add(new SearchItem(R.drawable.search_ic_search_black_24dp, "Kotagede"));
        mSuggestionsList.add(new SearchItem(R.drawable.search_ic_search_black_24dp, "Goa Selarong"));
        mSuggestionsList.add(new SearchItem(R.drawable.search_ic_search_black_24dp, "Goa Jomblang"));
        mSuggestionsList.add(new SearchItem(R.drawable.search_ic_search_black_24dp, "Taman Pintar Yogyakarta"));*/

        SearchAdapter mSearchAdapter = new SearchAdapter(this, mResultsList, mSuggestionsList, theme);
        mSearchAdapter.setOnItemClickListener(new SearchAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                mSearchView.closeSearch(false);
                TextView mText = (TextView) view.findViewById(R.id.textView_result);
                Toast.makeText(getApplicationContext(), mText.getText(), Toast.LENGTH_SHORT).show();
  /*              Intent i = new Intent(MainActivity.this,DetailActivity.class);
                MainActivity.this.startActivity(i);
  */          }
        });
        mSearchView.setAdapter(mSearchAdapter);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        personArrayList = new ArrayList<>();

        recyclerView = (RecyclerView)findViewById(R.id.recycle_view);
        recyclerView.setHasFixedSize(true);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        setRecyclerViewData(); //adding data to array list
        adapter = new RecyclerAdapter(this, personArrayList);
        recyclerView.setAdapter(adapter);

    }

    private void setRecyclerViewData() {
        personArrayList.add(new DataItem("Candi Prambanan", "Prambanan, Daerah Istimewa Yogyakarta", R.drawable.prambanan));
        personArrayList.add(new DataItem("Pantai Parangtritis", "Kecamatan Kretek, Bantul, Daerah Istimewa Yogyakarta", R.drawable.pantaiparangtritis));
        personArrayList.add(new DataItem("Resor Kaliurang", "Desa Hargobinangun, Kec. Pakem, Sleman, Daerah Istimewa Yogyakarta", R.drawable.resorkaliurang));

/*        personArrayList.add(new DataItem("Malioboro", "Jl. Malioboro, Daerah Istimewa Yogyakarta", R.drawable.malioboro));
        personArrayList.add(new DataItem("Keraton Yogyakarta", "Jl. Alun-Alun Utara, Daerah Istimewa Yogyakarta", R.drawable.kratonyogyakarta2));
        personArrayList.add(new DataItem("Museum Sonobudoyo", "Jl. Trikora No. 6, Pendowoharjo, Daerah Istimewa Yogyakarta", R.drawable.museumsonobudoyo));
        personArrayList.add(new DataItem("Candi Plaosan", "Kokosan, Prambanan, Jawa Tengah", R.drawable.candiplaosan));
        personArrayList.add(new DataItem("Pantai Baron", "Kanigoro, Daerah Istimewa Yogyakarta", R.drawable.pantaiparangtritis));
        personArrayList.add(new DataItem("Kotagede", "Kotagede, Daerah Istimewa Yogyakarta", R.drawable.kotagede));
        personArrayList.add(new DataItem("Goa Selarong", "Guwosari, Pajangan, Bantul, Daerah Istimewa Yogyakarta", R.drawable.goajomblang));
        personArrayList.add(new DataItem("Goa Jomblang", "Padukuhan Jetis Wetan, Kabupaten Gunungkidul, Daerah Istimewa Yogyakarta", R.drawable.goajomblang));
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
            case R.id.action_search: {
                mSearchView.showSearch(true);
                return true;
            }
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void onBackPressed() {
        if (mSearchView.isSearchOpen()) {
            mSearchView.closeSearch(true);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == SearchView.SPEECH_REQUEST_CODE && resultCode == RESULT_OK) {
            List<String> matches = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
            if (matches != null && matches.size() > 0) {
                String searchWrd = matches.get(0);
                if (!TextUtils.isEmpty(searchWrd)) {
                    mSearchView.setQuery(searchWrd, false);
                }
            }
            return;
        }
        super.onActivityResult(requestCode, resultCode, data);
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
