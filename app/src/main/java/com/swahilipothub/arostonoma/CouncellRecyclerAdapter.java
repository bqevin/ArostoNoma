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
public class CouncellRecyclerAdapter extends RecyclerView.Adapter<CouncellCustomViewHolder> {

    List<Councelltems> list_items;
    private Context mContext;


    public CouncellRecyclerAdapter(Context contexts,List<Councelltems> list_items){

        this.list_items = list_items;
        this.mContext = contexts;
    }




    @Override
    public CouncellCustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.councelling_card_view_layout, parent, false);

        CouncellCustomViewHolder mCouncell = new CouncellCustomViewHolder(v);

        return mCouncell;
    }



    @Override
    public void onBindViewHolder(CouncellCustomViewHolder customViewHolder, int position) {

        customViewHolder.lable.setText(list_items.get(position).getCategory());
        customViewHolder.description.setText(list_items.get(position).getDescription());
        customViewHolder.imageView.setImageResource(list_items.get(position).getImage());

        customViewHolder.setClickListener(new CouncellListViewClickListener() {
            @Override
            public void itemClicked(View view, int position) {

                String listItem = list_items.get(position).getCategory();

                //Toast.makeText(mContext, " Item position " + position, Toast.LENGTH_SHORT).show();
                if (listItem.startsWith(mContext.getString(R.string.alcohol)))
                {

                    openP1(mContext.getString(R.string.alcohol));

                }
                else if(listItem.startsWith(mContext.getString(R.string.hard_drugs)))
                {

                    openP2(mContext.getString(R.string.hard_drugs));
                }
                else if(listItem.startsWith(mContext.getString(R.string.smoking)))
                {
                    openP3(mContext.getString(R.string.smoking));

                }
                else if(listItem.startsWith(mContext.getString(R.string.psycho)))
                {
                    openP4(mContext.getString(R.string.psycho));

                }else if(listItem.startsWith(mContext.getString(R.string.chew)))
                {
                    openP5(mContext.getString(R.string.chew));

                }




            }
        });

    }

    private void openP5(String string) {

        Intent intent = new Intent(mContext,DetailViewCouncelling.class);

        intent.putExtra(AppConstants.REHAB_DETAIL_VIEW_IMAGE_URL, R.drawable.tembe);
        intent.putExtra(AppConstants.REHAB_DETAIL_VIEW_TITLE,string);
        intent.putExtra(AppConstants.REHAB_DETAIL_VIEW_CONTENT,mContext.getString(R.string.chew_detail));
        intent.putExtra(AppConstants.REHAB_DETAIL_VIEW_DESCRIPTION_TITLE,AppConstants.REHAB_DETAIL_VIEW_DESCRIPTION_CONTENT);
        mContext.startActivity(intent);

    }

    private void openP4(String string) {

        Intent intent = new Intent(mContext,DetailViewCouncelling.class);

        intent.putExtra(AppConstants.REHAB_DETAIL_VIEW_IMAGE_URL, R.drawable.doc);
        intent.putExtra(AppConstants.REHAB_DETAIL_VIEW_TITLE,string);
        intent.putExtra(AppConstants.REHAB_DETAIL_VIEW_CONTENT,mContext.getString(R.string.psycho_detail));
        intent.putExtra(AppConstants.REHAB_DETAIL_VIEW_DESCRIPTION_TITLE,AppConstants.REHAB_DETAIL_VIEW_DESCRIPTION_CONTENT);
        mContext.startActivity(intent);
    }

    private void openP3(String string) {

        Intent intent = new Intent(mContext,DetailViewCouncelling.class);

        intent.putExtra(AppConstants.REHAB_DETAIL_VIEW_IMAGE_URL, R.drawable.weed);
        intent.putExtra(AppConstants.REHAB_DETAIL_VIEW_TITLE,string);
        intent.putExtra(AppConstants.REHAB_DETAIL_VIEW_CONTENT,mContext.getString(R.string.smoking_detail));
        intent.putExtra(AppConstants.REHAB_DETAIL_VIEW_DESCRIPTION_TITLE,AppConstants.REHAB_DETAIL_VIEW_DESCRIPTION_CONTENT);
        mContext.startActivity(intent);
    }

    private void openP2(String string) {

        Intent intent = new Intent(mContext,DetailViewCouncelling.class);

        intent.putExtra(AppConstants.REHAB_DETAIL_VIEW_IMAGE_URL, R.drawable.heroine);
        intent.putExtra(AppConstants.REHAB_DETAIL_VIEW_TITLE,string);
        intent.putExtra(AppConstants.REHAB_DETAIL_VIEW_CONTENT,mContext.getString(R.string.hard_drugs_details));
        intent.putExtra(AppConstants.REHAB_DETAIL_VIEW_DESCRIPTION_TITLE,AppConstants.REHAB_DETAIL_VIEW_DESCRIPTION_CONTENT);
        mContext.startActivity(intent);
    }

    @Override
    public int getItemCount() {

        return list_items.size();
    }

    private void openP1(String name) {

        Intent intent = new Intent(mContext,DetailViewCouncelling.class);

        intent.putExtra(AppConstants.REHAB_DETAIL_VIEW_IMAGE_URL, R.drawable.wine);
        intent.putExtra(AppConstants.REHAB_DETAIL_VIEW_TITLE,name);
        intent.putExtra(AppConstants.REHAB_DETAIL_VIEW_CONTENT,mContext.getString(R.string.alcohol_detail));
        intent.putExtra(AppConstants.REHAB_DETAIL_VIEW_DESCRIPTION_TITLE,AppConstants.REHAB_DETAIL_VIEW_DESCRIPTION_CONTENT);
        mContext.startActivity(intent);
    }


}
