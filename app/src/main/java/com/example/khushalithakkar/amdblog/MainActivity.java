//package com.example.khushalithakkar.amdblog;
//
//import android.content.Context;
//import android.content.Intent;
//import android.support.v4.view.ViewPager;
//import android.support.v7.app.AppCompatActivity;
//import android.os.Bundle;
//import android.support.v7.widget.LinearLayoutManager;
//import android.support.v7.widget.RecyclerView;
//import android.view.View;
//import android.widget.ListView;
//
//import java.util.ArrayList;
//import java.util.Timer;
//import java.util.TimerTask;
//import java.util.concurrent.ScheduledExecutorService;
//import java.util.concurrent.ScheduledFuture;
//import java.util.logging.Handler;
//
//public class MainActivity extends AppCompatActivity {
//
//    private static RecyclerView.Adapter adapter;
//    private RecyclerView.LayoutManager layoutManager;
//    private static RecyclerView recyclerView;
//    private static ArrayList<Bean> Bean;
//    static View.OnClickListener myOnClickListener;
//
//    int noofsize = 5;
//    ViewPager myPager = null;
//    int count = 0;
//    Timer timer;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//       setContentView(R.layout.activity_main);
//
//        final ViewPager mViewPager = (ViewPager) findViewById(R.id.viewPageAndroid);
//        ImageAdapter adapterView = new ImageAdapter(this);
//        mViewPager.setAdapter(adapterView);
//
//        myOnClickListener = new MyOnClickListener(this);
//
//        recyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);
//        recyclerView.setHasFixedSize(true);
//
//        layoutManager = new LinearLayoutManager(this);
//        recyclerView.setLayoutManager(layoutManager);
//
//
//        //  recyclerView.setItemAnimator(new DefaultItemAnimator());
////        timer  = new Timer();
////        timer.schedule(new TimerTask() {
////            @Override
////            public void run() {
////                runOnUiThread(new Runnable() {
////                    @Override
////                    public void run() {
////                        if(count<=2){
////                            mViewPager.setCurrentItem(count);
////                            count++;
////                        }else{
////                            count = 0;
////                            mViewPager.setCurrentItem(count);
////                        }
////                    }
////                });
////            }
////        }, 500, 2000);
//
//        Bean = new ArrayList<Bean>();
//
//
//        for (int i = 0; i < MyData.IMAGE1.length; i++) {
//            Bean.add(new Bean(
//                    MyData.IMAGE1[i],
//                    //MyData.IMAGE2[i],
//                    //MyData.IMAGE3[i],
//                    MyData.NEWSNAME[i],
//                    //MyData.TITLE[i],
//                    MyData.NEWS[i],
//                    MyData.ADMIN[i]
//                    //MyData.NEWSSUB[i],
//                   // MyData.INTREST[i]
//
//
//            ));
//        }
//        adapter = new CustomAdapter(Bean);
//        recyclerView.setAdapter(adapter);
//    }
//
//
//    class MyOnClickListener implements View.OnClickListener {
//
//        private final Context context;
//
//        MyOnClickListener(Context context) {
//
//           this.context = context;
//        }
//
//
//        @Override
//        public void onClick(View v) {
//            Intent intent = new Intent(MainActivity.this, PostDetail.class);
//           startActivity(intent);
//        }
//    }
//}
