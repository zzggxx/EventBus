package com.u9time.eventbus;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.u9time.eventbus.events.TestEvent;

import org.greenrobot.eventbus.EventBus;

public class MainActivity_Activity_A extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main__activity_);
        findViewById(R.id.tv_send_001).setOnClickListener(this);
        findViewById(R.id.tv_send_002).setOnClickListener(this);
        findViewById(R.id.tv_jump_bbb).setOnClickListener(this);
        findViewById(R.id.tv_jump_ccc).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_send_001:
                // 发送Event，传递信息Event---001
                TestEvent event1 = new TestEvent();
                event1.msg = "Event---001";
                // 发布事件
                EventBus.getDefault().post(event1);
                break;
            case R.id.tv_send_002:
                // 发送Event，传递信息Event---001
                TestEvent event2 = new TestEvent();
                event2.msg = "Event---002";
                // 发布事件
                EventBus.getDefault().postSticky(event2);
                break;
            case R.id.tv_jump_bbb:
                // 跳转到BBBActivity
                startActivity(new Intent(this, Activity_B.class));
                break;
            case R.id.tv_jump_ccc:
                // 跳转到cccActivity
                startActivity(new Intent(this, Activity_C.class));
                break;
        }
    }
}
