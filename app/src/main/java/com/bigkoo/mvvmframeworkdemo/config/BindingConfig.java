package com.bigkoo.mvvmframeworkdemo.config;

import android.databinding.BindingAdapter;
import android.view.View;
import android.widget.ImageView;

import com.bigkoo.mvvmframework.viewmodel.BaseViewModel;
import com.bigkoo.mvvmframeworkdemo.manager.ImageLoaderManager;

/**
 * Created by Sai on 16/8/30.
 */
public class BindingConfig {

    @BindingAdapter({"imageUrl"})
    public static void loadImage(ImageView view, String url) {
        ImageLoaderManager.getInstance().displayImage(view, url);
    }


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
