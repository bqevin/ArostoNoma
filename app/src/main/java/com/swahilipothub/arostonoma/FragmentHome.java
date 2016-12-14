package com.swahilipothub.arostonoma;



import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import java.util.ArrayList;
import java.util.List;

public class FragmentHome extends Fragment {


    private GridLayoutManager lLayout;
    RecyclerView rView;
    Toolbar toolbar;

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        toolbar.setTitle("Pick Where To Go");


        List<ItemObject> rowListItem = getAllItemList();
        lLayout = new GridLayoutManager(getActivity(), 2);

        rView.setHasFixedSize(true);
        rView.setLayoutManager(lLayout);

        RecyclerViewAdapter rcAdapter = new RecyclerViewAdapter(getActivity(), rowListItem);
        rView.setAdapter(rcAdapter);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.grid_view_main, container, false);

        rView = (RecyclerView) v.findViewById(R.id.recycler_view);
        toolbar = (Toolbar)v.findViewById(R.id.toolbarFragmentHome);


        return v;
    }

    private List<ItemObject> getAllItemList(){

        List<ItemObject> allItems = new ArrayList<ItemObject>();
        allItems.add(new ItemObject(getString(R.string.my_profile), R.drawable.profile));
        allItems.add(new ItemObject(getString(R.string.e_rehab), R.drawable.rehab));
        allItems.add(new ItemObject(getString(R.string.report_dealers), R.drawable.ok));
        allItems.add(new ItemObject(getString(R.string.counselling), R.drawable.help));

        return allItems;
    }


}