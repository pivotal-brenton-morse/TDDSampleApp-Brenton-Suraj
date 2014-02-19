package com.tddsample.android.operations;

import android.content.Context;
import android.net.Uri;
import android.os.Parcel;

import com.xtreme.rest.models.Priority;
import com.xtreme.rest.models.RestError;
import com.xtreme.rest.service.Operation;
import com.xtreme.rest.service.Task;

import java.util.List;

public class FetchOperation extends Operation {

    public FetchOperation(Uri uri, Priority priority) {
        super(uri, priority);
    }

    public FetchOperation(Uri uri) {
        super(uri);
    }

    public FetchOperation(Parcel in) {
        super(in);
    }

    @Override
    public void onCreateTasks() {
        final String what = getUri().getQueryParameter("what");
        final String where = getUri().getQueryParameter("where");
    }

    @Override
    public void onSuccess(Context context, List<Task<?>> tasks) {

    }

    @Override
    public void onFailure(RestError restError) {

    }
}
