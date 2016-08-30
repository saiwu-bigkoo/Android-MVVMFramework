package com.bigkoo.mvvmframeworkdemo.config;

import android.databinding.BindingAdapter;
import android.view.View;

import com.bigkoo.mvvmframework.viewmodel.BaseViewModel;

/**
 * Created by Sai on 16/8/30.
 */
public class BindingConfig {
    @BindingAdapter({"setReload"})
    public static void setReload(View view, final BaseViewModel viewModel) {
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewModel.onLoad();
            }
        });
    }

}
