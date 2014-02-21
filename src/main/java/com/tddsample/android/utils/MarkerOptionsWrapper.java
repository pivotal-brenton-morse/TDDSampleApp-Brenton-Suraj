package com.tddsample.android.utils;

import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MarkerOptionsWrapper implements MarkerOptionsWrapperInterface {
    @Override
    public MarkerOptions getOptions(String name, LatLng latLng) {
        return new MarkerOptions()
                .position(latLng)
                .title(name);
    }
}
