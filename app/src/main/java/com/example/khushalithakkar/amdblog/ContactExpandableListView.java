package com.example.khushalithakkar.amdblog;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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

        expListView = (ExpandableListView) view.findViewById(R.id.lvExp);

        listAdapter = new ExpandableListAdapter(getActivity(), getLayoutInflater(savedInstanceState));

        // setting list adapter
        expListView.setAdapter(listAdapter);

        return view;
    }
}
