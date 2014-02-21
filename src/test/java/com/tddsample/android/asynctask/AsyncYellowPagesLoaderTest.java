package com.tddsample.android.asynctask;

import com.tddsample.android.RobolectricTestRunnerWithInjection;
import com.tddsample.android.listeners.FetchModuleListener;
import com.tddsample.android.models.ResultInterface;
import com.tddsample.android.utils.FakeYellowPagesUrlWrapper;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.fest.assertions.api.Assertions.assertThat;

@RunWith(RobolectricTestRunnerWithInjection.class)
public class AsyncYellowPagesLoaderTest {

    AsyncYellowPagesLoader asyncYellowPagesLoader;

    @Before
    public void setup() {
        asyncYellowPagesLoader = new AsyncYellowPagesLoader(new FetchModuleListener() {
            public ResultInterface result;

            @Override
            public void onSucess(ResultInterface result) {
                this.result = result;
            }

            @Override
            public void onFailure() {}
        });
    }

    @Test
    public void networkUrl_shouldHaveCorrectWhatAndWhere() {

        asyncYellowPagesLoader.execute("restaurants", "toronto");

        assertThat(((FakeYellowPagesUrlWrapper) asyncYellowPagesLoader.yellowPagesUrlWrapper).what).isEqualTo("restaurants");
        assertThat(((FakeYellowPagesUrlWrapper) asyncYellowPagesLoader.yellowPagesUrlWrapper).where).isEqualTo("toronto");
    }


}
