package com.pariwisatjogja.suhin_22.pariwisatjogja;

import android.location.LocationManager;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * Created by Dias Aziz on 11/05/2016.
 */
public class AlamFragment extends Fragment {
    private RecyclerAdapter adapter;
    private ArrayList<DataItem> personArrayList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        personArrayList = new ArrayList<>();
        RecyclerView recyclerView = (RecyclerView) inflater.inflate(
                R.layout.fragment_tabs, container, false);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        setRecyclerViewData(); //adding data to array list
        adapter = new RecyclerAdapter(getActivity(), personArrayList);
        recyclerView.setAdapter(adapter);
        return recyclerView;
    }

    private void setRecyclerViewData() {
        personArrayList.add(new DataItem("Candi Prambanan", "Prambanan, Daerah Istimewa Yogyakarta", R.drawable.prambanan));
        personArrayList.add(new DataItem("Pantai Parangtritis", "Kecamatan Kretek, Bantul, Daerah Istimewa Yogyakarta", R.drawable.pantaiparangtritis));
        personArrayList.add(new DataItem("Resor Kaliurang", "Desa Hargobinangun, Kec. Pakem, Sleman, Daerah Istimewa Yogyakarta", R.drawable.resorkaliurang));
        personArrayList.add(new DataItem("Kotagede", "Kotagede, Daerah Istimewa Yogyakarta", R.drawable.kotagede));
        personArrayList.add(new DataItem("Goa Selarong", "Guwosari, Pajangan, Bantul, Daerah Istimewa Yogyakarta", R.drawable.goajomblang));
    }
}
