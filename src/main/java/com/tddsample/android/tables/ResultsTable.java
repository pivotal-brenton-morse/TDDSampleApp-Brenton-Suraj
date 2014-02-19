package com.tddsample.android.tables;

import android.content.ContentValues;
import android.provider.BaseColumns;

import com.tddsample.android.models.Listing;
import com.tddsample.android.models.Result;
import com.xtreme.rest.providers.SQLTable;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class ResultsTable extends SQLTable{

    private static final String NAME = "result";

    public static final class Columns {
        public static final String ID = "id";
        public static final String NAME = "name";
        public static final String DISTANCE = "distance";
    }

    private static final ResultsTable HOLDER = new ResultsTable();

    public static ResultsTable getInstance() {
        return HOLDER;
    }

    public List<ContentValues> getContentValues(Result result) {
        List<ContentValues> contentValues = new ArrayList<ContentValues>();
        for (Listing listing : result.getListings()) {
            ContentValues contentValue = new ContentValues();
            contentValue.put(Columns.ID, listing.getId());
            contentValue.put(Columns.NAME, listing.getName());
            contentValue.put(Columns.DISTANCE, listing.getDistance());
            contentValues.add(contentValue);
        }
        return contentValues;
    }

    @Override
    public String getName() {
        return NAME;
    }

    @Override
    protected String getUniqueConstraint() {
        return "UNIQUE (" + Columns.ID + ") ON CONFLICT REPLACE";
    }

    @Override
    protected Map<String, String> getColumnMapping() {
        final Map<String, String> map = new LinkedHashMap<String, String>();
        map.put(BaseColumns._ID, "INTEGER PRIMARY KEY AUTOINCREMENT");
        map.put(Columns.ID, "TEXT");
        map.put(Columns.NAME, "TEXT");
        map.put(Columns.DISTANCE, "TEXT");
        return map;
    }
}
