package com.morales.tarea5labo;

import android.app.Fragment;
import android.app.FragmentManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * Created by Karla on 25/04/2018.
 */

public class Bebida extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View vista = inflater.inflate(R.layout.my_fragment, container, false);

        rv= (RecyclerView) vista.findViewById(R.id.recycler);
        series = new ArrayList<>();
        rv.setHasFixedSize(true);
        rv.setLayoutManager(new LinearLayoutManager(getContext()));
        prepareSeries();
        adapter = new SeriesAdapter(series) {

            public void onVerClick(View v, int pos) {
                if (series.get(pos).isButtonStar()) {
                    Bundle bundle = new Bundle();
                    my_java_fragment fragmento =  new my_java_fragment();
                    fragmento.setArguments(bundle);
                    FragmentManager fragmentManager = getFragmentManager();
                    fragmentManager.beginTransaction().replace(R.id.card_view, fragmento).commit();
                }
            }
        };
        rv.setAdapter(adapter);
        return vista;
    }




    RecyclerView rv;
    SeriesAdapter adapter;
    ArrayList<Serie> series;
    LinearLayoutManager lManager;

    public void prepareSeries() {
        String TAG = "Mensaje";
        series = new ArrayList<>();
        series.add(new Serie("Cafe", "13", R.drawable.cafe, "Big Hero 6 created by Disney"));
        series.add(new Serie("Agua", "13", R.drawable.agua, "Monster inc created by Disney"));
        series.add(new Serie("Leche", "13", R.drawable.leche, "Spider Man amazing movie"));
        series.add(new Serie("Jugo de naranja", "13", R.drawable.jnarj, "Spider Man amazing movie"));


    }
}
