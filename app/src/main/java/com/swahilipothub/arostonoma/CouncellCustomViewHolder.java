package com.swahilipothub.arostonoma;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by ZoomIT User1 on 8/28/2016.
 */
public class CouncellCustomViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        TextView lable;
        TextView description;
        ImageView imageView;

        private CouncellListViewClickListener clickListener11;

        public CouncellCustomViewHolder(View itemView) {
            super(itemView);

            itemView.setOnClickListener(this);

            lable = (TextView) itemView.findViewById(R.id.titleText);
            description = (TextView) itemView.findViewById(R.id.textDetails);
            imageView = (ImageView) itemView.findViewById(R.id.imageViewIcon);

        }


    public void setClickListener(CouncellListViewClickListener itemClickListener) {

        this.clickListener11 = itemClickListener;
    }

    @Override
    public void onClick(View v) {

        this.clickListener11.itemClicked(v, getAdapterPosition());


    }
}

