package com.biffbangpow.tennis;


public enum PointToScore {

    ZERO(0, "0"),
    FIVETEEN(1, "15"),
    THIRTY(2, "30"),
    FOURTY(3, "40");

    private final int point;
    private final String score;

    PointToScore(int i, String s) {
        this.point = i;
        this.score = s;
    }

    public static String getScoreFor(int point) {
        for (PointToScore pointToScore : values())  {
            if (pointToScore.point == point) {
                return pointToScore.score;
            }
        }
        throw new IllegalArgumentException("Illegal point: " + point);
    }
}
