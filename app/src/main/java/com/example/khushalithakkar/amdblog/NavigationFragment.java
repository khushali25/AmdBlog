package com.example.khushalithakkar.amdblog;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;


/**
 * A simple {@link Fragment} subclass.
 */
public class NavigationFragment extends Fragment {

    private static RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private static RecyclerView recyclerView;
     static ArrayList<Bean> Bean;
    static View.OnClickListener myOnClickListener;
ViewPager mViewPager;

    int count;
    Timer timer1 = new Timer();

    public NavigationFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_navigation, container, false);


          mViewPager = (ViewPager) view.findViewById(R.id.viewPageAndroid);
        ImageAdapter adapterView = new ImageAdapter(getActivity());


        timer1.schedule(new TimerTask() {
            @Override
            public void run() {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        if (count < 2) {
                            mViewPager.setCurrentItem(count);
                            count++;
                        } else {
                            count = 0;
                            mViewPager.setCurrentItem(count);
                        }
                    }
                });
            }

            private void runOnUiThread(Runnable runnable) {
            }


        }, 500, 2000);

        mViewPager.setAdapter(adapterView);

        myOnClickListener = new MyOnClickListener(getFragmentManager());

        recyclerView = (RecyclerView) view.findViewById(R.id.my_recycler_view);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);


        Bean = new ArrayList<Bean>();


        for (int i = 0; i < MyData.NEWS.length; i++) {
            Bean.add(new Bean(
                    MyData.IMAGE1[i],
                    MyData.NEWSNAME[i],
                    MyData.ADMIN[i],
                    MyData.NEWS[i]
            ));
        }


        adapter = new CustomAdapter(Bean);
        recyclerView.setAdapter(adapter);
        return view;

    }


    class MyOnClickListener implements View.OnClickListener {

        private final FragmentManager context;

        MyOnClickListener(FragmentManager context) {

            this.context = context;
        }


        @Override
        public void onClick(View v) {
//            Intent intent = new Intent(getActivity(),PostDetail.class);
//            startActivity(intent);

            PostDetailFragment pf = new PostDetailFragment();
            FragmentTransaction ft = getFragmentManager().beginTransaction();
            ft.replace(R.id.frcontent, pf);
            ft.addToBackStack(null);
            ft.commit();
        }
    }


}
