package by.bsuir.Converter;

import android.app.Application;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

public class ConverterViewModel extends AndroidViewModel {
    private final MutableLiveData<String> liveDataFirst = new MutableLiveData<>("");
    private final MutableLiveData<String> liveDataSecond = new MutableLiveData<>("");
    private final MutableLiveData<Float> procent = new MutableLiveData<>();

    public ConverterViewModel(@NonNull Application application) {
        super(application);
    }

    public void setNumber(String item) {
        liveDataFirst.setValue(liveDataFirst.getValue() + item);
        convertField();
    }

    public void setDot() {
        if (!liveDataFirst.getValue().contains(".")) {
            liveDataFirst.setValue(liveDataFirst.getValue() + ".");
            convertField();
        }
    }

    public void clearTheField() {
        liveDataFirst.setValue("");
        liveDataSecond.postValue("");
    }

    public void clearTheSymbol() {
        if (liveDataFirst.getValue().length() > 1) {
            liveDataFirst.setValue(liveDataFirst.getValue().substring(0, liveDataFirst.getValue().length() - 1));
            convertField();
        } else {
            clearTheField();
        }
    }

    public LiveData<String> getNumber() {
        return liveDataFirst;
    }

    public LiveData<String> Convert() {
        return liveDataSecond;
    }

    public void convertField() {
        liveDataSecond.postValue(Float.toString((float) (Float.parseFloat(liveDataFirst.getValue()) * procent.getValue())));
    }

    public void changeFields() {
        MutableLiveData<String> dataTemp = liveDataSecond;
        liveDataFirst.setValue(dataTemp.getValue());
        convertField();
    }

    public void coppyInBuffer(int field, ClipboardManager clipboardManager) {
        switch (field) {
            case 1:
                ClipData clipData = ClipData.newPlainText("text", liveDataFirst.getValue());
                clipboardManager.setPrimaryClip(clipData);
                break;
            case 2:
                clipData = ClipData.newPlainText("text", liveDataSecond.getValue());
                clipboardManager.setPrimaryClip(clipData);
                break;
        }
        Toast toast = Toast.makeText(getApplication(), "The copy was successful", Toast.LENGTH_LONG);
        toast.show();
    }

    public void selectData(Float procent) {
        this.procent.setValue(procent);
        if (liveDataFirst.getValue().length() != 0)
            convertField();
    }
}