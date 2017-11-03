package com.biffbangpow.toptrumps;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

public class Game {

    private static final Logger LOGGER = LoggerFactory
            .getLogger(Game.class);

    private List<SuperHero> config;
    private final Map<String, Integer> stats = new HashMap<>();

    public Game(List<SuperHero> heroes) {
        this.config = heroes;
    }

    public void play(int n) {
        stats.clear();
        for (int i = 0; i < n; i++) {
            SuperHero hero = play();
            updateStats(hero);
        }
        dumpStats(n);
    }

    private void updateStats(SuperHero hero) {

        if (stats.get(hero.getName()) == null) {
            stats.put(hero.getName(), 1);
        } else {
            int count = stats.get(hero.getName());
            stats.put(hero.getName(), ++count);
        }
    }

    private void dumpStats(int n) {

        for (Map.Entry<String,Integer> entry : stats.entrySet()) {
            LOGGER.info("{}: {}", entry.getKey(), entry.getValue());
        }
    }

    public SuperHero play() {

        List<SuperHero> deck = new ArrayList<>(config);
        List<SuperHero> winners;
        int count = 0;
        do {
            winners = exhaustDeck(deck);
            deck = winners;
            count++;
            LOGGER.debug("End Of Round");

        } while (winners.size() > 1 && count < 20);
        if (winners.size() >= 2) {
            LOGGER.debug("Several Winners: {}", winners);
        }
        LOGGER.debug("Winner is: {}", winners.get(0).getName());
        return winners.get(0);
    }

    public static List<SuperHero> exhaustDeck(List<SuperHero> deck) {

        Random random = new Random();
        List<SuperHero> winners = new ArrayList<>();
        while (deck.size() >= 2) {

            int index = random.nextInt(deck.size());
            SuperHero attacker = deck.remove(index);
            attacker.calculateStats(deck);
            Comparable<SuperHero> comp = attacker.getComparator();

            index = random.nextInt(deck.size());
            SuperHero defender = deck.remove(index);
            int result = comp.compareTo(defender);
            if (result == 0) {
                LOGGER.debug("{} against {}: draw", attacker, defender);
                winners.add(attacker);
                winners.add(defender);
            } else if (result < 0) {
                LOGGER.debug("{} against {}: defender wins!", attacker, defender);
                winners.add(defender);
            } else {
                LOGGER.debug("{} against {}: attacker wins!", attacker, defender);
                winners.add(attacker);
            }
        }
        winners.addAll(deck);
        return winners;
    }
}
