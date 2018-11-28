package com.dev.adi.myarchitecture.presenter;

import com.dev.adi.myarchitecture.model.Board;
import com.dev.adi.myarchitecture.model.Player;
import com.dev.adi.myarchitecture.view.MainView;

public class MainPresenter {
    private MainView view;
    private Board model;

    public MainPresenter(MainView v) {
        this.view = v;
        this.model = new Board();
    }

    public void onClickButton(int row, int col) {
        Player player = model.setBoardValue(row, col);

        if(player != null) {
            view.setButtonText(row, col, player.toString());
            if (model.getIsWinner() != null) {
                view.showWinner(player.toString());
            }
        }
    }

    public void onResetGame() {
        model.reset();
        view.clearButton();
        view.clearView();
    }
}
