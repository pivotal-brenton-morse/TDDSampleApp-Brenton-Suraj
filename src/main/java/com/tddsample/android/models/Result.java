package com.tddsample.android.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Result implements ResultInterface {
    @SerializedName("summary")
    private Summary summary;

    @SerializedName("listings")
    private List<Listing> listings;

    @Override
    public SummaryInterface getSummary() {
        return summary;
    }

    @Override
    public List<Listing> getListings() {
        return listings;
    }

}
