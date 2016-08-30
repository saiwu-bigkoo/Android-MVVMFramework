package com.bigkoo.mvvmframework.viewmodel;

import android.databinding.ObservableBoolean;
import android.os.Bundle;

import com.bigkoo.mvvmframework.listener.OnViewModelNotifyListener;

/**
 * 基类ViewModel
 * Created by Sai on 16/5/31.
 */
public abstract class BaseViewModel<T> {
    //刷新状态
    private final ObservableBoolean refreshing = new ObservableBoolean(false);
    //空数据状态
    private final ObservableBoolean statusEmpty = new ObservableBoolean(false);
    //加载中状态
    private final ObservableBoolean statusLoading = new ObservableBoolean(false);
    //错误状态
    private final ObservableBoolean statusError = new ObservableBoolean(false);
    //网络异常状态
    private final ObservableBoolean statusNetworkError = new ObservableBoolean(false);
    //通知View进行交互的监听器
    private OnViewModelNotifyListener onViewModelNotifyListener;

    public ObservableBoolean getStatusEmpty() {
        return statusEmpty;
    }

    public void setStatusEmpty(Boolean isEmpty) {
        statusEmpty.set(isEmpty);
    }

    public ObservableBoolean getStatusLoading() {
        return statusLoading;
    }

    public void setStatusLoading(Boolean isLoading) {
        statusLoading.set(isLoading);
    }

    public ObservableBoolean getStatusError() {
        return statusError;
    }

    public void setStatusError(Boolean isError) {
        statusError.set(isError);
    }

    public ObservableBoolean getStatusNetworkError() {
        return statusNetworkError;
    }

    public void setStatusNetworkError(Boolean isNetworkError) {
        statusNetworkError.set(isNetworkError);
    }

    public void setRefreshing(Boolean isRefreshing){
        refreshing.set(isRefreshing);
    }

    public ObservableBoolean getRefreshing() {
        return refreshing;
    }

    public void setOnViewModelNotifyListener(OnViewModelNotifyListener onViewModelNotifyListener) {
        this.onViewModelNotifyListener = onViewModelNotifyListener;
    }

    /**
     * 通知View进行交互
     * @param bundle 装载数据
     * @param code 判别View要做什么操作
     */
    public void onViewModelNotify(Bundle bundle, int code){
        if(onViewModelNotifyListener != null)
            onViewModelNotifyListener.onViewModelNotify(bundle,code);
    }

    /**
     * 加载数据
     */
    public void onLoad(){}
}
