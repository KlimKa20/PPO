import android.content.ClipboardManager;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.Spinner;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import by.bsuir.Converter.ConverterViewModel;
import by.bsuir.Converter.R;


public class HeaderFragment extends Fragment implements AdapterView.OnItemSelectedListener {

    ConverterViewModel model;
    EditText editText;
    EditText editText1;
    Spinner spinner;
    Spinner spinner2;
    ClipboardManager clipboardManager;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View viewHierarchy = inflater.inflate(R.layout.fragment_header, container, false);
        editText = viewHierarchy.findViewById(R.id.etNum);
        editText1 = viewHierarchy.findViewById(R.id.etNum1);
        spinner = viewHierarchy.findViewById(R.id.spinner);
        spinner2 = viewHierarchy.findViewById(R.id.spinner2);
        spinner.setOnItemSelectedListener(this);
        spinner2.setOnItemSelectedListener(this);
        model = ViewModelProviders.of(getActivity()).get(ConverterViewModel.class);
        clipboardManager = (ClipboardManager) getActivity().getSystemService(Context.CLIPBOARD_SERVICE);

        model.getNumber().observe(requireActivity(), value -> editText.setText(value));
        model.Convert().observe(requireActivity(), value -> editText1.setText(value));
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
}