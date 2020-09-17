package by.bsuir.Converter;

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
        if (action.equals("by.bsuir.Converter." + getString(R.string.idVersion) + ".Currency")) {
            layoutId = R.array.spinnerItemCurrency;
        } else if (action.equals("by.bsuir.Converter." + getString(R.string.idVersion) + ".Distance")) {
            layoutId = R.array.spinnerItemDistance;
        } else if (action.equals("by.bsuir.Converter." + getString(R.string.idVersion) + ".Weight")) {
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