package com.dev.adi.myarchitecture.controller;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import com.dev.adi.myarchitecture.R;

public class Main2Activity extends AppCompatActivity {

    private Toolbar mTopToolbar;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        mTopToolbar = findViewById(R.id.my_toolbar);
        mTopToolbar.setTitle("Tic-Tac-Toe");
        setSupportActionBar(mTopToolbar);

        textView = findViewById(R.id.tv_reset);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getBaseContext(), "reset", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
