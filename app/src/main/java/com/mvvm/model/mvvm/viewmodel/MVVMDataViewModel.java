package com.mvvm.model.mvvm.viewmodel;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import com.mvvm.model.mvvm.model.MVVMDataModel;

public class MVVMDataViewModel extends BaseObservable implements MVVMLoadDataCallback{
    private MVVMDataModel model;

    public MVVMDataViewModel() {
        model = new MVVMDataModel();
    }

    /**
     * 必须添加@Bindable注释
     * @return
     */
    @Bindable
    public String getData() {
        return model.mData;
    }

    public void loadUserData() {
        model.requestData(this);
    }

    @Override
    public void onSuccess() {
        notifyPropertyChanged(com.mvvm.model.BR.data);
    }

    @Override
    public void onFailure() {

    }
}
