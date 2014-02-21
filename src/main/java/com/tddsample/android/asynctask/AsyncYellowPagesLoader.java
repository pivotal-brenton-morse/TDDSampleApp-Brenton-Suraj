package com.tddsample.android.asynctask;

import android.os.AsyncTask;

import com.google.inject.Inject;
import com.tddsample.android.listeners.FetchModuleListener;
import com.tddsample.android.models.ResultInterface;
import com.tddsample.android.utils.NetworkRequestForResultWrapperInterface;
import com.tddsample.android.utils.YellowPagesUrlWrapperInterface;

import org.robolectric.Robolectric;

import roboguice.RoboGuice;
import roboguice.inject.RoboInjector;

/**
* Created by dx156-xl on 2/21/14.
*/
public class AsyncYellowPagesLoader extends AsyncTask<String, Void, ResultInterface> {

    @Inject
    YellowPagesUrlWrapperInterface yellowPagesUrlWrapper;

    @Inject
    NetworkRequestForResultWrapperInterface networkRequestForResultWrapper;

    private FetchModuleListener listener;

    public AsyncYellowPagesLoader(FetchModuleListener listener) {
        this.listener = listener;
        RoboInjector injector = RoboGuice.getInjector(Robolectric.application);
        injector.injectMembersWithoutViews(this);
    }

    @Override
    public ResultInterface doInBackground(String... strings) {
        String requestUrl = yellowPagesUrlWrapper.getRequestUrl(strings[0], strings[1]);
        ResultInterface result = networkRequestForResultWrapper.getResult(requestUrl);
        return result;
    }

    @Override
    public void onPostExecute(ResultInterface result) {
        super.onPostExecute(result);
        if (result != null) {
            listener.onSucess(result);
        } else {
            listener.onFailure();
        }
    }
}
