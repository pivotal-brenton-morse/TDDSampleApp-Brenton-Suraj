package com.tddsample.android.models;

import com.google.gson.annotations.SerializedName;

public class Listing implements ListingInterface {

    @SerializedName("id")
    private String id;

    @SerializedName("name")
    private String name;

    @SerializedName("distance")
    private String distance;

    @SerializedName("geoCode")
    private GeoCode geoCode;

    @Override
    public String getId() {
        return id;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getDistance() {
        return distance;
    }

    @Override
    public GeoCodeInterface getGeoCode() { return geoCode; }
}


