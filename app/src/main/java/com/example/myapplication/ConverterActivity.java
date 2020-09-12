package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import androidx.fragment.app.FragmentActivity;

public class ConverterActivity extends FragmentActivity {

    Spinner spinner;
    Spinner spinner2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_converter);
        Intent intent = getIntent();
        String action = intent.getAction();
        int layoutId = 0;
        if (action.equals("by.bsuir.intent.action." + getString(R.string.ids) + ".Currency")) {
            layoutId = R.array.spinnerItemCurrency;
        } else if (action.equals("by.bsuir.intent.action." + getString(R.string.ids) + ".Distance")) {
            layoutId = R.array.spinnerItemDistance;
        } else if (action.equals("by.bsuir.intent.action." + getString(R.string.ids) + ".Weight")) {
            layoutId = R.array.spinnerItemWeight;
        }
        ArrayAdapter adapter = ArrayAdapter.createFromResource(this, layoutId, android.R.layout.simple_spinner_dropdown_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner = findViewById(R.id.spinner);
        spinner2 = findViewById(R.id.spinner2);

        spinner.setAdapter(adapter);
        spinner2.setAdapter(adapter);
    }
}