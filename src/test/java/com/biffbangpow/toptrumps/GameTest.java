package com.biffbangpow.toptrumps;

import org.testng.annotations.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GameTest {

    public void test_duel() throws IOException {
        DataAccess access = new DataAccess("src/main/resources/toptrumps.yaml");
        Config conf = access.getConf();
        Game game = new Game(conf.getHeroes());
        game.play();
    }

    @Test
    public void test_hundred_duel() throws IOException {
        DataAccess access = new DataAccess("src/main/resources/toptrumps.yaml");
        Config top = access.getConf();

        access = new DataAccess("src/main/resources/mediumtrumps.yaml");
        Config medium = access.getConf();

        access = new DataAccess("src/main/resources/lowtrumps.yaml");
        Config low = access.getConf();

        List<SuperHero> heroes = new ArrayList<>(top.getHeroes());
        heroes.addAll(medium.getHeroes());
        heroes.addAll(low.getHeroes());

        Game game = new Game(heroes);
        game.play(500000);
    }
}
