package com.tddsample.android.utils;

import android.os.AsyncTask;

import com.tddsample.android.listeners.FetchModuleListener;

import static org.mockito.Mockito.mock;

public class FakeAsyncTaskWrapper implements AsyncTaskWrapperInterface {

    public FetchModuleListener listener;
    public String what;
    public String where;

    @Override
    public void execute(FetchModuleListener listener, String what, String where) {
        this.listener = listener;
        this.what = what;
        this.where = where;
        mock(AsyncTask.class).execute(what, where);
    }
}
