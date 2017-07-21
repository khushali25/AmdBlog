package com.example.khushalithakkar.amdblog;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class ThingsFragment extends Fragment {

    private static RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private static RecyclerView recyclerView;
    static ArrayList<Bean> Bean;
    static View.OnClickListener myOnClickListener;

    public ThingsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_things, container, false);

        recyclerView = (RecyclerView) view.findViewById(R.id.my_recycler_view3);
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

    private void runOnUiThread(Runnable runnable) {
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

            Intent i = new Intent(getActivity(),ActivityForPostFragment.class);
            startActivity(i);
        }
    }


}
