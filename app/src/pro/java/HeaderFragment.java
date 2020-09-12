import android.content.ClipboardManager;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.example.myapplication.ConverterViewModel;
import com.example.myapplication.R;


public class HeaderFragment extends Fragment  implements AdapterView.OnItemSelectedListener{

    ConverterViewModel model;
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
        editText = (EditText) viewHierarchy.findViewById(R.id.etNum);
        editText1 = (EditText) viewHierarchy.findViewById(R.id.etNum1);
        buttonChange = (Button) viewHierarchy.findViewById(R.id.btnchange);
        buttonCopy1 = (Button) viewHierarchy.findViewById(R.id.btncopyfirstfield);
        buttonCopy2 = (Button) viewHierarchy.findViewById(R.id.btncopysecondfield);
        spinner = viewHierarchy.findViewById(R.id.spinner);
        spinner2 = viewHierarchy.findViewById(R.id.spinner2);
        clipboardManager = (ClipboardManager)getActivity().getSystemService(Context.CLIPBOARD_SERVICE);

        spinner.setOnItemSelectedListener(this);
        spinner2.setOnItemSelectedListener(this);
        model = ViewModelProviders.of(getActivity()).get(ConverterViewModel.class);
        buttonChange.setOnClickListener(item -> model.changeFields());
        buttonCopy1.setOnClickListener(item -> model.coppyInBuffer(1,clipboardManager));
        buttonCopy2.setOnClickListener(item -> model.coppyInBuffer(2,clipboardManager));

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