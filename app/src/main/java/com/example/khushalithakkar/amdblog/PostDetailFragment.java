package com.example.khushalithakkar.amdblog;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Toast;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerSupportFragment;
import com.google.android.youtube.player.YouTubePlayerView;


/**
 * A simple {@link Fragment} subclass.
 */
public class PostDetailFragment extends Fragment {


    public PostDetailFragment() {
        // Required empty public constructor
    }
//    private static final int RECOVERY_REQUEST = 1;
//    private YouTubePlayerView youTubeView;
//    private static final String API_KEY = "AIzaSyCJftN36kldNqN9lpfoknUNwVmNFuBQGfE";
//
//    private static String VIDEO_ID = "mv6QKf84rGc";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_post_detail, container, false);
//        YouTubePlayerSupportFragment youTubePlayerFragment = YouTubePlayerSupportFragment.newInstance();
//        FragmentTransaction transaction = getChildFragmentManager().beginTransaction();
//        transaction.add(R.id.youtube_layout, youTubePlayerFragment).commit();
//        youTubePlayerFragment.initialize(API_KEY, new YouTubePlayer.OnInitializedListener() {
//
//
//            @Override
//            public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer player, boolean wasRestored) {
//                if (!wasRestored) {
//                   // player.setPlayerStyle(YouTubePlayer.PlayerStyle.CHROMELESS);
//                   // YouTubePlayer.PlayerStyle style = YouTubePlayer.PlayerStyle.MINIMAL;
//                   // player.setPlayerStyle(style);
//                    player.setShowFullscreenButton(false);
//                    player.loadVideo(VIDEO_ID);
//                    player.play();
//                }
//            }
//
//            @Override
//            public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {
//                String errorMessage = "error";
//                Toast.makeText(getActivity(), errorMessage, Toast.LENGTH_LONG).show();
//                Log.d("errorMessage:", errorMessage);
//            }
//        });
        WebView webview = (WebView)view.findViewById(R.id.webview);
        webview.setLayerType(View.LAYER_TYPE_HARDWARE,null);
               WebSettings webSetting = webview.getSettings();
      //  webSetting.setBuiltInZoomControls(true);
        webSetting.setJavaScriptEnabled(true);
        webSetting.setLoadWithOverviewMode(true);

        webSetting.setLoadsImagesAutomatically(true);
        webSetting.setDomStorageEnabled(true);
        webview.setWebChromeClient(new WebChromeClient());

           // webview.setWebViewClient(new WebViewClient());
            //startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=Hx_rwS1NTiI")));

        webview.loadUrl("file:///android_asset/content2.html");
            return view;

    }




}
