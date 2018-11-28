package com.dev.adi.myarchitecture.view;

public interface MainView {
    void setButtonText(int row, int col, String text);
    void showWinner(String string);
    void clearButton();
    void clearView();
}
