package com.bigkoo.mvvmframeworkdemo.activity;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.bigkoo.mvvmframework.listener.OnViewModelNotifyListener;
import com.bigkoo.mvvmframeworkdemo.R;
import com.bigkoo.mvvmframeworkdemo.databinding.ActivityTicketdetailBinding;
import com.bigkoo.mvvmframeworkdemo.model.Ticket;
import com.bigkoo.mvvmframeworkdemo.viewmodel.TicketDetailViewModel;

/**
 * Created by Sai on 16/6/10.
 */
public class TicketDetailActivity extends AppCompatActivity implements OnViewModelNotifyListener {
    public static final int CODE_ITEM = 0;
    public static final int CODE_HEADER_FOOTER = 1;
    private TicketDetailViewModel viewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityTicketdetailBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_ticketdetail);
        viewModel = new TicketDetailViewModel();
        viewModel.setOnViewModelNotifyListener(this);
        binding.setViewModel(viewModel);
        binding.executePendingBindings();

    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    public void onViewModelNotify(Bundle bundle, int code) {
        switch (code){
            case CODE_ITEM:
                Ticket ticket = (Ticket) bundle.getSerializable("model");
                Toast.makeText(this,ticket.getSpotName(),Toast.LENGTH_SHORT).show();
                break;
            case CODE_HEADER_FOOTER:
                Toast.makeText(this,bundle.getString("msg"),Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
