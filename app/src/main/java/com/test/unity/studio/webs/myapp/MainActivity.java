package com.test.unity.studio.webs.myapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.test.unity.studio.webs.lib.AndoirdPluginActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent = new Intent(this, AndoirdPluginActivity.class);
        startActivity(intent);
        finish();
    }
}
