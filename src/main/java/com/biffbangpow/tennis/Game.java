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
            if (diff >= 2) {
                server.resetPoint();
                server.incrementGame();
                return "Game: " + server.getGame() + ", " + PointToScore.getScoreFor(server.getPoint());
            } else if (diff == 1) {
                return "Advantage Server";
            } else if (diff == 0) {
                return "Equality";
            } else if (diff == -1) {
                return "Advantage Receiver";
            } else {
                receiver.resetPoint();
                receiver.incrementGame();
                return "Game: " + receiver.getGame() + ", " + PointToScore.getScoreFor(receiver.getPoint());
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
