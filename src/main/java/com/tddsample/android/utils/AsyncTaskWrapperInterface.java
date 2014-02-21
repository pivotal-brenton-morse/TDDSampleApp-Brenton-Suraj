package com.tddsample.android.utils;

import com.tddsample.android.listeners.FetchModuleListener;

/**
 * Created by dx156-xl on 2/21/14.
 */
public interface AsyncTaskWrapperInterface {

    public void execute(FetchModuleListener listener, String what, String where);

}
