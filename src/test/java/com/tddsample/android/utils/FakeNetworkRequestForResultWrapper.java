package com.tddsample.android.utils;

import com.tddsample.android.models.FakeResult;
import com.tddsample.android.models.ResultInterface;

/**
 * Created by dx156-xl on 2/21/14.
 */
public class FakeNetworkRequestForResultWrapper implements NetworkRequestForResultWrapperInterface {
    @Override
    public ResultInterface getResult(String url) {
        return new FakeResult("restaurants", "toronto");
    }
}
