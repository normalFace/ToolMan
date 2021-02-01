package com.sssstar.toolman;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class MyReceiver extends BroadcastReceiver {
    private final String ACTION_BOOT = "com.sssstar.toolman.RECEIVE_BROADCAST";

    @Override
    public void onReceive(Context context, Intent intent) {
        if(ACTION_BOOT.equals(intent.getAction())){
            Toast.makeText(context,"收到广播了！",Toast.LENGTH_SHORT).show();
        }
    }
}
