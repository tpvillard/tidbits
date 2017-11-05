package com.biffbangpow.toptrumps;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;
import java.util.stream.Collectors;

/**
 * This is a top trump game simulation based on Marvel super heroes.
 *
 * The game is as follow:
 *
 * Pick an attacker card from the deck, choose a property for the fight among strength, special power, weapon.
 * Pick a defender card, the defeated card is removed from the deck.
 * Play the game until there is one (or possibly two) final(s) winner(s).
 *
 * The program tries to answer the question:
 *
 * Can a low level trump (ie a very weak super hero like Tarentula) win a game?
 *
 */
public class Game {

    private static final Logger LOGGER = LoggerFactory
            .getLogger(Game.class);

    private List<SuperHero> config;
    private final Map<String, Integer> stats = new HashMap<>();

    /**
     * Builds a game with the specified deck of super heroes
     * @param heroes the super heroes
     */
    public Game(List<SuperHero> heroes) {
        this.config = heroes;
    }

    /**
     * Play n games
     * @param n the number of games to play
     */
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

        List<Map.Entry<String,Integer>> entries = stats.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Collections.reverseOrder()))
                .collect(Collectors.toList());
        for (Map.Entry<String,Integer> entry : entries) {
            LOGGER.info("{}: {}", entry.getKey(), entry.getValue());
        }
    }

    /**
     * Play a game
     * @return the winner
     */
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

    private static List<SuperHero> exhaustDeck(List<SuperHero> deck) {

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
