package com.u9time.eventbus;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.u9time.eventbus.events.TestEvent;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

public class Activity_B extends AppCompatActivity {
    TextView mTvMsg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__b);
        mTvMsg = (TextView) findViewById(R.id.tv_msg);

        // 1. 注册订阅者
        EventBus.getDefault().register(this);

        Log.d("BBBActivity", "------------onCreate------------" + this.toString());
    }

    /**
     * 2. 实现订阅函数
     */
    @Subscribe
    public void onEvent(TestEvent event) {
        Log.d("BBBActivity", "------------onEvent------------" + this.toString());

        // 收到订阅事件，设置信息给TextView
        mTvMsg.setText("收到Event === " + event.msg);

        Toast.makeText(this, "收到Event === " + event.msg, Toast.LENGTH_SHORT).show();
    }
}
