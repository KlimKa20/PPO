package com.example.myapplication;

import android.content.ClipboardManager;
import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;


public class HeaderFragment extends Fragment  implements AdapterView.OnItemSelectedListener{

    BlankViewModel model;
    EditText editText;
    EditText editText1;
    Button buttonChange;
    Button buttonCopy1;
    Button buttonCopy2;
    Spinner spinner;
    Spinner spinner2;
    ClipboardManager clipboardManager;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View viewHierarchy = inflater.inflate(R.layout.fragment_header, container, false);
        buttonChange = (Button) viewHierarchy.findViewById(R.id.btnchange);
        buttonCopy1 = (Button) viewHierarchy.findViewById(R.id.btncopyfirstfield);
        buttonCopy2 = (Button) viewHierarchy.findViewById(R.id.btncopysecondfield);
        spinner = viewHierarchy.findViewById(R.id.spinner);
        spinner2 = viewHierarchy.findViewById(R.id.spinner2);
        spinner.setOnItemSelectedListener(this);
        spinner2.setOnItemSelectedListener(this);
        model = ViewModelProviders.of(getActivity()).get(BlankViewModel.class);
        clipboardManager = (ClipboardManager)getActivity().getSystemService(Context.CLIPBOARD_SERVICE);
        buttonChange.setOnClickListener(item -> model.changeFields());
        buttonCopy1.setOnClickListener(item -> model.coppyInBuffer(1,clipboardManager));
        buttonCopy2.setOnClickListener(item -> model.coppyInBuffer(2,clipboardManager));
        return viewHierarchy;
    }
    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        String temp = spinner.getSelectedItem().toString() + spinner2.getSelectedItem().toString();
        int strId = getResources().getIdentifier(temp, "string", getActivity().getPackageName());
        model.selectData(Float.parseFloat(getString(strId)));
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        editText = (EditText) view.findViewById(R.id.etNum);
        editText1 = (EditText) view.findViewById(R.id.etNum1);
        model.getNumber().observe(requireActivity(), value -> editText.setText(value));
        model.Convert().observe(requireActivity(), value -> editText1.setText(value));
    }
}