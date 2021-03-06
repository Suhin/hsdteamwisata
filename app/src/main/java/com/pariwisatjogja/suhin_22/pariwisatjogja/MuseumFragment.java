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


public class MuseumFragment extends Fragment {

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
        personArrayList.add(new DataItem("Museum Keraton Yogyakarta", "Yogyakarta, Daerah Istimewa Yogyakarta", R.drawable.mus_ker_3));
        personArrayList.add(new DataItem("Museum Sonobudoyo", "Yogyakarta, Daerah Istimewa Yogyakarta", R.drawable.mus_son_1));
        personArrayList.add(new DataItem("Museum Affandi", "Jl. Laksda Adisutjipto, Daerah Istimewa Yogyakarta", R.drawable.mus_aff_3));
    }
}
