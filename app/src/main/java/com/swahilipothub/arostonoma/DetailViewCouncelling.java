package com.swahilipothub.arostonoma;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by ZoomIT User1 on 8/28/2016.
 */
public class DetailViewCouncelling extends AppCompatActivity {

    private String title,content,description;
    private TextView tvTitle,tvContent,tvSmallDesc;
    private ImageView imageIcon;
    private int image_id;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.detail_view_councelling);

        Intent intent = getIntent();


        title = intent.getStringExtra(AppConstants.REHAB_DETAIL_VIEW_TITLE);
        content = intent.getStringExtra(AppConstants.REHAB_DETAIL_VIEW_CONTENT);
        description = intent.getStringExtra(AppConstants.REHAB_DETAIL_VIEW_DESCRIPTION_CONTENT);
        image_id = intent.getIntExtra(AppConstants.REHAB_DETAIL_VIEW_IMAGE_URL,0);


        tvTitle = (TextView)findViewById(R.id.textViewTitle);
        tvContent = (TextView)findViewById(R.id.textContent2);
        tvSmallDesc = (TextView)findViewById(R.id.textViewSmallDesc);
        imageIcon = (ImageView)findViewById(R.id.imageView2Icon);



        tvTitle.setText(title);
        tvContent.setText(content);
        tvSmallDesc.setText(description);
        imageIcon.setImageResource(image_id);

    }
}
