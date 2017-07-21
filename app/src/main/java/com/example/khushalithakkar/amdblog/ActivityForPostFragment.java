package com.example.khushalithakkar.amdblog;

import android.content.Intent;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.NavUtils;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

public class ActivityForPostFragment extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_for_post_fragment);

        Toolbar toolbar2 = (Toolbar) findViewById(R.id.tb);
       // if (toolbar2 != null)// Attaching the layout to the toolbar object
        setSupportActionBar(toolbar2);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        PostDetailFragment pf = new PostDetailFragment();
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.add(R.id.frcontent1,pf,"PostDetailFragment");
        //ft.addToBackStack("PostDetailFragment");
        ft.commit();
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.header_onactivity, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.sharefromactivity) {
            shareIt();
        }
        else if(id == R.id.home) {
            Intent intent = new Intent(this,FlavAmdavadFragment.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
            //NavUtils.navigateUpFromSameTask(this);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void shareIt() {
        Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
        sharingIntent.setType("text/plain");
        sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "Amdavad Blogs");
        sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, "Now follow latest blogs with Amdavad Blogs click here to visit http://amdavadblogs.apps-1and1.com/ ");
        startActivity(Intent.createChooser(sharingIntent, "Share via"));
    }
}
