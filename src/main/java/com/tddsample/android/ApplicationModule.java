package com.tddsample.android;

import com.google.inject.AbstractModule;
import com.tddsample.android.modules.FetchModule;
import com.tddsample.android.modules.FetchModuleInterface;

public class ApplicationModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(FetchModuleInterface.class).to(FetchModule.class);
    }
}
