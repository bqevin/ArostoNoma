package com.swahilipothub.arostonoma;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ZoomIT User1 on 8/28/2016.
 */
public class CouncellingActivity extends AppCompatActivity {


    private RecyclerView mRecyclerView;

    private CouncellRecyclerAdapter mAdapter;

    private RecyclerView.LayoutManager mLayoutManager;

    private String[] lables;

    private String[] description;

    private int[] image_id;

    private List<Councelltems> memberlist;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.councelling_layout);

        mRecyclerView = (RecyclerView)findViewById(R.id.counselling_recycler_view);


        lables = getResources().getStringArray(R.array.councelling_list);

        image_id = new int[] {
                R.drawable.wine,
                R.drawable.heroine,
                R.drawable.weed,
                R.drawable.tembe,
                R.drawable.doc
        };

        description = getResources().getStringArray(R.array.councelling_list_detail);

        memberlist = new ArrayList<Councelltems>();

        for(int i = 0; i < lables.length; i++){

            Councelltems item = new Councelltems(lables[i],description[i],image_id[i]);

            memberlist.add(item);
        }


        // use a linear layout manager
        mLayoutManager = new LinearLayoutManager(this);

        mRecyclerView.setLayoutManager(mLayoutManager);

        mRecyclerView.setHasFixedSize(true);

        // specify an adapter
        mAdapter = new CouncellRecyclerAdapter(this,memberlist);


        mRecyclerView.setAdapter(mAdapter);
    }
}











