package com.fissionlabs.hackernews;

import android.app.Application;
import android.support.v7.widget.AppCompatTextView;

import uk.co.chrisjenx.calligraphy.CalligraphyConfig;

/**
 * Created by user on 07-05-2016.
 */
public class HackerNewsApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
//        CalligraphyConfig.initDefault(new CalligraphyConfig.Builder()
//                        .setDefaultFontPath("fonts/AvenirNextLTPro-Regular.ttf")
//                        .addCustomStyle(AppCompatTextView.class, android.R.attr.textViewStyle)
//                        .setFontAttrId(R.attr.fontPath)
//                        .build()
//        );
        HttpService.getInstance().setup(getApplicationContext());
    }
}