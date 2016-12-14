package com.swahilipothub.arostonoma;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

/**
 * Created by ZoomIT User1 on 8/28/2016.
 */
public class DetailView extends AppCompatActivity {


    private String title,content;
    private TextView tvTitle,tvContent;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.detail_view);

        Intent intent = getIntent();


        title = intent.getStringExtra(AppConstants.REHAB_DETAIL_VIEW_TITLE);
        content = intent.getStringExtra(AppConstants.REHAB_DETAIL_VIEW_CONTENT);


        tvTitle = (TextView)findViewById(R.id.textTitle);
        tvContent = (TextView)findViewById(R.id.textContent);



        tvTitle.setText(title);
        tvContent.setText(content);

    }


}
