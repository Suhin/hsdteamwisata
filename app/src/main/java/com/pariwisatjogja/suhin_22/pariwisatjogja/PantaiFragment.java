package com.pariwisatjogja.suhin_22.pariwisatjogja;

import android.location.LocationManager;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import android.support.v7.widget.LinearLayoutManager;


public class PantaiFragment extends Fragment {

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
        personArrayList.add(new DataItem("Pantai Indrayanti", "Jl. Pantai Sel. Jawa, Wonosari, Daerah Istimewa Yogyakarta", R.drawable.p_ind_));
        personArrayList.add(new DataItem("Pantai Parangtritis", "Jl. Parangtritis Km. 28, Daerah Istimewa Yogyakarta ", R.drawable.p_prt_1));
        personArrayList.add(new DataItem("Pantai Siung", "Desa Purwodadi, Kabupaten Gunungkidul, Daerah Istimewa Yogyakarta", R.drawable.p_siu_4));
    }
}
