package com.swahilipothub.arostonoma;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;


/**
 * Created by ZoomIT User1 on 8/28/2016.
 */
public class RehabAdapter extends RecyclerView.Adapter<RehabCustomViewHolder>{

    List<RehabListItems> list_items;
    private Context mContext;


    public RehabAdapter(Context contexts, List<RehabListItems> list_items){

        this.list_items = list_items;
        this.mContext = contexts;
    }




    @Override
    public RehabCustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.rehab_card_layout, parent, false);

        RehabCustomViewHolder rehabCustomViewHolder = new RehabCustomViewHolder(v);

        return rehabCustomViewHolder;
    }



    @Override
    public void onBindViewHolder(RehabCustomViewHolder customViewHolder, int position) {

        customViewHolder.lable.setText(list_items.get(position).getCategory());

        customViewHolder.setClickListener(new ListViewClickListener() {
            @Override
            public void itemClicked(View view, int position) {

                String listItem = list_items.get(position).getCategory();


                if (listItem.startsWith(mContext.getString(R.string.addiction)))
                {

                    openP1(mContext.getString(R.string.addiction));

                }
                else if(listItem.startsWith(mContext.getString(R.string.consequences)))
                {

                    openP2(mContext.getString(R.string.consequences));
                }
                else if(listItem.startsWith(mContext.getString(R.string.basic)))
                {
                    openP3(mContext.getString(R.string.basic));

                }
                else if(listItem.startsWith(mContext.getString(R.string.treatment)))
                {
                    openP4(mContext.getString(R.string.treatment));

                }
                else if(listItem.startsWith(mContext.getString(R.string.successful_treatment)))
                {
                    openP5(mContext.getString(R.string.successful_treatment));

                }
                else if(listItem.startsWith(mContext.getString(R.string.heroin_addiction)))
                {
                    openP6(mContext.getString(R.string.heroin_addiction));

                }

                else if(listItem.startsWith(mContext.getString(R.string.stages_change_model)))
                {

                    openP7(mContext.getString(R.string.stages_change_model));
                }







            }
        });

    }

    @Override
    public int getItemCount() {

        return list_items.size();
    }

    private void openP1(String name) {

        Intent intent = new Intent(mContext,DetailView.class);

        intent.putExtra(AppConstants.REHAB_DETAIL_VIEW_TITLE,name);
        intent.putExtra(AppConstants.REHAB_DETAIL_VIEW_CONTENT,mContext.getString(R.string.whats_drug_addiction));

        mContext.startActivity(intent);
    }

    private void openP2(String name) {

        Intent intent = new Intent(mContext,DetailView.class);

        intent.putExtra(AppConstants.REHAB_DETAIL_VIEW_TITLE,name);
        intent.putExtra(AppConstants.REHAB_DETAIL_VIEW_CONTENT,mContext.getString(R.string.drug_consequences));



        mContext.startActivity(intent);
    }

    private void openP3(String name) {

        Intent intent = new Intent(mContext,DetailView.class);

        intent.putExtra(AppConstants.REHAB_DETAIL_VIEW_TITLE,name);
        intent.putExtra(AppConstants.REHAB_DETAIL_VIEW_CONTENT,mContext.getString(R.string.basic_of_addiction));



        mContext.startActivity(intent);
    }

    private void openP4(String name) {

        Intent intent = new Intent(mContext,DetailView.class);

        intent.putExtra(AppConstants.REHAB_DETAIL_VIEW_TITLE,name);
        intent.putExtra(AppConstants.REHAB_DETAIL_VIEW_CONTENT,mContext.getString(R.string.basic_treatment));



        mContext.startActivity(intent);
    }

    private void openP5(String name) {

        Intent intent = new Intent(mContext,DetailView.class);

        intent.putExtra(AppConstants.REHAB_DETAIL_VIEW_TITLE,name);
        intent.putExtra(AppConstants.REHAB_DETAIL_VIEW_CONTENT,mContext.getString(R.string.successful_treatment_steps));



        mContext.startActivity(intent);
    }

    private void openP6(String name) {

        Intent intent = new Intent(mContext,DetailView.class);

        intent.putExtra(AppConstants.REHAB_DETAIL_VIEW_TITLE,name);
        intent.putExtra(AppConstants.REHAB_DETAIL_VIEW_CONTENT,mContext.getString(R.string.treatment_principles_of_heroine));



        mContext.startActivity(intent);
    }

    private void openP7(String name) {

        Intent intent = new Intent(mContext,DetailView.class);

        intent.putExtra(AppConstants.REHAB_DETAIL_VIEW_TITLE,name);
        intent.putExtra(AppConstants.REHAB_DETAIL_VIEW_CONTENT,mContext.getString(R.string.stages_of_change_model));



        mContext.startActivity(intent);
    }




}
