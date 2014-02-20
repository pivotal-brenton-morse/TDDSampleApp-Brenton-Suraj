package com.tddsample.android.models;

import java.util.ArrayList;
import java.util.List;

public class FakeResult implements ResultInterface {


    private final String what;
    private final String where;

    public FakeResult(String what, String where) {
        this.what = what;
        this.where = where;
    }

    @Override
    public SummaryInterface getSummary() {
        return new FakeSummary(what, where);
    }

    @Override
    public List<ListingInterface> getListings() {
        ListingInterface listing1 = new FakeListing("1", "name 1", "dist 1", "49.2528517", "-123.1009162");
        ListingInterface listing2 = new FakeListing("2", "name 2", "dist 2", "49.260419", "-123.116297");

        List<ListingInterface> listings = new ArrayList<ListingInterface>();
        listings.add(listing1);
        listings.add(listing2);

        return listings;
    }
}
