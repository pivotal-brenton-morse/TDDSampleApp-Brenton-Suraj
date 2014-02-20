package com.tddsample.android.models;

/**
 * Created by dx156-xl on 2/20/14.
 */
public class FakeSummary implements SummaryInterface {

    private final String what;
    private final String where;

    public FakeSummary(String what, String where) {
        this.what = what;
        this.where = where;
    }

    @Override
    public String getWhat() {
        return what;
    }

    @Override
    public String getWhere() {
        return where;
    }
}
