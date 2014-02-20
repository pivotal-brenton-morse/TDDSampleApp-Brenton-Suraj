package com.tddsample.android;

import com.google.inject.AbstractModule;
import com.tddsample.android.modules.FakeFetchModule;
import com.tddsample.android.modules.FetchModuleInterface;

public class TestApplicationModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(FetchModuleInterface.class).to(FakeFetchModule.class);
    }
}
