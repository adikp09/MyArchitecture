package com.dev.adi.myarchitecture.controller;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.TextView;
import com.dev.adi.myarchitecture.R;

public class Main2Activity extends AppCompatActivity {

    private Button button;
    private TextView textView;
    private GridLayout gridLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        textView = findViewById(R.id.textView);
        gridLayout = findViewById(R.id.gridLayout);
    }

    public void onClickBtn(View v) {
        button = (Button) v;

        String buttonTag = (String) button.getTag();
        String row, col;
        row = buttonTag.substring(0,1);
        col = buttonTag.substring(1,2);

        button.setText(row + ", " + col);

//        Intent intent;
//        intent = new Intent(this, WinnerActivity.class);
//        //send data
//        intent.putExtra("data", "You Win");
//        startActivity(intent);

        textView.setText(row + ", " + col);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_item, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.action_new_game) {
            int childCount = gridLayout.getChildCount();
            for (int i = 0; i < childCount; i++) {
                ((Button) gridLayout.getChildAt(i)).setText("");
            }
        }

        return super.onOptionsItemSelected(item);
    }
}
