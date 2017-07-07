package com.example.khushalithakkar.amdblog;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private static RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private static RecyclerView recyclerView;
    private static ArrayList<Bean> Bean;
    static View.OnClickListener myOnClickListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myOnClickListener = new MyOnClickListener(this);

        recyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);
        recyclerView.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
      //  recyclerView.setItemAnimator(new DefaultItemAnimator());

        Bean = new ArrayList<Bean>();


        for (int i = 0; i < MyData.IMAGE1.length; i++) {
            Bean.add(new Bean(
                    MyData.IMAGE1[i],
                    MyData.IMAGE2[i],
                    MyData.IMAGE3[i],
                    MyData.NEWSNAME[i],
                    MyData.TITLE[i],
                    MyData.NEWS[i],
                    MyData.NEWSSUB[i],
                    MyData.INTREST[i]


            ));
        }



        adapter = new CustomAdapter(Bean);
        recyclerView.setAdapter(adapter);
    }


    private static class MyOnClickListener implements View.OnClickListener {

        private final Context context;

        private MyOnClickListener(Context context) {
            this.context = context;
        }


        @Override
        public void onClick(View v) {

        }
    }
}