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

        ImageView newsimage1;
        ImageView newsimage2;
        ImageView more;
        TextView newssub;
        TextView time;
        TextView news;
        TextView newsname;
        TextView intrest;


        public MyViewHolder(View itemView) {
            super(itemView);
            this.newsimage1 = (ImageView) itemView.findViewById(R.id.newsimage1);
            this.newsimage2 = (ImageView) itemView.findViewById(R.id.newsimage2);
            this.more = (ImageView) itemView.findViewById(R.id.more);
            this.newsname = (TextView) itemView.findViewById(R.id.newsname);
            this.time = (TextView) itemView.findViewById(R.id.time);
            this.news = (TextView) itemView.findViewById(R.id.news);
            this.newssub = (TextView) itemView.findViewById(R.id.newssub);
            this.intrest = (TextView) itemView.findViewById(R.id.intrest);

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

        view.setOnClickListener(MainActivity.myOnClickListener);

        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int listPosition) {



        ImageView newsimage1 = holder.newsimage1 ;
        ImageView newsimage2= holder.newsimage2;
        ImageView more= holder.more;
        TextView newssub= holder.newssub;
        TextView time= holder.time;
        TextView news= holder.news;
        TextView newsname = holder.newsname;
        TextView intrest= holder.intrest;

        newsimage1.setImageResource(dataSet.get(listPosition).getNewsimage1());
        newsimage2.setImageResource(dataSet.get(listPosition).getNewsimage2());
        more.setImageResource(dataSet.get(listPosition).getMore());
        newssub.setText(dataSet.get(listPosition).getNewssub());
        time.setText(dataSet.get(listPosition).getTime());
        news.setText(dataSet.get(listPosition).getNews());
        newsname.setText(dataSet.get(listPosition).getNewsname());
        intrest.setText(dataSet.get(listPosition).getIntrest());


    }

    @Override
    public int getItemCount() {
        return dataSet.size();
    }
}
