package com.tddsample.android.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.inject.Inject;
import com.tddsample.android.R;
import com.tddsample.android.utils.CameraUpdateFactoryWrapperInterface;

import roboguice.activity.RoboFragmentActivity;

public class NextActivity extends RoboFragmentActivity {

    public static class MAP_ZOOM {
        public static float ZOOM_LEVEL_15 = 15.f;
    }

    public static final String EXTRA_LATITUDE = "latitude";
    public static final String EXTRA_NAME = "name";
    public static final String EXTRA_LONGITUDE = "longitude";

    public GoogleMap map;
    private String name;
    private double lat, lng;

    @Inject
    public CameraUpdateFactoryWrapperInterface cameraUpdateFactoryWrapper;

    public static void start(Activity activity, final String name, final String latitude, final String longitude) {
        Intent intent = new Intent(activity, NextActivity.class);
        intent.putExtra(EXTRA_NAME, name);
        intent.putExtra(EXTRA_LATITUDE, latitude);
        intent.putExtra(EXTRA_LONGITUDE, longitude);
        activity.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_next);
        name = getIntent().getExtras().getString(EXTRA_NAME);
        lat = Double.parseDouble(getIntent().getExtras().getString(EXTRA_LATITUDE));
        lng = Double.parseDouble(getIntent().getExtras().getString(EXTRA_LONGITUDE));
    }

    @Override
    protected void onResume() {
        super.onResume();

        if (map == null) {
            map = ((MapFragment) getFragmentManager().findFragmentById(R.id.map)).getMap();
            // Check if we were successful in obtaining the map.
            if (map != null) {
                // The Map is verified. It is now safe to manipulate the map.
                setupMap();
            }
        }
    }

    public void setupMap() {
        if (map == null) {
            return;
        }
        LatLng position = new LatLng(lat, lng);
        map.setMyLocationEnabled(true);
        map.getUiSettings().setZoomControlsEnabled(false);
        map.getUiSettings().setMyLocationButtonEnabled(false);
        map.animateCamera(cameraUpdateFactoryWrapper.newLatLngZoom(position, MAP_ZOOM.ZOOM_LEVEL_15));
        map.addMarker(new MarkerOptions()
                .position(position)
                .title(name));
    }

}