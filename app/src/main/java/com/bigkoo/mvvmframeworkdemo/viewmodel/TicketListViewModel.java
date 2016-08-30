package com.bigkoo.mvvmframeworkdemo.viewmodel;

import android.os.Bundle;
import android.view.View;

import com.bigkoo.mvvmframework.model.HttpResult;
import com.bigkoo.mvvmframework.viewmodel.BaseRefreshRecyclerViewModel;
import com.bigkoo.mvvmframeworkdemo.R;
import com.bigkoo.mvvmframeworkdemo.activity.TicketListActivity;
import com.bigkoo.mvvmframeworkdemo.model.Ticket;
import com.bigkoo.mvvmframeworkdemo.network.HttpServiceGenerator;

import java.util.List;

import retrofit2.Call;

/**
 * 通用BaseRecyclerViewModel使用例子
 * Created by Sai on 16/6/3.
 */
public class TicketListViewModel extends BaseRefreshRecyclerViewModel{

    public TicketListViewModel(){
        //正常的item样式
        super(R.layout.item_ticketlist);
        //设置特殊样式的view
        setSpecialView(8,R.layout.item_special_ticketlist);
        setSpecialView(10,R.layout.item_special_ticketlist);
        //加入header
        addHeader(R.layout.item_header_hot_ticketlist,"我是热门的headerView");
        addHeader(R.layout.item_header_image_ticketlist,0);

//        setLayoutManager(LayoutManagers.grid(2));  网格模式
        onListRefresh();
    }
    @Override
    public Call<HttpResult<List<Ticket>>> onLoadListHttpRequest() {
        return HttpServiceGenerator.createService().getTicketList(getPage(),getPageSize());
    }

    @Override
    public void onItemClick(View v, int position, View itemView, Object item) {
        Bundle bundle = new Bundle();
        int code = TicketListActivity.CODE_ITEM;
        if(item instanceof Ticket) {
            bundle.putSerializable("model", ((Ticket) item));
        }
        else {
            code = TicketListActivity.CODE_HEADER_FOOTER;
            bundle.putString("msg","点击了header或footer");
        }
        onViewModelNotify(bundle,code);
    }

    /**
     * 可选重写，如果是第一页并且有更多可以加载，则加入footer
     */
    @Override
    public void onLoadListComplete() {

        if (isFirstPage()&&getHasMore().get()&&getFooterSize()==0) {
            //加入footer
            addFooter(R.layout.item_footer_loadmore_ticketlist, "加载更多");
        }
        else if(!getHasMore().get()&&getFooterSize()!=0){
            removeFooters();
        }
    }
}
