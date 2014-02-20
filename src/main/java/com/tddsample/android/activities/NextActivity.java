package com.tddsample.android.activities;

import android.app.Activity;
import android.content.Intent;

public class NextActivity extends Activity {

    public static final String EXTRA_LATITUDE = "latitude";
    public static final String EXTRA_LONGITUDE = "longitude";

    public static void start(Activity activity, final String latitude, final String longitude) {
        Intent intent = new Intent(activity, NextActivity.class);
        intent.putExtra(EXTRA_LATITUDE, latitude);
        intent.putExtra(EXTRA_LONGITUDE, longitude);
        activity.startActivity(intent);
    }

}
