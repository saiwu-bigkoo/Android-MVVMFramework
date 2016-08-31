package com.bigkoo.mvvmframeworkdemo.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.bigkoo.mvvmframeworkdemo.R;
import com.bigkoo.mvvmframeworkdemo.manager.ImageLoaderManager;
import com.bigkoo.mvvmframeworkdemo.network.HttpServiceGenerator;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //懒得写application类，你们别像我这么懒哦
        HttpServiceGenerator.context = getApplicationContext();
        ImageLoaderManager.getInstance().init(getApplicationContext());
    }

    public void onClick(View v){
        Intent intent = new Intent();
        switch (v.getId()){
            case R.id.btTicket:
                intent.setClass(this,TicketListActivity.class);
                break;
        }
        startActivity(intent);
    }
}
