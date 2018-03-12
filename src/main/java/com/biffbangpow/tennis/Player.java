package com.biffbangpow.tennis;

public class Player {

    private int point;
    private int game;

    public int getPoint() {
        return point;
    }

    public void wins() {
        point++;
    }

    public void resetPoint() {
        point = 0;
    }

    public void incrementGame() {
        game++;
    }

    public int getGame() {
        return game;
    }
}

