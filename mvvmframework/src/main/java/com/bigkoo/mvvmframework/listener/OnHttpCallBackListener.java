package com.bigkoo.mvvmframework.listener;

import com.bigkoo.mvvmframework.model.HttpResult;

/**
 * Created by Sai on 16/6/1.
 */
public interface OnHttpCallBackListener<T> {
    void onHttpSuccess(T resultData,String msg);
    void onHttpFail(HttpResult<T> result);
    void onHttpComplete();
}
