package com.morales.tarea5labo;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by Karla on 18/04/2018.
 */

public class SeriesAdapter extends RecyclerView.Adapter<SeriesAdapter.SeriesViewHolder> {



    private ArrayList<Serie> series;

    @Override
    public SeriesViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_main,parent,false);
        return (new SeriesViewHolder(v));
    }

    @Override
    public void onBindViewHolder(final SeriesViewHolder holder, final int position) {
        holder.name.setText(series.get(position).getName());
        holder.img.setImageResource(series.get(position).getImg());


        holder.buttonVer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               Toast.makeText(v.getContext(), "Pelicula: "+ series.get(position).getName() + " #Pelis: " + series.get(position).getCaps() + " Descripcion: " + series.get(position).getDesc(), Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return series.size();
    }

    public static class SeriesViewHolder extends RecyclerView.ViewHolder{

        CardView card;
        TextView name;
        ImageView img;
        Button buttonVer;

        public SeriesViewHolder(View itemView){
            super(itemView);
            card = itemView.findViewById(R.id.card_view);
            name = itemView.findViewById(R.id.name);
            img = itemView.findViewById(R.id.img);
            buttonVer = itemView.findViewById(R.id.buttonVer);

        }
    }

    public SeriesAdapter(ArrayList<Serie> series){ this.series = series;}






}
