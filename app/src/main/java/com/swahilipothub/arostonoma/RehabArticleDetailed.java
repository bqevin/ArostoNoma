package com.swahilipothub.arostonoma;

import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

/**
 * Created by Kevin Barassa on 03-Jan-17.
 */
public class RehabArticleDetailed extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.rehab_article);

        final Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        CollapsingToolbarLayout collapsingToolbar =
                (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);

        //Init transfered data
        Bundle extras = getIntent().getExtras();

        //Display only if not null
        if(extras != null)

            collapsingToolbar.setTitle(extras.getString("EXTRA_TITLE"));
        loadBackdrop();

        //Title section
        TextView title = (TextView) findViewById(R.id.article_title);
        title.setText(extras.getString("EXTRA_TITLE"));

        //Body section
        TextView body = (TextView) findViewById(R.id.article_body);
        body.setText(extras.getString("EXTRA_BODY"));

        //Author section
        TextView author = (TextView) findViewById(R.id.article_author);
        author.setText(extras.getString("EXTRA_AUTHOR"));



    }


    private void loadBackdrop() {
        //Load backdrop as clicked image
        Bundle extras = getIntent().getExtras();
        final ImageView imageView = (ImageView) findViewById(R.id.backdrop);
        Glide.with(this).load(extras.getString("EXTRA_IMAGE")).centerCrop().into(imageView);
    }
}
