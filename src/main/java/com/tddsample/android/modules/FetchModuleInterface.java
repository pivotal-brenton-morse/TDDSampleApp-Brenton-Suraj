package com.tddsample.android.modules;

import com.tddsample.android.listeners.FetchModuleListener;

/**
 * Created by dx156-xl on 2/20/14.
 */
public interface FetchModuleInterface {

    public void setListener(FetchModuleListener listener);

    public void fetch(String what, String where);

}
