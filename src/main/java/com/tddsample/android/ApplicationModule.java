package com.tddsample.android;

import com.google.inject.AbstractModule;
import com.tddsample.android.modules.FetchModule;
import com.tddsample.android.modules.FetchModuleInterface;
import com.tddsample.android.utils.CameraUpdateFactoryWrapper;
import com.tddsample.android.utils.CameraUpdateFactoryWrapperInterface;

public class ApplicationModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(FetchModuleInterface.class).to(FetchModule.class);
        bind(CameraUpdateFactoryWrapperInterface.class).to(CameraUpdateFactoryWrapper.class);
    }
}
