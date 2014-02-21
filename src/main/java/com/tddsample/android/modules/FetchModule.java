package com.tddsample.android.modules;

import com.google.inject.Inject;
import com.tddsample.android.listeners.FetchModuleListener;
import com.tddsample.android.utils.AsyncTaskWrapperInterface;

import org.robolectric.Robolectric;

import roboguice.RoboGuice;
import roboguice.inject.RoboInjector;

public class FetchModule implements FetchModuleInterface {

    @Inject
    public AsyncTaskWrapperInterface asyncTaskWrapper;

    private FetchModuleListener listener;

    public FetchModule() {
        RoboInjector injector = RoboGuice.getInjector(Robolectric.application);
        injector.injectMembersWithoutViews(this);
    }

    @Override
    public void setListener(FetchModuleListener listener) {
        this.listener = listener;
    }

    @Override
    public void fetch(String what, String where) {
        asyncTaskWrapper.execute(listener, what, where);
    }
}
