package com.tddsample.android.activities;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.view.Menu;

import com.tddsample.android.R;
import com.tddsample.android.fragments.MainFragment;

import roboguice.activity.RoboFragmentActivity;

public class MainActivity extends RoboFragmentActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().add(R.id.fragment_container, new MainFragment()).commit();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
}
