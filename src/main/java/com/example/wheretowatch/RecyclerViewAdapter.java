package com.example.wheretowatch;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.RecyclerViewHolders> {

    private ArrayList<Movie> mMovieList;
    private LayoutInflater mInflate;
    private Context context;

    //constructor
    public RecyclerViewAdapter(Context context, ArrayList<Movie> itemList) {
        this.context = context;
        this.mInflate = LayoutInflater.from(context);
        this.mMovieList = itemList;
    }

    @NonNull
    @Override
    public RecyclerViewHolders onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = mInflate.inflate(R.layout.img_item, parent, false);
        RecyclerViewHolders viewHolder = new RecyclerViewHolders(view);
        return viewHolder;
    }




    @Override
    public void onBindViewHolder(@NonNull RecyclerViewHolders holder, int position) {

       String url = "https://image.tmdb.org/t/p/w500" + mMovieList.get(position).getPoster_path();

        Glide.with(context)
                .load(url)
                .override(300)
                .into(holder.poster);
    }




    @Override
    public int getItemCount()
    {
        return this.mMovieList.size();
    }

    public static class RecyclerViewHolders extends RecyclerView.ViewHolder {
        ImageView poster;

        public RecyclerViewHolders(View itemView) {
            super(itemView);
            poster = (ImageView) itemView.findViewById(R.id.ivPoster);
        }
    }

    }


