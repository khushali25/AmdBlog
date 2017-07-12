package com.example.khushalithakkar.amdblog;

import android.content.Intent;
import android.graphics.Point;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;


public class NavigationActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private Fragment fragment;
    private FragmentManager fragmentManager;
    private PopupMenu popupMenu;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        PostDetailFragment fragment1 = new PostDetailFragment();
        FragmentManager manager = getSupportFragmentManager();
        manager.beginTransaction()
                .replace(R.id.frcontent, fragment1)
                .addToBackStack(null)
                .commit();

        BottomNavigationView bottomNavigationView = (BottomNavigationView)findViewById(R.id.bottom_navigation);
        BottomNavigationViewHelper.disableShiftMode(bottomNavigationView);

        fragmentManager = getSupportFragmentManager();
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                switch (id){
                    case R.id.homenav:
//                        Intent i = new Intent(this,NavigationFragment.class);
//                        startActivity(i);
                        fragment = new NavigationFragment();
                        break;
                    case R.id.flavofamd:
                        fragment = new FlavAmdavadFragment();
                        break;
                    case R.id.newsamd:
                        fragment = new FlavAmdavadFragment();
                        break;
                    case R.id.exploreamd:
                        fragment = new FlavAmdavadFragment();
                        break;
                    case R.id.thingsamd:
                        fragment = new FlavAmdavadFragment();
                        break;
                }
                final FragmentTransaction transaction = fragmentManager.beginTransaction();
                transaction.add(R.id.frcontent,fragment).commit();
                return true;
            }
        });


//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
////                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
////                        .setAction("Action", null).show();
//                shareIt();
//            }
//        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        //Intent intent = new Intent(NavigationActivity.this, MainActivity.class);
       // startActivity(intent);
        NavigationFragment nf = new NavigationFragment();
        android.support.v4.app.FragmentTransaction ft= getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.frcontent, nf);
        ft.commit();
    }


    private void shareIt() {
    //sharing implementation here
        Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
        sharingIntent.setType("text/plain");
        sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "Amdavad Blogs");
        sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, "Now follow latest blogs with Amdavad Blogs click here to visit http://amdavadblogs.apps-1and1.com/ ");
        startActivity(Intent.createChooser(sharingIntent, "Share via"));
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.navigation, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        if (id == R.id.share) {
            shareIt();
        }
//        if (id == R.id.subscribe) {
//
//
//        }

        return super.onOptionsItemSelected(item);
    }
//


    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();


        Fragment fragment=null;


        if (id == R.id.home) {
            Intent intent=new Intent(this,NavigationActivity.class);
            startActivity(intent);

        } else if (id == R.id.flav_amdavad) {
            fragment= new FlavAmdavadFragment();

        } else if (id == R.id.news_cat) {
            //fragment = Frag1.getInstance("Catering");

        } else if (id == R.id.exp_amdavad) {
            //fragment = Frag1.getInstance("Catering");

        } else if (id == R.id.things_todo) {
           // fragment = Frag1.getInstance("Catering");

        } else if (id == R.id.nav_send) {
            //fragment = Frag1.getInstance("Catering");

        }
        if(fragment!=null)
        {
            FragmentTransaction ft=getSupportFragmentManager().beginTransaction();
            ft.add(R.id.frcontent,fragment);
            ft.addToBackStack(fragment.getClass().getName());
            ft.commit();
        }
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


    }

