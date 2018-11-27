package com.dev.adi.myarchitecture.controller;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import com.dev.adi.myarchitecture.R;

public class WinnerActivity extends AppCompatActivity {

    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView3);
        //get data
        String dataIntent= getIntent().getExtras().getString("data");
        textView.setText(dataIntent);
        //------

        System.out.println(dataIntent);
    }
}
