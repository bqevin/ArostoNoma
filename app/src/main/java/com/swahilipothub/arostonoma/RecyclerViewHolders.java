package com.swahilipothub.arostonoma;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;


public class RecyclerViewHolders extends RecyclerView.ViewHolder implements View.OnClickListener{

    public TextView countryName;
    public ImageView countryPhoto;
    Context context;

    public RecyclerViewHolders(View itemView,Context mcontext) {
        super(itemView);
        itemView.setOnClickListener(this);
        this.context = mcontext;
        countryName = (TextView)itemView.findViewById(R.id.name);
        countryPhoto = (ImageView)itemView.findViewById(R.id.photo);
    }

    @Override
    public void onClick(View view) {
        //Toast.makeText(view.getContext(), "Clicked Country Position = " +getPosition()+" ID "+getAdapterPosition(), Toast.LENGTH_SHORT).show();

        showPage(getAdapterPosition());
    }

    private void showPage(int adapterPosition) {

        if(adapterPosition == 0){

            context.startActivity(new Intent(context, Profile.class));

        }else if (adapterPosition == 1){

            context.startActivity(new Intent(context, RehabActivity.class));

        }else if (adapterPosition == 2){


            context.startActivity(new Intent(context, ReportDealersActivity.class));
        }else if (adapterPosition == 3){


            context.startActivity(new Intent(context, CouncellingActivity.class));
        }

    }
}