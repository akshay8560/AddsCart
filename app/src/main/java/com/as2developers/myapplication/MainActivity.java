package com.as2developers.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void open(View view) {

//        Intent intent = new Intent(MainActivity.this,SelectLocationFromMap.class);
//        startActivity(intent);

    }
}