package com.tddsample.android.utils;

import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import static org.mockito.Mockito.mock;

public class FakeMarkerOptionsWrapper implements MarkerOptionsWrapperInterface {
    public String name;
    public LatLng latLng;

    @Override
    public MarkerOptions getOptions(String name, LatLng latLng) {
        this.name = name;
        this.latLng = latLng;
        return mock(MarkerOptions.class);
    }
}
