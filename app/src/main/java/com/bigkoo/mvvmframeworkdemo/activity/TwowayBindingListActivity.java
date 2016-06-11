package com.bigkoo.mvvmframeworkdemo.activity;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.bigkoo.mvvmframework.listener.OnViewModelNotifyListener;
import com.bigkoo.mvvmframeworkdemo.R;
import com.bigkoo.mvvmframeworkdemo.databinding.ActivityTwowaybindingListBinding;
import com.bigkoo.mvvmframeworkdemo.model.Ticket;
import com.bigkoo.mvvmframeworkdemo.viewmodel.TwowayViewModel;

/**
 * 双向绑定refreshing 状态，绑定 BaseViewModel 的 加载，出错，网络异常，空数据状态（你可以通过 更改 飞行模式控制网络状态 然后下拉刷新数据 来测试例子）
 * Created by Sai on 16/6/8.
 */
public class TwowayBindingListActivity extends AppCompatActivity implements OnViewModelNotifyListener {
    public static final int CODE_ITEM = 0;
    public static final int CODE_HEADER_FOOTER = 1;
    private TwowayViewModel viewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityTwowaybindingListBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_twowaybinding_list);
        viewModel = new TwowayViewModel();
        viewModel.setOnViewModelNotifyListener(this);
        binding.setViewModel(viewModel);
        binding.executePendingBindings();

    }

    @Override
    protected void onResume() {
        super.onResume();
        viewModel.onListRefresh();
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
