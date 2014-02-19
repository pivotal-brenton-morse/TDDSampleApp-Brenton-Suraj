package com.tddsample.android.utils;

import java.util.Locale;

public class YellowPagesApiUtils {
    public static final String SANDBOX_API_KEY = "xxw3hmrc3v68astbuvcmc9xf";
    public static final String WHATWHERE_API_KEY = "wkbn5eatq8avv6p3jh9wqdgr";

    public static final String SANDBOX_URL = "http://api.sandbox.yellowapi.com";
    public static final String WHATWHERE_URL = "http://api.yellowapi.com";

    public static final String UID = "127.0.0.1";

    public static String getRequestUrl(final String what, final String where) {
        final String baseUrl = "%s/FindBusiness/?what=%s&where=%s&UID=%s&apikey=%s&fmt=JSON";
        String url = String.format(Locale.getDefault(), baseUrl, SANDBOX_URL, what, where, UID, SANDBOX_API_KEY);
        return url;
    }
}
