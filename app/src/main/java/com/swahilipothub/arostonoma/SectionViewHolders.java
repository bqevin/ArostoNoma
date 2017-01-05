package com.swahilipothub.arostonoma;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;


public class SectionViewHolders extends RecyclerView.ViewHolder implements View.OnClickListener{

    public TextView sectionName;
    public ImageView sectionIcon;
    Context context;

    public SectionViewHolders(View itemView, Context mcontext) {
        super(itemView);
        itemView.setOnClickListener(this);
        this.context = mcontext;
        sectionName = (TextView)itemView.findViewById(R.id.name);
        sectionIcon = (ImageView)itemView.findViewById(R.id.photo);
    }

    @Override
    public void onClick(View view) {
        showPage(getAdapterPosition());
    }

    private void showPage(int adapterPosition) {

        if(adapterPosition == 0){

            context.startActivity(new Intent(context, ProfileActivity.class));

        }else if (adapterPosition == 1){

            context.startActivity(new Intent(context, RehabActivity.class));

        }else if (adapterPosition == 2){


            context.startActivity(new Intent(context, ReportDealersActivity.class));
        }else if (adapterPosition == 3){


            context.startActivity(new Intent(context, CHelpActivity.class));
        }

    }
}