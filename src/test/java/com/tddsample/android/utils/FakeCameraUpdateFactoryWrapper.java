package com.tddsample.android.utils;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.model.LatLng;

import static org.mockito.Mockito.mock;

/**
 * Created by dx156-xl on 2/21/14.
 */
public class FakeCameraUpdateFactoryWrapper implements CameraUpdateFactoryWrapperInterface {
    public LatLng latLng;

    @Override
    public CameraUpdate newLatLngZoom(LatLng latLng, float zoom) {
        this.latLng = latLng;
        return mock(CameraUpdate.class);
    }
}
