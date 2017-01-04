package com.swahilipothub.arostonoma;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Response;
import com.squareup.picasso.Picasso;

import java.util.List;


/**
 * Created by Kevin Barassa on 8/28/2016.
 */
public class RehabAdapter extends RecyclerView.Adapter<RehabAdapter.RehabViewHolder>{

    private List<RehabArticles> articles;
    private Context context;

    public RehabAdapter(List<RehabArticles> articles, Context context) {
        this.articles = articles;
        this.context = context;
    }

    @Override
    public RehabViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.rehab_article, parent, false);

        return new RehabViewHolder(v);
    }

    @Override
    public void onBindViewHolder(RehabViewHolder holder, int position) {

        //Initiate the articles
        final RehabArticles articleItem = articles.get(position);

        //inflate the created viewholders with actual data from model
        holder.title.setText(articleItem.getTitle());
        holder.author.setText(articleItem.getAuthor());

        //Load image with Piccasso
        Picasso.with(context)
                .load(articleItem.getImage())
                .into(holder.image);

        //Add click listener to articles
        holder.articleLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              Toast.makeText(context, articleItem.getTitle(), Toast.LENGTH_LONG).show();
            }
        });

    }

    @Override
    public int getItemCount() {

        return articles.size();
    }

    //Viewholder class
    class RehabViewHolder extends RecyclerView.ViewHolder{

        TextView title,author;
        ImageView image;
        LinearLayout articleLayout;

        public RehabViewHolder(View itemView) {
            super(itemView);

            title = (TextView) itemView.findViewById(R.id.title);
            articleLayout = (LinearLayout) itemView.findViewById(R.id.articleLayout);
            author = (TextView) itemView.findViewById(R.id.author);
            image = (ImageView) itemView.findViewById(R.id.image);

        }


    }




}
