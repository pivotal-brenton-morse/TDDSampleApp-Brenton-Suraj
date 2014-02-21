package com.tddsample.android.utils;

import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

/**
 * Created by dx156-xl on 2/21/14.
 */
public interface MarkerOptionsWrapperInterface {

    public MarkerOptions getOptions(String name, LatLng latLng);

}
