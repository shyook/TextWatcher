package com.example.limei.limit_digit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private final int MAX_COUNT = 11;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText et = findViewById(R.id.phone_number_et);
        et.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                Log.d("TEST", "beforeTextChanged : " + charSequence);
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                Log.d("TEST", "onTextChanged : " + charSequence);
                if (charSequence.length() > MAX_COUNT) {
                    et.setText(et.getText().toString().substring(0, MAX_COUNT));
                    et.setSelection(et.length());
                }

            }

            @Override
            public void afterTextChanged(Editable editable) {
                Log.d("TEST", "afterTextChanged : " + editable);

            }
        });

    }
}
