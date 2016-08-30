package com.bigkoo.mvvmframework.callback;

import com.bigkoo.mvvmframework.constants.HttpStatusConstants;
import com.bigkoo.mvvmframework.model.HttpResult;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * 通用的网络回调
 * Created by Sai on 16/4/7.
 */
public abstract class HttpServiceCallBack<T> implements Callback<HttpResult<T>> {
    @Override
    public void onResponse(Call<HttpResult<T>> call, Response<HttpResult<T>> response) {

        HttpResult<T> result = response.body();

        if (result == null) {
            //通常是服务器出错返回了非约定格式
            onHttpFail(response.code(),"网络错误,请稍后再试");
        } else {
            if (result.getCode() == HttpStatusConstants.RESULT_OK) {
                //正确返回约定的OK码
                onHttpSuccess(result.getContent(),result.getMsg());
            }
            else {
                //返回约定的其他类型码，可根据返回码进行相对应的操作
                onHttpFail(result.getCode(),result.getMsg());
            }
        }
        onHttpComplete();
    }

    @Override
    public void onFailure(Call<HttpResult<T>> call, Throwable t) {
        //网络异常或json解析失败
        onNetWorkError();
        onHttpComplete();
    }

    public abstract void onHttpSuccess(T resultData,String msg);
    public abstract void onHttpFail(int code, String msg);
    public abstract void onNetWorkError();
    public abstract void onHttpComplete();
}
