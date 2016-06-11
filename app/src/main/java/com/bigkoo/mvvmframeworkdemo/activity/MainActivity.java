package com.bigkoo.mvvmframeworkdemo.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.bigkoo.mvvmframeworkdemo.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClick(View v){
        Intent intent = new Intent();
        switch (v.getId()){
            case R.id.btTicket:
                intent.setClass(this,TicketListActivity.class);
                break;
            case R.id.btTwoWay:
                intent.setClass(this,TwowayBindingListActivity.class);
                break;
        }
        startActivity(intent);
    }
}
