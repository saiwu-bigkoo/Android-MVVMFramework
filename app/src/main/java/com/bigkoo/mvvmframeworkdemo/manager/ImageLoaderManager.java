package com.bigkoo.mvvmframeworkdemo.manager;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.widget.ImageView;

import com.bigkoo.mvvmframeworkdemo.R;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.RequestCreator;


/**
 * 图片缓存库管理器
 * Created by Sai on 16/4/6.
 */
public class ImageLoaderManager {
    private static ImageLoaderManager instance = new ImageLoaderManager();

    public static ImageLoaderManager getInstance() {
        return instance;
    }

    private Picasso imageLoader;

    private ImageLoaderManager() {
    }

    public void init(Context context) {
        imageLoader = Picasso.with(context);
    }

    public void displayImage(ImageView view, String url) {
        if(url == null) {
            view.setImageResource(R.mipmap.ic_launcher);
            return;
        }
        else if (TextUtils.isEmpty(url)) {//空图片显示
            view.setImageResource(R.mipmap.ic_launcher);
            return;
        }
        RequestCreator creator = imageLoader
                .load(url)
                .placeholder(R.mipmap.ic_launcher)
                .error(R.mipmap.ic_launcher)
                .config(Bitmap.Config.RGB_565);//不透明的图片使用减少内存
        if (view.getWidth() == 0 && view.getHeight() == 0){

        }
        else {
            creator.centerCrop()
                    .resize(view.getWidth(), view.getHeight());

        }
        creator.into(view);
    }

}
