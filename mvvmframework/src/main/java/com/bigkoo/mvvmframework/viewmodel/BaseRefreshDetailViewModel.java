package com.bigkoo.mvvmframework.viewmodel;

import android.support.v4.widget.SwipeRefreshLayout;

/**
 * Created by Sai on 16/8/19.
 */
public abstract class BaseRefreshDetailViewModel extends BaseDetailViewModel{
    private SwipeRefreshLayout.OnRefreshListener onRefreshListener = new SwipeRefreshLayout.OnRefreshListener() {
        @Override
        public void onRefresh() {
            onLoad();
        }
    };

    public SwipeRefreshLayout.OnRefreshListener getOnRefreshListener() {
        return onRefreshListener;
    }

}
