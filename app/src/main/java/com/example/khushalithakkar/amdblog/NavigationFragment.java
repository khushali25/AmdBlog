package com.example.khushalithakkar.amdblog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.CallbackManager;
import com.facebook.FacebookSdk;
import com.facebook.share.widget.LikeView;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;


import static android.R.attr.fragment;


/**
 * A simple {@link Fragment} subclass.
 */
public class NavigationFragment extends Fragment{

    private static RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private static RecyclerView recyclerView;
    static ArrayList<Bean> Bean;
    static View.OnClickListener myOnClickListener;
    ViewPager mViewPager;
    int count;
    private CallbackManager callbackManager;

    public NavigationFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FacebookSdk.sdkInitialize(getActivity().getApplicationContext());

        // Create a callbackManager to handle the login responses.
        callbackManager = CallbackManager.Factory.create();

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_navigation, container, false);
        mViewPager = (ViewPager) view.findViewById(R.id.viewPageAndroid);
        ImageAdapter adapterView = new ImageAdapter(getActivity());
        mViewPager.setAdapter(adapterView);

        Timer timer1 = new Timer();
        timer1.scheduleAtFixedRate(new MyTimerTask(),500,2000);

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

    public class MyTimerTask extends TimerTask{

        @Override
        public void run() {
            if(getActivity() == null)
                return;

            getActivity().runOnUiThread(new Runnable() {
                @Override
                public void run() {

                    if (count <= 2) {
                          mViewPager.setCurrentItem(count);
                            count++;
                        } else {
                            count = 0;
                            mViewPager.setCurrentItem(count);
                        }
                }
            });

        }
    }
    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setLikeButton(view);
    }

    private void setLikeButton(View view) {
        LikeView likeView = (LikeView) view.findViewById(R.id.likeView);
        likeView.setLikeViewStyle(LikeView.Style.STANDARD);
        likeView.setFragment(this);
        likeView.setAuxiliaryViewPosition(LikeView.AuxiliaryViewPosition.INLINE);

        String pageUrlToLike = "http://amdavadblogs.apps-1and1.com";
        likeView.setObjectIdAndType(pageUrlToLike, LikeView.ObjectType.PAGE);

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

//            FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
//            fragmentManager.beginTransaction().add(R.id.frcontent, pf).commit();
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        // Handle Facebook Login Result
        callbackManager.onActivityResult(requestCode, resultCode, data);
    }
}