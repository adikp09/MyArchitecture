package com.dev.adi.myarchitecture.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.TextView;
import com.dev.adi.myarchitecture.R;
import com.dev.adi.myarchitecture.presenter.MainPresenter;

public class Main2Activity extends AppCompatActivity implements MainView {

    private MainPresenter presenter;
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

        presenter = new MainPresenter(this);
    }


    public void onClickBtn(View view) {
        button = (Button) view;

        String tag = (String) button.getTag();
        int row = Integer.valueOf(tag.substring(0,1));
        int col = Integer.valueOf(tag.substring(1,2));

        presenter.onClickButton(row, col);
    }

    @Override
    public void setButtonText(int row, int col, String text) {
        Button btn = gridLayout.findViewWithTag("" + row + col);
        btn.setText(text);
    }

    @Override
    public void showWinner(String text) {
        textViewGrup.setVisibility(View.VISIBLE);
        textView.setText(text);
    }

    @Override
    public void clearButton() {
        resetView();
    }

    @Override
    public void clearView() {
        textViewGrup.setVisibility(View.GONE);
        textView.setText("");
    }

    public void resetView() {
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
            presenter.onResetGame();
        }

        return super.onOptionsItemSelected(item);
    }
}
