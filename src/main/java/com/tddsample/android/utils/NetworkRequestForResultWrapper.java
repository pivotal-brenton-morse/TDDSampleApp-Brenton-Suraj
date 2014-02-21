package com.tddsample.android.utils;

import com.google.gson.Gson;
import com.tddsample.android.models.Result;
import com.tddsample.android.models.ResultInterface;
import com.xtreme.network.NetworkRequest;
import com.xtreme.network.NetworkRequestLauncher;
import com.xtreme.network.NetworkResponse;

import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by dx156-xl on 2/21/14.
 */
public class NetworkRequestForResultWrapper implements NetworkRequestForResultWrapperInterface {
    @Override
    public ResultInterface getResult(String url) {
        NetworkRequest networkRequest = new NetworkRequest(url);
        Result result = null;
        try {
            NetworkResponse networkResponse = NetworkRequestLauncher.getInstance().executeRequestSynchronously(networkRequest);
            InputStreamReader inputStreamReader = new InputStreamReader(networkResponse.getInputStream());
            result = new Gson().fromJson(inputStreamReader, Result.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }
}
