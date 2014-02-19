package com.tddsample.android.models;

import com.google.gson.annotations.SerializedName;

public class Listing {

    @SerializedName("id")
    private String id;

    @SerializedName("name")
    private String name;

    @SerializedName("distance")
    private String distance;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDistance() {
        return distance;
    }

    public void setDistance(String distance) {
        this.distance = distance;
    }
}


