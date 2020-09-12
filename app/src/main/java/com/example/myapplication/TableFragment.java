package com.example.myapplication;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;


public class TableFragment extends Fragment {
    Button button0;
    Button button000;
    Button button1;
    Button button2;
    Button button3;
    Button button4;
    Button button5;
    Button button6;
    Button button7;
    Button button8;
    Button button9;
    Button buttonCancel;
    Button buttonDelete;
    Button buttonDot;

    ConverterViewModel mViewModel;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View viewHierarchy = inflater.inflate(R.layout.fragment_table, container, false);
        button0 = (Button) viewHierarchy.findViewById(R.id.btn0);
        button000 = (Button) viewHierarchy.findViewById(R.id.btn000);
        button1 = (Button) viewHierarchy.findViewById(R.id.btn1);
        button2 = (Button) viewHierarchy.findViewById(R.id.btn2);
        button3 = (Button) viewHierarchy.findViewById(R.id.btn3);
        button4 = (Button) viewHierarchy.findViewById(R.id.btn4);
        button5 = (Button) viewHierarchy.findViewById(R.id.btn5);
        button6 = (Button) viewHierarchy.findViewById(R.id.btn6);
        button7 = (Button) viewHierarchy.findViewById(R.id.btn7);
        button8 = (Button) viewHierarchy.findViewById(R.id.btn8);
        button9 = (Button) viewHierarchy.findViewById(R.id.btn9);
        buttonCancel = (Button) viewHierarchy.findViewById(R.id.btnc);
        buttonDelete = (Button) viewHierarchy.findViewById(R.id.btndelete);
        buttonDot = (Button) viewHierarchy.findViewById(R.id.btndot);

        button0.setOnClickListener(item -> mViewModel.setNumber("0"));
        button000.setOnClickListener(item -> mViewModel.setNumber("000"));
        button1.setOnClickListener(item -> mViewModel.setNumber("1"));
        button2.setOnClickListener(item -> mViewModel.setNumber("2"));
        button3.setOnClickListener(item -> mViewModel.setNumber("3"));
        button4.setOnClickListener(item -> mViewModel.setNumber("4"));
        button5.setOnClickListener(item -> mViewModel.setNumber("5"));
        button6.setOnClickListener(item -> mViewModel.setNumber("6"));
        button7.setOnClickListener(item -> mViewModel.setNumber("7"));
        button8.setOnClickListener(item -> mViewModel.setNumber("8"));
        button9.setOnClickListener(item -> mViewModel.setNumber("9"));
        buttonCancel.setOnClickListener(item -> mViewModel.clearTheField());
        buttonDelete.setOnClickListener(item -> mViewModel.clearTheSymbol());
        buttonDot.setOnClickListener(item -> mViewModel.setDot());

        return viewHierarchy;
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mViewModel = ViewModelProviders.of(getActivity()).get(ConverterViewModel.class);
    }
}