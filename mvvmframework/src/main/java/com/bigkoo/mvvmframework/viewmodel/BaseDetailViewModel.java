package com.bigkoo.mvvmframework.viewmodel;

import android.databinding.ObservableField;

import com.bigkoo.mvvmframework.callback.HttpServiceCallBack;
import com.bigkoo.mvvmframework.model.HttpResult;

import retrofit2.Call;

/**
 * Created by Sai on 16/8/19.
 */
public abstract class BaseDetailViewModel<T> extends BaseViewModel {
    private ObservableField<T> detail = new ObservableField<>();
    private boolean once = false;//控制loading状态只有一次,对于列表的loading概念，就是首次加载数据，其余加载是刷新

    /**
     * 刷新数据
     */
    public void onLoadDatail(){
        setRefreshing(true);
        if(!once)
            setStatusLoading(true);
        onLoadDatailHttpRequest().enqueue(callBack);
    }
    /**
     * 网络请求
     * @return
     */
    public abstract Call<HttpResult<T>> onLoadDatailHttpRequest();

    public HttpServiceCallBack callBack = new HttpServiceCallBack<T>() {

        @Override
        public void onHttpSuccess(T resultData, String msg) {
            setStatusError(false);
            setStatusNetworkError(false);

            if(resultData != null) {
                detail.set(resultData);
            }
        }

        @Override
        public void onHttpFail(int code, String msg) {
            setStatusError(true);
        }

        @Override
        public void onNetWorkError() {
            setStatusNetworkError(true);
        }

        @Override
        public void onHttpComplete() {
            once = true;
            setStatusLoading(false);
            if(!getStatusError().get()&&!getStatusNetworkError().get())
                setStatusEmpty(detail.get() == null);

            setRefreshing(false);

            onLoadDatailComplete();
        }
    };

    public void onLoadDatailComplete(){}

    @Override
    public void onLoad() {
        onLoadDatail();
    }

    public ObservableField<T> getDetail() {
        return detail;
    }
}
