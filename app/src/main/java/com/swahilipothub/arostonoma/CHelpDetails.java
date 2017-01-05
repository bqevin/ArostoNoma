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
public class CHelpDetails extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chelp_details);

        final Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        CollapsingToolbarLayout collapsingToolbar =
                (CollapsingToolbarLayout) findViewById(R.id.rehab_toolbar);

        //Init transfered data
        Bundle extras = getIntent().getExtras();

        //Display only if not null
        if(extras != null)

            collapsingToolbar.setTitle(extras.getString("EXTRA_TITLE"));
        loadBackdrop();

        //Description section
        TextView desc = (TextView) findViewById(R.id.ch_desc);
        desc.setText(extras.getString("EXTRA_DESC"));

        //Counsellors section
        TextView counsellor = (TextView) findViewById(R.id.ch_counsellors);
        counsellor.setText("Preparing best counsellors list and groups for your help");

    }


    private void loadBackdrop() {
        //Load backdrop as clicked image
        Bundle extras = getIntent().getExtras();
        final ImageView imageView = (ImageView) findViewById(R.id.backdrop);
        Glide.with(this).load("http://www.acc-uk.org/public/images/unnamed-2.jpg").centerCrop().into(imageView);
    }
}
