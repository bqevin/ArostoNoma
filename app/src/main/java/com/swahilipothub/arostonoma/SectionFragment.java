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

import butterknife.BindView;
import butterknife.ButterKnife;

public class SectionFragment extends Fragment {


    private GridLayoutManager lLayout;

    @BindView(R.id.toolbarFragmentHome) Toolbar toolbar;
    @BindView(R.id.recycler_view) RecyclerView rView;

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        toolbar.setTitle("Portable rehab, with you forever!");
        toolbar.setTitleTextColor(getResources().getColor(R.color.white));
        toolbar.setBackgroundColor(getResources().getColor(R.color.shade));

        List<SectionFragObject> rowListItem = getAllItemList();
        lLayout = new GridLayoutManager(getActivity(), 2);

        rView.setHasFixedSize(true);
        rView.setLayoutManager(lLayout);

        SectionAdapter rcAdapter = new SectionAdapter(getActivity(), rowListItem);
        rView.setAdapter(rcAdapter);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.grid_view_main, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    private List<SectionFragObject> getAllItemList(){

        List<SectionFragObject> allItems = new ArrayList<SectionFragObject>();
        allItems.add(new SectionFragObject(getString(R.string.my_profile), R.drawable.profile));
        allItems.add(new SectionFragObject(getString(R.string.e_rehab), R.drawable.rehab));
        allItems.add(new SectionFragObject(getString(R.string.report_dealers), R.drawable.ok));
        allItems.add(new SectionFragObject(getString(R.string.counselling), R.drawable.help));

        return allItems;
    }


}