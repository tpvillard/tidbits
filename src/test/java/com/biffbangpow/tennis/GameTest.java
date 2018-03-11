package com.biffbangpow.tennis;


import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class GameTest {

    private Game game;

    @BeforeMethod
    public void setUp() {

        Player john = new Player();
        Player bjorn = new Player();
        game = new Game(john, bjorn);
    }

    @Test
    public void should_return_15_0() {

        // When
        game.serverWins();

        // Then
        Assert.assertEquals(game.getScore(), "15 - 0");
    }

    @Test
    public void should_return_0_15() {

        // When
        game.receiverWins();

        // Then
        Assert.assertEquals(game.getScore(), "0 - 15");
    }

    @Test
    public void should_return_15A() {

        // When
        game.receiverWins();
        game.serverWins();

        // Then
        Assert.assertEquals(game.getScore(), "15A");
    }

    @Test
    public void should_return_advantage_server() {

        // When
        game.receiverWins();
        game.serverWins();
        game.receiverWins();
        game.serverWins();
        game.receiverWins();
        game.serverWins();
        game.serverWins();

        // Then
        Assert.assertEquals(game.getScore(), "Advantage Server");
    }

    @Test
    public void should_return_advantage_receiver() {

        // When
        game.receiverWins();
        game.serverWins();
        game.receiverWins();
        game.serverWins();
        game.receiverWins();
        game.serverWins();
        game.receiverWins();

        // Then
        Assert.assertEquals(game.getScore(), "Advantage Receiver");
    }

    @Test
    public void should_return_equality() {

        // When
        game.receiverWins();
        game.serverWins();
        game.receiverWins();
        game.serverWins();
        game.receiverWins();
        game.serverWins();
        game.receiverWins();
        game.serverWins();

        // Then
        Assert.assertEquals(game.getScore(), "Equality");
    }
}
