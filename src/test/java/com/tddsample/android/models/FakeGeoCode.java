package com.tddsample.android.models;

public class FakeGeoCode implements GeoCodeInterface {

    private final String latitude;
    private final String longitude;

    public FakeGeoCode(String latitude, String longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    @Override
    public String getLatitude() {
        return latitude;
    }

    @Override
    public String getLongitude() {
        return longitude;
    }
}
