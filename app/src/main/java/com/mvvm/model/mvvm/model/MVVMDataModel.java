package com.mvvm.model.mvvm.model;

import com.mvvm.model.mvvm.viewmodel.MVVMLoadDataCallback;

/*
 *Model层
 */
public class MVVMDataModel {
    public String mData;

    public MVVMDataModel() {
        this.mData = "初始数据";
    }

    public void requestData(MVVMLoadDataCallback callback) {
        this.mData = "数据请求成功";
        callback.onSuccess();
    }
}
