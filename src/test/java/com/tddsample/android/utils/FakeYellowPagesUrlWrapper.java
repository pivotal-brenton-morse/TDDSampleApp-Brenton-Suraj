package com.tddsample.android.utils;

import static org.mockito.Mockito.mock;

public class FakeYellowPagesUrlWrapper implements YellowPagesUrlWrapperInterface {
    public String what;
    public String where;

    @Override
    public String getRequestUrl(String what, String where) {
        this.what = what;
        this.where = where;
        return mock(String.class);
    }
}
