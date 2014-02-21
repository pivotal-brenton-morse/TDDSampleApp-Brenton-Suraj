package com.tddsample.android;

import com.google.inject.AbstractModule;
import com.tddsample.android.asynctask.AsyncTaskWrapper;
import com.tddsample.android.modules.FetchModule;
import com.tddsample.android.modules.FetchModuleInterface;
import com.tddsample.android.utils.AsyncTaskWrapperInterface;
import com.tddsample.android.utils.CameraUpdateFactoryWrapper;
import com.tddsample.android.utils.CameraUpdateFactoryWrapperInterface;
import com.tddsample.android.utils.MarkerOptionsWrapper;
import com.tddsample.android.utils.MarkerOptionsWrapperInterface;
import com.tddsample.android.utils.YellowPagesUrlWrapper;
import com.tddsample.android.utils.YellowPagesUrlWrapperInterface;

public class ApplicationModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(FetchModuleInterface.class).to(FetchModule.class);
        bind(CameraUpdateFactoryWrapperInterface.class).to(CameraUpdateFactoryWrapper.class);
        bind(MarkerOptionsWrapperInterface.class).to(MarkerOptionsWrapper.class);
        bind(YellowPagesUrlWrapperInterface.class).to(YellowPagesUrlWrapper.class);
        bind(AsyncTaskWrapperInterface.class).to(AsyncTaskWrapper.class);
    }
}
