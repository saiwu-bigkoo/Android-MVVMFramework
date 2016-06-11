package com.bigkoo.mvvmframework.viewmodel;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.bigkoo.mvvmframework.utils.RecyclerViewItemClickSupport;

/**
 * 针对RecyclerView的ViewModel
 * Created by Sai on 16/6/4.
 */
public abstract class BaseRecyclerViewModel<T> extends BaseListViewModel{

    public RecyclerViewItemClickSupport.OnItemClickListener onItemClickListener = new RecyclerViewItemClickSupport.OnItemClickListener(){
        @Override
        public void onItemClicked(RecyclerView recyclerView, int position, View v) {
            onItemClick(recyclerView,position,v,items.get(position));
        }
    };

    public RecyclerView.OnScrollListener onScrollListener = new RecyclerView.OnScrollListener() {
        @Override
        public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
            super.onScrolled(recyclerView, dx, dy);
            LinearLayoutManager layoutManager = (LinearLayoutManager) recyclerView.getLayoutManager();
            int lastVisibleItem = layoutManager.findLastVisibleItemPosition();
            int totalItemCount = layoutManager.getItemCount();
            //lastVisibleItem >= totalItemCount - 1 表示剩下1个item自动加载
            // dy>0 表示向下滑动
            if (lastVisibleItem >= totalItemCount - 1 && dy > 0) {
                onListLoadMore();
            }
        }
    };

    public BaseRecyclerViewModel(int itemLayout) {
        super(itemLayout);
    }
}
