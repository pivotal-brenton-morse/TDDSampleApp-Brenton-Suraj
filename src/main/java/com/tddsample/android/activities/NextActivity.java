package com.tddsample.android.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import com.tddsample.android.R;

public class NextActivity extends Activity {

    public static final String EXTRA_WHAT = "what";
    public static final String EXTRA_WHERE = "where";

    public static void start(Activity activity, String what, String where) {
        Intent intent = new Intent(activity, NextActivity.class);
        intent.putExtra(EXTRA_WHAT, what);
        intent.putExtra(EXTRA_WHERE, where);
        activity.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_next);
    }
}
