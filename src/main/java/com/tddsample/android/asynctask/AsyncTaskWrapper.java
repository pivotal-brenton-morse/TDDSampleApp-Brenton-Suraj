package com.tddsample.android.asynctask;

import com.tddsample.android.listeners.FetchModuleListener;
import com.tddsample.android.utils.AsyncTaskWrapperInterface;

/**
 * Created by dx156-xl on 2/21/14.
 */
public class AsyncTaskWrapper implements AsyncTaskWrapperInterface {
    @Override
    public void execute(FetchModuleListener listener, String what, String where) {
        new AsyncYellowPagesLoader(listener).execute(what, where);
    }
}
