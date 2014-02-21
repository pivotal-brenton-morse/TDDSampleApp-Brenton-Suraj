package com.tddsample.android.utils;

/**
 * Created by dx156-xl on 2/21/14.
 */
public class YellowPagesUrlWrapper implements YellowPagesUrlWrapperInterface {
    @Override
    public String getRequestUrl(String what, String where) {
        return YellowPagesApiUtils.getRequestUrl(what, where);
    }
}
