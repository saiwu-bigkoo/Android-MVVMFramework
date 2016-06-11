package com.bigkoo.mvvmframework.listener;

import android.os.Bundle;

/**
 * ViewModel 与 Activity 之间通知 监听器
 * Created by Sai on 16/5/31.
 */
public interface OnViewModelNotifyListener {
    void onViewModelNotify(Bundle bundle , int code);
}
