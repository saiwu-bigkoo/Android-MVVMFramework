package com.bigkoo.mvvmframeworkdemo.viewmodel;

import com.bigkoo.mvvmframework.model.HttpResult;
import com.bigkoo.mvvmframework.viewmodel.BaseDetailViewModel;
import com.bigkoo.mvvmframeworkdemo.model.Ticket;
import com.bigkoo.mvvmframeworkdemo.network.HttpServiceGenerator;

import retrofit2.Call;

/**
 * Created by Sai on 16/6/10.
 */
public class TicketDetailViewModel extends BaseDetailViewModel{
    public TicketDetailViewModel(){
        onLoad();
    }

    @Override
    public Call<HttpResult<Ticket>> onLoadDatailHttpRequest() {
        return HttpServiceGenerator.createService().getTicketDetail("10002");
    }
}
