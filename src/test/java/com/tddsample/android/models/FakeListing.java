package com.tddsample.android.models;

public class FakeListing implements ListingInterface {

    private final String id;
    private final String name;
    private final String distance;
    private final FakeGeoCode geoCode;

    public FakeListing(String id, String name, String distance, String latitude, String longitude) {
        this.id = id;
        this.name = name;
        this.distance = distance;
        this.geoCode = new FakeGeoCode(latitude, longitude);
    }

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
    public GeoCodeInterface getGeoCode() {
        return geoCode;
    }
}
