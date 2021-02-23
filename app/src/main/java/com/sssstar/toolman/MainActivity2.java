package com.sssstar.toolman;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;

public class MainActivity2 extends AppCompatActivity {
    private String TAG = "MainActivity2";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Intent intent = new Intent();
        intent.putExtra("result","this is MainActivity2");
        setResult(1,intent);

        Intent intent_get = getIntent();
        Uri intent_data = intent_get.getData();
        Bundle intent_extras = intent_get.getExtras();
        Log.i(TAG,"intent_data:"+intent_data.toString());
        Log.i(TAG,"intent_extras:"+intent_extras.toString());
    }
}