package com.bigkoo.mvvmframeworkdemo.viewmodel;

import android.databinding.ObservableField;
import android.view.View;

import com.bigkoo.mvvmframework.viewmodel.BaseViewModel;
import com.bigkoo.mvvmframeworkdemo.R;
import com.bigkoo.mvvmframeworkdemo.model.Ticket;

/**
 * Created by Sai on 16/6/10.
 */
public class TicketDetailViewModel extends BaseViewModel implements View.OnClickListener{
    private final ObservableField<Ticket> ticket = new ObservableField<>();

    public ObservableField<Ticket> getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket.set(ticket);;
    }

    /**
     * 加载数据，去哪儿的api 太扯，格式不好解析，用本地数据替代偷懒
     */
    public void load(){
        Ticket tmpTicket = new Ticket();
        tmpTicket.setSpotName("长隆野生动物园门票");
        tmpTicket.setPrice("188.88");
        tmpTicket.setDetailInfo("这里是描述。。。。。。。。。。。。。。。。。。。。。。。。大翻身地方的访问范围而二期为服务而大法师的法师发打发士大夫打发打发大法师大打算放到发");
        setTicket(tmpTicket);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btLoad:
                load();
                break;
        }
    }
}
