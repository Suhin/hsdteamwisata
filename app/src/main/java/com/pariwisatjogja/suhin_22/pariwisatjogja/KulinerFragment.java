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
public class KulinerFragment extends Fragment{
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
        personArrayList.add(new DataItem("House of Raminten", "Kotabaru, Daerah Istimewa Yogyakarta", R.drawable.prambanan));
        personArrayList.add(new DataItem("Gudeg Yu Djum", "Jl. Wijilan, Daerah Istimewa Yogyakarta", R.drawable.pantaiparangtritis));
        personArrayList.add(new DataItem("The Kalimilk", "Jl. Kaliurang, Daerah Istimewa Yogyakarta", R.drawable.resorkaliurang));
    }
}
