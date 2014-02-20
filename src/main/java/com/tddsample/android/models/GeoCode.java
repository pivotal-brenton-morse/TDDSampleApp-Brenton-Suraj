package com.tddsample.android.models;

import com.google.gson.annotations.SerializedName;

public class GeoCode implements GeoCodeInterface {

    @SerializedName("latitude")
    private String latitude;

    @SerializedName("longitude")
    private String longitude;

    @Override
    public String getLatitude() {   return latitude;    }

    @Override
    public String getLongitude() {  return longitude;    }
}
