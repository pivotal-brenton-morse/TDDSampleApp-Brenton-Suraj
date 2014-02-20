package com.tddsample.android.listeners;

import com.tddsample.android.models.ResultInterface;

public interface FetchModuleListener {

    public void onSucess(ResultInterface result);
    public void onFailure();

}
