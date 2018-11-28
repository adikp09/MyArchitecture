package com.dev.adi.myarchitecture.model;

import android.util.Log;

import static com.dev.adi.myarchitecture.model.Player.O;
import static com.dev.adi.myarchitecture.model.Player.X;

public class Board {

    private Boolean isOver;
    private Player turnPlayer;
    private Player isWinner;

    private Cell cell[][] = new Cell[3][3];

    public Board() {
        reset();
    }

    public void clearCellValue() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                cell[i][j] = new Cell();
            }
        }
    }

    public void reset() {
        clearCellValue();
        isWinner = null;
        isOver = false;
        turnPlayer = X;
    }

    public Player getIsWinner() {
        return isWinner;
    }

    public boolean checkGame(int row, int col) {
        if (isOver) {
            return false;
        } else if (isAlreadySet(row, col)) {
            return false;
        }
        return true;
    }

    public boolean isAlreadySet(int row, int col) {
        return cell[row][col].getCell() != null;
    }


    public Player setBoardValue(int row, int col) {
        Player move = null;
        if (checkGame(row, col)) {
            cell[row][col].setCell(turnPlayer);
            move = turnPlayer;
            if (checkWin(turnPlayer, row, col)) {
                isOver = true;
                isWinner = turnPlayer;
            } else {
                changeTurn();
            }
        }
        return move;
    }

    public boolean isDraw() {
        Log.e("isDraw", "1");
        Boolean isDraw = true;
        for (int i = 0; i < 3; i++) {
            Log.e("i", "2");
            for (int j = 0; j < 3; j++) {
                Log.e("j", "3");
                if (cell[i][j].getCell() == null) {
                    Log.e("isDraw", turnPlayer.toString());
                    isDraw = false;
                }
            }
        }
        return isDraw;
    }

    public boolean checkWin(Player player, int row, int col) {
        return (cell[row][0].getCell() == player
                && cell[row][1].getCell() == player
                && cell[row][2].getCell() == player

                || cell[0][col].getCell() == player
                && cell[1][col].getCell() == player
                && cell[2][col].getCell() == player

                || row == col
                && cell[0][0].getCell() == player
                && cell[1][1].getCell() == player
                && cell[2][2].getCell() == player

                || row + col == 2
                && cell[0][0].getCell() == player
                && cell[1][1].getCell() == player
                && cell[2][2].getCell() == player
        );
    }

    public void changeTurn() {
        turnPlayer = turnPlayer == X ? O : X;
    }
}
