package com.morales.tarea5labo;

import android.app.Fragment;
import android.app.FragmentTransaction;
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

public class my_java_fragment extends Fragment {
//INIIANDO Y RECOPILANDO DATOS
RecyclerView rv;
    SeriesAdapter adapter;
    ArrayList<Serie> series;

    Serie serieData = new Serie();
    Bundle bundle;

    public my_java_fragment(){

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View vista = inflater.inflate(R.layout.my_fragment, container, false);
        rv= (RecyclerView) vista.findViewById(R.id.recycler);
        series = new ArrayList<>();
        rv.setHasFixedSize(true);
        rv.setLayoutManager(new LinearLayoutManager(getContext()));

        bundle = getArguments();

        adapter = new SeriesAdapter(series) {
            public void Click(View v, int pos) {
            }
        };


        if(bundle!=null){
            Serie serie = (Serie)bundle.getSerializable("Bool");
            System.out.println("VALOR ES:"+serie.getName());
            series.add(0, serie);
            adapter.notifyItemInserted(0);
            adapter.notifyItemRangeChanged(0, series.size());
        }

        rv.setAdapter(adapter);
        return vista;
    }

    //FINISH





}
