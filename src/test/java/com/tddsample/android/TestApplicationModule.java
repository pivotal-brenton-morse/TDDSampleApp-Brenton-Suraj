package com.tddsample.android;

import com.google.inject.AbstractModule;
import com.tddsample.android.modules.FakeFetchModule;
import com.tddsample.android.modules.FetchModuleInterface;
import com.tddsample.android.utils.AsyncTaskWrapperInterface;
import com.tddsample.android.utils.CameraUpdateFactoryWrapperInterface;
import com.tddsample.android.utils.FakeAsyncTaskWrapper;
import com.tddsample.android.utils.FakeCameraUpdateFactoryWrapper;
import com.tddsample.android.utils.FakeMarkerOptionsWrapper;
import com.tddsample.android.utils.FakeYellowPagesUrlWrapper;
import com.tddsample.android.utils.MarkerOptionsWrapperInterface;
import com.tddsample.android.utils.YellowPagesUrlWrapperInterface;

public class TestApplicationModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(FetchModuleInterface.class).to(FakeFetchModule.class);
        bind(CameraUpdateFactoryWrapperInterface.class).to(FakeCameraUpdateFactoryWrapper.class);
        bind(MarkerOptionsWrapperInterface.class).to(FakeMarkerOptionsWrapper.class);
        bind(YellowPagesUrlWrapperInterface.class).to(FakeYellowPagesUrlWrapper.class);
        bind(AsyncTaskWrapperInterface.class).to(FakeAsyncTaskWrapper.class);
    }
}
