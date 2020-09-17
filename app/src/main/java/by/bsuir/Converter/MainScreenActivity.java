package by.bsuir.Converter;

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
                intent = new Intent("by.bsuir.Converter." + getString(R.string.idVersion) + ".Currency");
                startActivity(intent);
                break;
            case R.id.btnDistance:
                intent = new Intent("by.bsuir.Converter." + getString(R.string.idVersion) + ".Distance");
                startActivity(intent);
                break;
            case R.id.btnWeight:
                intent = new Intent("by.bsuir.Converter." + getString(R.string.idVersion) + ".Weight");
                startActivity(intent);
                break;
        }
    }
}