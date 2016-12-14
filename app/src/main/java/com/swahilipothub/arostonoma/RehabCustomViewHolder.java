package com.swahilipothub.arostonoma;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

/**
 * Created by ZoomIT User1 on 8/28/2016.
 */
public class RehabCustomViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    TextView lable;

    private ListViewClickListener clickListener11;

    public RehabCustomViewHolder(View itemView) {
        super(itemView);

        itemView.setOnClickListener(this);

        lable = (TextView) itemView.findViewById(R.id.rehab_title);

    }


    public void setClickListener(ListViewClickListener itemClickListener) {

        this.clickListener11 = itemClickListener;
    }

    @Override
    public void onClick(View v) {

        this.clickListener11.itemClicked(v, getAdapterPosition());
    }
}
