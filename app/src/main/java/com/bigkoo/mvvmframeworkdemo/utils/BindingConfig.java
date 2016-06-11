package com.bigkoo.mvvmframeworkdemo.utils;

import android.databinding.BindingAdapter;
import android.databinding.InverseBindingAdapter;
import android.databinding.InverseBindingListener;
import android.databinding.adapters.ListenerUtil;
import android.support.v4.widget.SwipeRefreshLayout;

import com.bigkoo.mvvmframeworkdemo.R;

/**
 * Created by Sai on 16/6/8.
 */
public class BindingConfig {
    @InverseBindingAdapter(attribute = "refreshing",event = "refreshingAttrChanged")
    public static boolean isRefreshing(SwipeRefreshLayout view) {
        return view.isRefreshing();
    }


    @BindingAdapter("refreshing")
    public static void setRefreshing(SwipeRefreshLayout view, boolean refreshing) {
        if (refreshing != view.isRefreshing()) {
            view.setRefreshing(refreshing);
        }
    }
    @BindingAdapter(value = {"onRefreshListener", "refreshingAttrChanged"}, requireAll = false)
    public static void setOnRefreshListener(final SwipeRefreshLayout view,
                                            final SwipeRefreshLayout.OnRefreshListener listener,
                                            final InverseBindingListener refreshingAttrChanged) {

        SwipeRefreshLayout.OnRefreshListener newValue = new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                if (listener != null) {
                    if (refreshingAttrChanged != null) {
                        refreshingAttrChanged.onChange();
                    }
                    listener.onRefresh();
                }
            }
        };

        SwipeRefreshLayout.OnRefreshListener oldValue = ListenerUtil.trackListener(view, newValue, R.id.onRefreshListener);
        if (oldValue != null) {
            view.setOnRefreshListener(null);
        }
        view.setOnRefreshListener(newValue);
    }
}
