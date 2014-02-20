package com.tddsample.android.modules;

import com.tddsample.android.listeners.FetchModuleListener;
import com.tddsample.android.models.FakeResult;

public class FakeFetchModule implements FetchModuleInterface {

    private FetchModuleListener listener;

    @Override
    public void setListener(FetchModuleListener listener) {
        this.listener = listener;
    }

    @Override
    public void fetch(String what, String where) {
        listener.onSucess(new FakeResult(what, where));
    }
}
