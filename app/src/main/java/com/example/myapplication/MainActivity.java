package com.example.myapplication;

import androidx.fragment.app.FragmentActivity;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

//View.OnClickListener,implements  AdapterView.OnItemSelectedListener
public class MainActivity extends FragmentActivity {

    Spinner spinner;
    Spinner spinner2;
//    EditText editText;
//    EditText editText1;
//    ClipboardManager clipboardManager;
//    float procent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent intent = getIntent();
        String action = intent.getAction();
        int layoutId = 0;
        if (action.equals("by.bsuir.intent.action.Currency")) {
            layoutId = R.array.spinnerItemCurrency;
        } else if (action.equals("by.bsuir.intent.action.Distance")) {
            layoutId = R.array.spinnerItemDistance;
        } else if (action.equals("by.bsuir.intent.action.Weight")) {
            layoutId = R.array.spinnerItemWeight;
        }
        ArrayAdapter adapter = ArrayAdapter.createFromResource(this, layoutId, android.R.layout.simple_spinner_dropdown_item);
        spinner = findViewById(R.id.spinner);
        spinner2 = findViewById(R.id.spinner2);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner.setAdapter(adapter);
        spinner2.setAdapter(adapter);
        //        spinner.setOnItemSelectedListener(this);
//        spinner2.setOnItemSelectedListener(this);
//        editText = (EditText) findViewById(R.id.etNum);
//        editText1 = (EditText) findViewById(R.id.etNum1);
//        clipboardManager = (ClipboardManager) getSystemService(CLIPBOARD_SERVICE);
    }

//    @Override
//    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
//        String temp = spinner.getSelectedItem().toString() + spinner2.getSelectedItem().toString();
//        int strId = getResources().getIdentifier(temp, "string", getPackageName());
//        procent = Float.parseFloat(getString(strId));
//        String char0 = editText.getText().toString();
//        if (char0.length() != 0)
//            editText1.setText(Float.toString(Float.parseFloat(char0) * procent));
//    }
//
//    @Override
//    public void onNothingSelected(AdapterView<?> adapterView) {
//
//    }

//    public void additionButton(View v) {
//        String valueNum = editText.getText().toString();
//        String valueNum1 = editText1.getText().toString();
//        switch (v.getId()) {
//            case R.id.btnchange:
//                editText.setText(valueNum1);
//                editText1.setText(Float.toString(Float.parseFloat(valueNum1) * procent));
//                break;
////            case R.id.btndelete:
////                if (valueNum.length() != 0) {
////                    editText.setText(valueNum.substring(0, valueNum.length() - 1));
////                    editText1.setText(Float.toString(Float.parseFloat(editText.getText().toString()) * procent));
////                }
////                break;
////            case R.id.btnc:
////                editText.setText("");
////                editText1.setText("");
////                break;
//        }
//    }

//    public void copyInBuffer(View v) {
//        String message = "";
//        switch (v.getId()) {
//            case R.id.btncopyfirstfield:
//                message = editText.getText().toString().trim();
//                break;
//            case R.id.btncopysecondfield:
//                message = editText1.getText().toString().trim();
//        }
//        ClipData clipData = ClipData.newPlainText("text", message);
//        clipboardManager.setPrimaryClip(clipData);
//        Toast toast = Toast.makeText(this, "The copy was successful", Toast.LENGTH_LONG);
//        toast.show();
//    }

//    @Override
//    public void onClick(View v) {
//
//        String textValue = editText.getText().toString();
//        switch (v.getId()) {
////            case R.id.btn0:
////                textValue += "0";
////                break;
////            case R.id.btn000:
////                textValue += "000";
////                break;
////            case R.id.btn1:
////                textValue += "1";
////                break;
////            case R.id.btn2:
////                textValue += "2";
////                break;
////            case R.id.btn3:
////                textValue += "3";
////                break;
////            case R.id.btn4:
////                textValue += "4";
////                break;
////            case R.id.btn5:
////                textValue += "5";
////                break;
////            case R.id.btn6:
////                textValue += "6";
////                break;
////            case R.id.btn7:
////                textValue += "7";
////                break;
////            case R.id.btn8:
////                textValue += "8";
////                break;
////            case R.id.btn9:
////                textValue += "9";
////                break;
//            case R.id.btndot: {
//                if (!textValue.contains("."))
//                    textValue += ".";
//            }
//            default:
//                textValue += "";
//        }
//        editText.setText(textValue);
//        editText1.setText(Float.toString(Float.parseFloat(textValue) * procent));
//    }


}