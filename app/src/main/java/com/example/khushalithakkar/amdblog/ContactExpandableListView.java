package com.example.khushalithakkar.amdblog;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ExpandableListView;


/**
 * A simple {@link Fragment} subclass.
 */
public class ContactExpandableListView extends Fragment {

    public ContactExpandableListView() {
        // Required empty public constructor
    }

    ExpandableListAdapter listAdapter;
    ExpandableListView expListView;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_contact_expandable_list_view2, container, false);
        final FragmentManager fm = getFragmentManager();
        expListView = (ExpandableListView) view.findViewById(R.id.lvExp);

        listAdapter = new ExpandableListAdapter(getActivity(), getLayoutInflater(savedInstanceState));
        Button btn = (Button)view.findViewById(R.id.btnclick);


        // setting list adapter
        expListView.setAdapter(listAdapter);



        return view;
    }


}
