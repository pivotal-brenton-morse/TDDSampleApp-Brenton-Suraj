package com.tddsample.android.models;

import com.google.gson.annotations.SerializedName;

public class Summary implements SummaryInterface {
    @SerializedName("what")
    private String what;

    @SerializedName("where")
    private String where;

    public String getWhat() {
        return what;
    }

    public String getWhere() {
        return where;
    }

}
