package com.example.cc.recyclerviewwithjson;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {
    Context context;
    List<ModalClass> movielist;

    public RecyclerViewAdapter(Context context, List<ModalClass> movielist) {
        this.context = context;
        this.movielist = movielist;
    }

    @NonNull
    @Override
    public RecyclerViewAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view = LayoutInflater.from(context).inflate(R.layout.listview, viewGroup, false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewAdapter.MyViewHolder myViewHolder, int i) {
        ModalClass modalClass = movielist.get(i);


        String imageurl = modalClass.getImageUrl();
        String moviewname = modalClass.getTitle();

        myViewHolder.tvMovieName.setText(moviewname);
        Picasso.get().load(imageurl).into(myViewHolder.image);


    }

    @Override
    public int getItemCount() {
        return movielist.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView tvMovieName;
        ImageView image;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            tvMovieName = itemView.findViewById(R.id.movie_name);
            image = itemView.findViewById(R.id.image_view);
        }
    }
}
