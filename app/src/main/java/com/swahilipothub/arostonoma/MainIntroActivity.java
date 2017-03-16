package com.swahilipothub.arostonoma;

import android.Manifest;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Toast;

import com.heinrichreimersoftware.materialintro.app.IntroActivity;
import com.heinrichreimersoftware.materialintro.slide.FragmentSlide;
import com.heinrichreimersoftware.materialintro.slide.SimpleSlide;
import com.heinrichreimersoftware.materialintro.slide.Slide;

/**
 * Created by Kevin Barassa on 15-Mar-17.
 */

public class MainIntroActivity extends IntroActivity {
    /**
     * Etra pref for Material intro
     * Selective only important for now
     */

    public static final String EXTRA_FULLSCREEN = "com.swahilipothub.arostonoma.EXTRA_FULLSCREEN";
    public static final String EXTRA_SCROLLABLE = "com.swahilipothub.arostonoma.EXTRA_SCROLLABLE";
    public static final String EXTRA_CUSTOM_FRAGMENTS = "com.swahilipothub.arostonoma.EXTRA_CUSTOM_FRAGMENTS";
    public static final String EXTRA_PERMISSIONS = "com.swahilipothub.arostonoma.EXTRA_PERMISSIONS";

    @Override
    protected void onCreate(Bundle savedInstanceState){

         /* Enable/disable fullscreen */
        setFullscreen(true);

        super.onCreate(savedInstanceState);
        //Extra settings for Material intro
        Intent intent = getIntent();
        boolean fullscreen = intent.getBooleanExtra(EXTRA_FULLSCREEN, false);
        boolean scrollable = intent.getBooleanExtra(EXTRA_SCROLLABLE, false);
        boolean customFragments = intent.getBooleanExtra(EXTRA_CUSTOM_FRAGMENTS, true);
        boolean permissions = intent.getBooleanExtra(EXTRA_PERMISSIONS, true);


        setFullscreen(fullscreen);

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
         * Permissions Slide
         */
//        final Slide permissionsSlide;
//        if (permissions) {
//            permissionsSlide = new SimpleSlide.Builder()
//                    .title(R.string.title_permissions)
//                    .description(R.string.description_permissions)
//                    .background(R.color.color_permissions)
//                    .backgroundDark(R.color.color_dark_permissions)
//                    .scrollable(scrollable)
//                    .permissions(new String[]{Manifest.permission.CAMERA,
//                            Manifest.permission.WRITE_EXTERNAL_STORAGE})
//                    .build();
//            addSlide(permissionsSlide);
//        } else {
//            permissionsSlide = null;
//        }

        /**
         * Register Slide
         */
        final Slide loginSlide;
        if (customFragments) {
//            loginSlide = new FragmentSlide.Builder()
//                    .background(R.color.colorPrimary)
//                    .backgroundDark(R.color.colorPrimaryDark)
//                    .fragment(RegisterFragment.newInstance())
//                    .build();
//            addSlide(loginSlide);

            addSlide(new FragmentSlide.Builder()
                    .background(R.color.colorPrimary)
                    .backgroundDark(R.color.colorPrimaryDark)
                    .fragment(R.layout.register_layout, R.style.AppTheme)
                    .build());
        } else {
            loginSlide = null;
        }

        addSlide(new SimpleSlide.Builder()
                .title(R.string.app_name)
                .description(R.string.about)
                .image(R.drawable.ic_icon)
                .background(R.color.colorPrimary)
                .backgroundDark(R.color.colorPrimaryDark)
                .scrollable(scrollable)
                .buttonCtaLabel("Get Started")
                .buttonCtaClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast toast = Toast.makeText(MainIntroActivity.this, "You have clicked me", Toast.LENGTH_SHORT);
                        toast.setGravity(Gravity.CENTER, 0, 0);
                        toast.show();

                        nextSlide();
                    }
                })
                .build());

    }
}