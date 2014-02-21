package com.tddsample.android.utils;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.model.LatLng;

/**
 * Created by dx156-xl on 2/21/14.
 */
public class CameraUpdateFactoryWrapper implements CameraUpdateFactoryWrapperInterface {
    @Override
    public CameraUpdate newLatLngZoom(LatLng latLng, float zoom) {
        return CameraUpdateFactory.newLatLngZoom(latLng, zoom);
    }

}
