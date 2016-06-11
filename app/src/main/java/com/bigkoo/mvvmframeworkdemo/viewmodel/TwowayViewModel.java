package com.bigkoo.mvvmframeworkdemo.viewmodel;

import android.support.v4.widget.SwipeRefreshLayout;
import android.view.View;

import com.bigkoo.mvvmframework.viewmodel.BaseRecyclerViewModel;
import com.bigkoo.mvvmframeworkdemo.R;
import com.bigkoo.mvvmframeworkdemo.model.MyHttpResult;
import com.bigkoo.mvvmframeworkdemo.model.Ticket;
import com.bigkoo.mvvmframeworkdemo.network.HttpServiceGenerator;

import java.util.List;

import retrofit2.Call;

/**
 * 双向绑定demo
 * Created by Sai on 16/6/8.
 */
public class TwowayViewModel extends BaseRecyclerViewModel implements View.OnClickListener{
    public TwowayViewModel(){
        super(R.layout.item_ticketlist);
        setPageSize(100);//设置一次拿100条数据

    }
    public SwipeRefreshLayout.OnRefreshListener onRefreshListener = new SwipeRefreshLayout.OnRefreshListener() {
        @Override
        public void onRefresh() {
            onListRefresh();
        }
    };

    @Override
    public Call<MyHttpResult<List<Ticket>>> onLoadListHttpRequest() {
        return HttpServiceGenerator.createService().getTicketList(getPage(),getPageSize());
    }

    @Override
    public void onItemClick(View v, int position, View itemView, Object item) {

    }

    @Override
    public void onClick(View v) {
        onListRefresh();
    }
}
