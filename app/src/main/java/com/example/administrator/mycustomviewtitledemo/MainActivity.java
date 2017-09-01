package com.example.administrator.mycustomviewtitledemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.administrator.mycustomviewtitledemo.view.MyCustomView;

public class MainActivity extends AppCompatActivity {


    private MyCustomView myCustomView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myCustomView = (MyCustomView) findViewById(R.id.custom_view);
        myCustomView.SetOnIconClickListener(new MyCustomView.OnIconClickListener() {
            @Override
            public void OnMyActionBarIconClick(View icon) {
                startActivity(new Intent(MainActivity.this,Second.class));
            }
        });
    }
}
