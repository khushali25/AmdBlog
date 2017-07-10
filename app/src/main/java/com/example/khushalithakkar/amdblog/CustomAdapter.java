package com.example.khushalithakkar.amdblog;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Khushali Thakkar on 7/7/2017.
 */
public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder> {

    private ArrayList<Bean> dataSet;

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        ImageView country_photo;

       TextView newsname;

        TextView admin;
        TextView news;




        public MyViewHolder(View itemView) {
            super(itemView);
           this.country_photo = (ImageView) itemView.findViewById(R.id.country_photo);

            this.newsname = (TextView) itemView.findViewById(R.id.newsname);

            this.admin = (TextView) itemView.findViewById(R.id.admin);
            this.news = (TextView) itemView.findViewById(R.id.news);


        }
    }

    public CustomAdapter(ArrayList<Bean> data) {
        this.dataSet = data;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent,
                                           int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list, parent, false);

        view.setOnClickListener(NavigationFragment.myOnClickListener);

        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int listPosition) {

        ImageView country_photo = holder.country_photo;

        TextView newsname = holder.newsname;

        TextView admin = holder.admin;
        TextView news= holder.news;

        country_photo.setImageResource(dataSet.get(listPosition).getCountry_photo());

        newsname.setText(dataSet.get(listPosition).getNewsname());

        admin.setText(dataSet.get(listPosition).getAdmin());
        news.setText(dataSet.get(listPosition).getNews());

    }

    @Override
    public int getItemCount() {
        return dataSet.size();
    }
}
