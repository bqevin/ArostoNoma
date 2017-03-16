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

import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


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

        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.rehab_item, parent, false);
        return new RehabViewHolder(view);
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
                //Title
                String title  = articleItem.getTitle();
                //Author
                String author  = articleItem.getAuthor();
                //Body
                String body  = articleItem.getBody();
                //time
                String time  = articleItem.getTime();
                //image
                String image  = articleItem.getImage();


                //Soft transfer
                Intent intent = new Intent(context, RehabArticleDetailed.class);
                intent.putExtra("EXTRA_TITLE", title);
                intent.putExtra("EXTRA_AUTHOR", author);
                intent.putExtra("EXTRA_BODY", body);
                intent.putExtra("EXTRA_TIME", time);
                intent.putExtra("EXTRA_IMAGE", image);

                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

                context.startActivity(intent);

             // Toast.makeText(context, articleItem.getTitle(), Toast.LENGTH_LONG).show();
            }
        });

    }

    @Override
    public int getItemCount() {

        return articles.size();
    }

    //Viewholder class
    class RehabViewHolder extends RecyclerView.ViewHolder{
        @BindView(R.id.title) TextView title;
        @BindView(R.id.author) TextView author;
        @BindView(R.id.image) ImageView image;
        @BindView(R.id.articleLayout) LinearLayout articleLayout;

        public RehabViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }


    }




}
