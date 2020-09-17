package by.bsuir.Converter;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;


public class TableFragment extends Fragment {
    ConverterViewModel mViewModel;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View viewHierarchy = inflater.inflate(R.layout.fragment_table, container, false);

        viewHierarchy.findViewById(R.id.btn0).setOnClickListener(item -> mViewModel.setNumber("0"));
        viewHierarchy.findViewById(R.id.btn000).setOnClickListener(item -> mViewModel.setNumber("000"));
        viewHierarchy.findViewById(R.id.btn1).setOnClickListener(item -> mViewModel.setNumber("1"));
        viewHierarchy.findViewById(R.id.btn2).setOnClickListener(item -> mViewModel.setNumber("2"));
        viewHierarchy.findViewById(R.id.btn3).setOnClickListener(item -> mViewModel.setNumber("3"));
        viewHierarchy.findViewById(R.id.btn4).setOnClickListener(item -> mViewModel.setNumber("4"));
        viewHierarchy.findViewById(R.id.btn5).setOnClickListener(item -> mViewModel.setNumber("5"));
        viewHierarchy.findViewById(R.id.btn6).setOnClickListener(item -> mViewModel.setNumber("6"));
        viewHierarchy.findViewById(R.id.btn7).setOnClickListener(item -> mViewModel.setNumber("7"));
        viewHierarchy.findViewById(R.id.btn8).setOnClickListener(item -> mViewModel.setNumber("8"));
        viewHierarchy.findViewById(R.id.btn9).setOnClickListener(item -> mViewModel.setNumber("9"));
        viewHierarchy.findViewById(R.id.btnc).setOnClickListener(item -> mViewModel.clearTheField());
        viewHierarchy.findViewById(R.id.btndelete).setOnClickListener(item -> mViewModel.clearTheSymbol());
        viewHierarchy.findViewById(R.id.btndot).setOnClickListener(item -> mViewModel.setDot());

        return viewHierarchy;
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mViewModel = ViewModelProviders.of(getActivity()).get(ConverterViewModel.class);
    }
}