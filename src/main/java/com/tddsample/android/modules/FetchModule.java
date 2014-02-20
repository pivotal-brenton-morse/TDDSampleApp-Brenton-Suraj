package com.tddsample.android.modules;

import android.os.AsyncTask;

import com.google.gson.Gson;
import com.tddsample.android.listeners.FetchModuleListener;
import com.tddsample.android.models.Result;
import com.tddsample.android.models.ResultInterface;
import com.tddsample.android.utils.YellowPagesApiUtils;
import com.xtreme.network.NetworkRequest;
import com.xtreme.network.NetworkRequestLauncher;
import com.xtreme.network.NetworkResponse;

import java.io.IOException;
import java.io.InputStreamReader;


public class FetchModule implements FetchModuleInterface {

    private FetchModuleListener listener;

    @Override
    public void setListener(FetchModuleListener listener) {
        this.listener = listener;
    }

    @Override
    public void fetch(String what, String where) {
        new AsyncYellowPagesLoader().execute(what, where);
    }

    private class AsyncYellowPagesLoader extends AsyncTask<String, Void, ResultInterface> {


        public AsyncYellowPagesLoader() {
        }

        @Override
        public ResultInterface doInBackground(String... strings) {
            NetworkRequest networkRequest = new NetworkRequest(YellowPagesApiUtils.getRequestUrl(strings[0], strings[1]));
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

        @Override
        public void onPostExecute(ResultInterface result) {
            super.onPostExecute(result);
            if (result != null) {
                listener.onSucess(result);
            } else {
                listener.onFailure();
            }
        }
    }


}
