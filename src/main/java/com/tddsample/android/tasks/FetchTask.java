package com.tddsample.android.tasks;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;

import com.google.gson.Gson;
import com.tddsample.android.models.Result;
import com.tddsample.android.providers.YellowPagesProvider;
import com.tddsample.android.tables.ResultsTable;
import com.tddsample.android.utils.YellowPagesApiUtils;
import com.xtreme.rest.service.Task;
import com.xtreme.threading.RequestIdentifier;

public class FetchTask extends Task<String> {

    private String mWhat;
    private String mWhere;

    public FetchTask(String what, String where) {
        mWhat = what;
        mWhere = where;
    }

    @Override
    public String onExecuteNetworkRequest(Context context) throws Exception {
        return YellowPagesApiUtils.getRequestUrl(mWhat, mWhere);
    }

    @Override
    public void onExecuteProcessingRequest(Context context, String s) throws Exception {
        final Result result = new Gson().fromJson(s, Result.class);

        final ContentValues[] values = new ContentValues[result.getListings().size()];
        ResultsTable.getInstance().getContentValues(result).toArray(values);
        final ContentResolver resolver = context.getContentResolver();
        resolver.delete(YellowPagesProvider.FETCH_URI, "*", null);
        resolver.bulkInsert(YellowPagesProvider.FETCH_URI, values);
    }

    @Override
    public RequestIdentifier<?> getIdentifier() {
        return new RequestIdentifier<String>(String.format("Fetch::%s_%s", mWhat, mWhere));
    }
}
