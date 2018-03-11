package com.biffbangpow.tennis;

public class Game {

    private final Player server;
    private final Player receiver;

    public Game(Player server, Player receiver) {
        this.server = server;
        this.receiver = receiver;
    }

    public String getScore() {

        if (server.getPoint() >= 4 || receiver.getPoint() >= 4) {
            int diff = server.getPoint() - receiver.getPoint();
            switch (diff) {
                case (0):
                    return "Equality";
                case(1):
                    return "Advantage Server";
                case(-1):
                    return "Advantage Receiver";
                default:
                    throw new IllegalArgumentException("Diff in error: " + diff);
            }
        }

        if (server.getPoint() == receiver.getPoint()) {
            return PointToScore.getScoreFor(server.getPoint()) + "A";
        }
        return PointToScore.getScoreFor(server.getPoint()) + " - " + PointToScore.getScoreFor(receiver.getPoint());
    }

    public void serverWins() {
        server.wins();
    }

    public void receiverWins() {
        receiver.wins();
    }
}
