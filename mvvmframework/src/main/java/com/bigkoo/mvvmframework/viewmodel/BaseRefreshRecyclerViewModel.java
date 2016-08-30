package com.bigkoo.mvvmframework.viewmodel;

import android.support.v4.widget.SwipeRefreshLayout;

/**
 * 下拉刷新
 * Created by Sai on 16/6/16.
 */
public abstract class BaseRefreshRecyclerViewModel extends BaseRecyclerViewModel{

    public BaseRefreshRecyclerViewModel(int itemLayout) {
        super(itemLayout);
    }

    public BaseRefreshRecyclerViewModel(int itemLayout, boolean loadMore) {
        super(itemLayout, loadMore);
    }

    private SwipeRefreshLayout.OnRefreshListener onRefreshListener = new SwipeRefreshLayout.OnRefreshListener() {
        @Override
        public void onRefresh() {
            onListRefresh();
        }
    };

    public SwipeRefreshLayout.OnRefreshListener getOnRefreshListener() {
        return onRefreshListener;
    }

}
