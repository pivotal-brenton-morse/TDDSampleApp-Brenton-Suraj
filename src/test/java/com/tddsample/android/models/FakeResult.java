package com.tddsample.android.models;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dx156-xl on 2/20/14.
 */
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
    public List<Listing> getListings() {
        Listing listing1 = new Listing();
        listing1.setId("1");
        listing1.setName("test 1");
        listing1.setDistance("dist 1");

        Listing listing2 = new Listing();
        listing2.setId("2");
        listing2.setName("test 2");
        listing2.setDistance("dist 2");

        List<Listing> listings = new ArrayList<Listing>();
        listings.add(listing1);
        listings.add(listing2);

        return listings;
    }
}
