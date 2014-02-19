package com.tddsample.android.models;

import com.google.gson.annotations.SerializedName;

public class Summary {
    @SerializedName("what")
    private String what;

    @SerializedName("where")
    private String where;

    public String getWhat() {
        return what;
    }

    public void setWhat(String what) {
        this.what = what;
    }

    public String getWhere() {
        return where;
    }

    public void setWhere(String where) {
        this.where = where;
    }
}
