package com.dev.adi.myarchitecture.controller;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.TextView;
import com.dev.adi.myarchitecture.R;
import com.dev.adi.myarchitecture.model.Board;
import com.dev.adi.myarchitecture.model.Player;

public class Main2Activity extends AppCompatActivity {

    private Board model;

    private Button button;
    private TextView textView;
    private View textViewGrup;
    private GridLayout gridLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        textView = findViewById(R.id.textView);
        textViewGrup = findViewById(R.id.textViewGrup1);
        gridLayout = findViewById(R.id.gridLayout);

        model = new Board();
    }

    public void onClickBtn(View v) {
        button = (Button) v;

        String tag = (String) button.getTag();
        int row = Integer.valueOf(tag.substring(0,1));
        int col = Integer.valueOf(tag.substring(1,2));
        Log.i("this", "Row: [" + row + "," + col + "]");

        Player move = model.setBoardValue(row, col);

        if (move != null) {
            button.setText(move.toString());
            if (model.getIsWinner() != null) {
                textView.setText(move.toString());
                textViewGrup.setVisibility(View.VISIBLE);
            }
        }

    }

    public void resetGame() {
        textViewGrup.setVisibility(View.GONE);
        textView.setText("");

        model.reset();
        for (int i = 0; i < gridLayout.getChildCount(); i++) {
            ((Button) gridLayout.getChildAt(i)).setText("");
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_item, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.action_new_game) {
            resetGame();
        }

        return super.onOptionsItemSelected(item);
    }
}
