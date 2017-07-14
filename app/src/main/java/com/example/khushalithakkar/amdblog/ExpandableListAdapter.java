package com.example.khushalithakkar.amdblog;

import android.content.Intent;
import android.graphics.Color;

import android.widget.BaseExpandableListAdapter;
import java.util.HashMap;
import java.util.List;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import static java.security.AccessController.getContext;

/**
 * Created by Khushali Thakkar on 7/13/2017.
 */

public class ExpandableListAdapter extends BaseExpandableListAdapter  {

    Context context;
    LayoutInflater layoutInflater;

    Button submit,btnmap;
    EditText edtfname,edtlname,edtemail,edtmsg;

    public ExpandableListAdapter(Context context, LayoutInflater layoutInflater) {
        this.context = context;
        this.layoutInflater = layoutInflater;
    }

    @Override
    public boolean areAllItemsEnabled() {
        return true;
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return null;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return 0;
    }

    @Override
    public View getChildView(final int groupPosition, int childPosition,
                             boolean isLastChild, final View convertView, ViewGroup parent) {

        View v = null;
        if(groupPosition == 0) {
            v = View.inflate(context, R.layout.expandable_child_1_layout, null);
            submit = (Button)v.findViewById(R.id.btnsubmit);
            edtfname = (EditText)v.findViewById(R.id.fnameedt);
            edtlname = (EditText)v.findViewById(R.id.lnameedt);
            edtemail = (EditText)v.findViewById(R.id.emailedt);
            edtmsg = (EditText)v.findViewById(R.id.msgedt);
            submit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(edtfname.getText().toString().equals("")){
                        edtfname.setError("please enter first name");
                    }
                    else if(edtlname.getText().toString().equals("")){
                        edtlname.setError("please enter last name");
                    }
                    else if(edtemail.getText().toString().equals("")){
                        edtemail.setError("please enter email id");
                    }
                    else if(edtmsg.getText().toString().equals("")){
                        edtmsg.setError("please enter message");
                    }
                    else if (!edtemail.getText().toString().contains("@") || !edtemail.getText().toString().contains(".")){
                        edtemail.setError("Please enter a valid email Address");}

                    else{
                        Toast.makeText(context,"Thank You", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
        if(groupPosition == 1) {

            v = View.inflate(context, R.layout.expandable_child_layout, null);
            //TextView txtView = (TextView) v.findViewById(R.id.txtChld1);
            //txtView.setText("Green");
            // txtView.setTextSize(15f);
            //  txtView.setBackgroundColor(Color.GREEN);

        }
        if(groupPosition == 2) {
            v = View.inflate(context, R.layout.expandable_child_2_layout, null);
            btnmap = (Button)v.findViewById(R.id.mapbtn);

            //FrameLayout mMap = (FrameLayout)convertView.findViewById(R.id.map).getMap();

            btnmap.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i = new Intent(context,ActivityMap.class);
                    context.startActivity(i);
                     // onMapReady(mMap);
                    }
            });
        }

        v.invalidate();
        return v;
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return 1;
    }

    @Override
    public long getCombinedChildId(long groupId, long childId) {
        return 0;
    }

    @Override
    public long getCombinedGroupId(long groupId) {
        return 0;
    }

    @Override
    public Object getGroup(int groupPosition) {
        return null;
    }

    @Override
    public int getGroupCount() {
        return 3;
    }

    @Override
    public long getGroupId(int groupPosition) {
        return 0;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded,
                             View convertView, ViewGroup parent) {

        View v = convertView.inflate(context, R.layout.expandable_group_layout, null);
        TextView txtView = (TextView) v.findViewById(R.id.txt1);
        if(groupPosition == 0) {
            txtView.setText("Contact Form");
            txtView.setTextSize(25f);
        }
        if(groupPosition == 1) {
            txtView.setText("Address");
            txtView.setTextSize(25f);
        }
        if(groupPosition == 2) {
            txtView.setText("Find in Map");
            txtView.setTextSize(25f);
        }

        v.invalidate();
        return v;

    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public void onGroupCollapsed(int groupPosition) {

    }

    @Override
    public void onGroupExpanded(int groupPosition) {

    }

//    @Override
//    public void onMapReady(GoogleMap googleMap) {
//        GoogleMap mMap;
//        mMap = googleMap;
//        LatLng sydney = new LatLng(23.0225,72.5714);
//        mMap.addMarker(new MarkerOptions().position(sydney).title("Ahmedabad"));
//        mMap.setMinZoomPreference(8);
//        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
//    }

//    @Override
//    public void registerDataSetObserver(DataSetObserver observer) {
//
//    }
//
//    @Override
//    public void unregisterDataSetObserver(DataSetObserver observer) {
//
//    }

}
