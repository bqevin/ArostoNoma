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
public class RehabActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;

    private RehabAdapter mAdapter;

    private RecyclerView.LayoutManager mLayoutManager;

    private String[] lables;

    private List<RehabListItems> memberlist;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.rehab_layout);

        mRecyclerView = (RecyclerView)findViewById(R.id.my_recycler_view);


        lables = getResources().getStringArray(R.array.rehab_topics);


        memberlist = new ArrayList<>();

        for(int i = 0; i < lables.length; i++){

            RehabListItems item = new RehabListItems(lables[i]);

            memberlist.add(item);
        }


        // use a linear layout manager
        mLayoutManager = new LinearLayoutManager(this);

        mRecyclerView.setLayoutManager(mLayoutManager);

        mRecyclerView.setHasFixedSize(true);

        // specify an adapter
        mAdapter = new RehabAdapter(this,memberlist);

        mRecyclerView.setAdapter(mAdapter);
    }
}
