package com.u9time.eventbus;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.u9time.eventbus.events.TestEvent;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public class Activity_C extends AppCompatActivity {
    TextView mTvMsg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__c);
        mTvMsg = (TextView) findViewById(R.id.tv_msg);

        // 1. 注册订阅者（通过粘性注册的方式,3.0已经不是这种方式了，只需要在方法上注解即可）
        EventBus.getDefault().register(this);

        Log.e("CCCActivity", "------------onCreate------------" + this.toString());
    }

    /**
     * 2.实现订阅函数
     */
    @Subscribe(threadMode = ThreadMode.MAIN,sticky = true, priority = 100)
    public void onEvent(TestEvent event) {
        Log.e("CCCActivity", "------------onEvent------------" + this.toString());

        // 收到订阅事件，设置信息给TextView
        mTvMsg.setText("收到Event === " + event.msg);

        Toast.makeText(this, "收到Event === " + event.msg, Toast.LENGTH_SHORT).show();

        // 终止消息的传递，类似于有序广播。
        // EventBus.getDefault().cancelEventDelivery(event);
    }

    protected void onDestroy() {
        super.onDestroy();
        // 注销订阅者
        EventBus.getDefault().unregister(this);
    }

}
