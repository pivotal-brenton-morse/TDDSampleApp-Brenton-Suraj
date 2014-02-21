package com.tddsample.android.modules;

import com.tddsample.android.RobolectricTestRunnerWithInjection;
import com.tddsample.android.listeners.FetchModuleListener;
import com.tddsample.android.models.ResultInterface;
import com.tddsample.android.utils.FakeAsyncTaskWrapper;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.fest.assertions.api.Assertions.assertThat;

@RunWith(RobolectricTestRunnerWithInjection.class)
public class FetchModuleTest {

    private FetchModule fetchModule;
    private FetchModuleListener listener;

    @Before
    public void setup() {
        fetchModule = new FetchModule();
        listener = new FetchModuleListener() {
            @Override
            public void onSucess(ResultInterface result) {
            }

            @Override
            public void onFailure() {
            }
        };
        fetchModule.setListener(listener);
    }

    @Test
    public void requestUrl_shouldHaveCorrectWhatAndWhere() {
        fetchModule.fetch("restaurants", "toronto");
        FakeAsyncTaskWrapper asyncTaskWrapper = (FakeAsyncTaskWrapper) fetchModule.asyncTaskWrapper;
        assertThat(asyncTaskWrapper.listener).isNotNull();
        assertThat(asyncTaskWrapper.what).isEqualTo("restaurants");
        assertThat(asyncTaskWrapper.where).isEqualTo("toronto");
    }
}
