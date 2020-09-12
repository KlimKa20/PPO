package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class MainScreenActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_screen);
    }

    @Override
    public void onClick(View v) {
        Intent intent;
        switch (v.getId()) {
            case R.id.btnCurrency:
                intent = new Intent("by.bsuir.intent.action." + getString(R.string.ids) + ".Currency");
                startActivity(intent);
                break;
            case R.id.btnDistance:
                intent = new Intent("by.bsuir.intent.action." + getString(R.string.ids) + ".Distance");
                startActivity(intent);
                break;
            case R.id.btnWeight:
                intent = new Intent("by.bsuir.intent.action." + getString(R.string.ids) + ".Weight");
                startActivity(intent);
                break;
        }
    }
}