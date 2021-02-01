package com.sssstar.toolman;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class MainActivity extends AppCompatActivity {
    private Button readFPdata,nextActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        readFPdata = (Button) findViewById(R.id.btn_readFPdata);
        nextActivity = (Button) findViewById(R.id.btn_nextActivity);

        nextActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                startActivityForResult(intent,1);
            }
        });

        readFPdata.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = getIntent();
                if(intent != null && intent.getData() !=null){
                    try {
                        ParcelFileDescriptor parcelfiledescripter =
                                getContentResolver().openFileDescriptor(intent.getData(),"r");
                        FileReader filereader = new FileReader(parcelfiledescripter.getFileDescriptor());
                        BufferedReader bufferedreader = new BufferedReader(filereader);
                        String res = new Scanner(bufferedreader).useDelimiter("\\A").next();
                        Toast.makeText(MainActivity.this, "msg from fileprovider:"+res, Toast.LENGTH_SHORT).show();
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i("mainActivity","the onStart() event");
        Toast.makeText(this, "the onStart() event", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("mainActivity","the onResume() event");
        Toast.makeText(this, "the onResume() event", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("mainActivity","the onPause() event");
        Toast.makeText(this, "the onPause() event", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("mainActivity","the onStop() event");
        Toast.makeText(this, "the onStop() event", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("mainActivity","the onDestroy() event");
        Toast.makeText(this, "the onDestroy() event", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i("mainActivity","the onRestart() event");
        Toast.makeText(this, "the onRestart() event", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Log.i("mainActivity","the onActivityResult() event");
        Toast.makeText(this, "the onActivityResult() event", Toast.LENGTH_SHORT).show();
        switch (resultCode){
            case 1:
                String result = data.getExtras().getString("result");
                Toast.makeText(this, "the MianActivity2 result:"+result, Toast.LENGTH_SHORT).show();
        }
    }
}