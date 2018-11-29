package com.dev.adi.myarchitecture.controller;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.*;
import com.dev.adi.myarchitecture.R;
import com.dev.adi.myarchitecture.retrofit.RetrofitClientInstance;
import com.dev.adi.myarchitecture.retrofit.Services;
import com.dev.adi.myarchitecture.retrofit.User;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.util.ArrayList;
import java.util.List;

public class ChoosePlayerActivity extends AppCompatActivity {

    private Spinner spNamen1;
    private Spinner spNamen2;
    private LinearLayout lineLoading;
    List<String> username = new ArrayList<>();
    String pOneName = "", pTwoName = "";
    private String defaultVal = "Choose Name";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player);

        spNamen1 = findViewById(R.id.player1);
        spNamen2 = findViewById(R.id.player2);
        lineLoading = findViewById(R.id.line_loading);

        lineLoading.setVisibility(View.VISIBLE);

        Services service = new RetrofitClientInstance().getInstance().create(Services.class);
        Call<List<User>> call = service.getUser();
        call.enqueue(new Callback<List<User>>() {
            @Override
            public void onResponse(Call<List<User>> call, Response<List<User>> response) {
                if (response.isSuccessful()) {
                    List<User> dataUser = response.body();
                    username.add(defaultVal);
                    for(int i = 0; i < dataUser.size(); i++) {
                        username.add(dataUser.get(i).getName());
                    }
                }
                ArrayAdapter dataAdapter = new ArrayAdapter(getBaseContext(),android.R.layout.simple_spinner_item, username);
                dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spNamen1.setAdapter(dataAdapter);
                spNamen2.setAdapter(dataAdapter);
                lineLoading.setVisibility(View.GONE);
            }

            @Override
            public void onFailure(Call<List<User>> call, Throwable t) { }
        });

        spNamen1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                pOneName = spNamen1.getSelectedItem().toString();
                if(pOneName != defaultVal && pTwoName != defaultVal) {
                        Intent intent = new Intent(getBaseContext(), Main2Activity.class);
                        intent.putExtra("playerOneName", pOneName);
                        intent.putExtra("playerTwoName", pTwoName);
                        startActivity(intent);
                        finish();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        spNamen2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                pTwoName = spNamen2.getSelectedItem().toString();
                if(pOneName != defaultVal && pTwoName != defaultVal) {
                    if (pOneName.equals(pTwoName)) {
                        Toast.makeText(getBaseContext(), "Name can't be same", Toast.LENGTH_SHORT).show();
                    } else {
                        Intent intent = new Intent(getBaseContext(), Main2Activity.class);
                        intent.putExtra("playerOneName", pOneName);
                        intent.putExtra("playerTwoName", pTwoName);
                        startActivity(intent);
                        finish();
                    }
                } else {
                    Toast.makeText(getBaseContext(), "Choose Player one first", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }
}
