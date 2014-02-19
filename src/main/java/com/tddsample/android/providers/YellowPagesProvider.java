package com.tddsample.android.providers;

import android.net.Uri;

import com.tddsample.android.tables.ResultsTable;
import com.xtreme.rest.providers.RestContentProvider;

public class YellowPagesProvider extends RestContentProvider {

    public static final String AUTHORITY = "com.tddsample.android";

    private static final class Paths {
        public static final String FETCH = "fetch";
    }

    public static final Uri FETCH_URI = Uri.parse("content://" + AUTHORITY + "/" + Paths.FETCH);

    @Override
    public boolean onCreate() {
        registerDataset(AUTHORITY, Paths.FETCH, ResultsTable.class, null);
        registerDataset(AUTHORITY, Paths.FETCH + "/*", ResultsTable.class, null);
        return true;
    }
}
