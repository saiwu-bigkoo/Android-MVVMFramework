package com.bigkoo.mvvmframework.bindingconfig;

import android.databinding.BindingAdapter;
import android.support.v7.widget.RecyclerView;

import com.bigkoo.mvvmframework.utils.RecyclerViewItemClickSupport;

/**
 * Created by Sai on 16/6/4.
 */
public class BindingConfig {
    @BindingAdapter({"addOnItemClick"})
    public static void addOnItemClick(RecyclerView view, RecyclerViewItemClickSupport.OnItemClickListener listener) {
        RecyclerViewItemClickSupport.addTo(view).setOnItemClickListener(listener);
    }

    @BindingAdapter({"addOnScrollListener"})
    public static void addOnScrollListener(RecyclerView view, RecyclerView.OnScrollListener listener) {
        view.setOnScrollListener(listener);
    }
}
