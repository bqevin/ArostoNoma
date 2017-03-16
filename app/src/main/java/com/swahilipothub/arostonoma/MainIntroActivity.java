package com.swahilipothub.arostonoma;

import android.os.Bundle;

import com.heinrichreimersoftware.materialintro.app.IntroActivity;
import com.heinrichreimersoftware.materialintro.slide.FragmentSlide;
import com.heinrichreimersoftware.materialintro.slide.SimpleSlide;

/**
 * Created by Kevin Barassa on 15-Mar-17.
 */

public class MainIntroActivity extends IntroActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState){

         /* Enable/disable fullscreen */
        setFullscreen(true);

        super.onCreate(savedInstanceState);

        /* Enable/disable skip button */
        //setSkipEnabled(true);

        /* Enable/disable finish button */
        //setFinishEnabled(true);

        setButtonBackVisible(false);
        setButtonNextVisible(false);
        //setButtonCtaVisible(true);

        /**
         * Standard slide (like Google's intros)
         */
        addSlide(new SimpleSlide.Builder()
                .title(R.string.app_name)
                .description(R.string.about)
                .image(R.drawable.profile)
                .background(R.color.colorPrimary)
                .backgroundDark(R.color.colorPrimaryDark)
                .build());

        /**
         * Custom Login Fragment
         */
        addSlide(new FragmentSlide.Builder()
                .background(R.color.colorPrimary)
                .backgroundDark(R.color.colorPrimaryDark)
                .fragment(R.layout.login_layout, R.style.AppTheme)
                .build());

        addSlide(new SimpleSlide.Builder()
                .title(R.string.app_name)
                .description(R.string.about)
                .image(R.drawable.profile)
                .background(R.color.colorPrimary)
                .backgroundDark(R.color.colorPrimaryDark)
                .build());
        addSlide(new SimpleSlide.Builder()
                .title(R.string.app_name)
                .description(R.string.about)
                .image(R.drawable.profile)
                .background(R.color.colorPrimary)
                .backgroundDark(R.color.colorPrimaryDark)
                .build());
        addSlide(new SimpleSlide.Builder()
                .title(R.string.app_name)
                .description(R.string.about)
                .image(R.drawable.profile)
                .background(R.color.colorPrimary)
                .backgroundDark(R.color.colorPrimaryDark)
                .build());
        addSlide(new SimpleSlide.Builder()
                .title(R.string.app_name)
                .description(R.string.about)
                .image(R.drawable.profile)
                .background(R.color.colorPrimary)
                .backgroundDark(R.color.colorPrimaryDark)
                .build());
        addSlide(new SimpleSlide.Builder()
                .title(R.string.app_name)
                .description(R.string.about)
                .image(R.drawable.profile)
                .background(R.color.colorPrimary)
                .backgroundDark(R.color.colorPrimaryDark)
                .build());

    }
}