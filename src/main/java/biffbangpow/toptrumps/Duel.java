package biffbangpow.toptrumps;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Duel {

    private static final Logger LOGGER = LoggerFactory
            .getLogger(Duel.class);

    private List<SuperHero> deck;
    private final Random random = new Random();

    public Duel(List<SuperHero> heroes) {
        this.deck = new ArrayList<>(heroes);
    }

    public void play() {
        List<SuperHero> winners = exhaustDeck();
        while (winners.size() > 1) {
            deck = winners;
            winners = exhaustDeck();
        }
        LOGGER.info("Winner is: {}", winners.get(0).getName());

    }

    public List<SuperHero> exhaustDeck() {
        List<SuperHero> winners = new ArrayList<>();
        while (deck.size() > 2) {
            int index = random.nextInt(deck.size());
            SuperHero attacker = deck.remove(index);
            index = random.nextInt(deck.size());
            SuperHero defender = deck.remove(index);
            Comparable<SuperHero> comp = createComparator(attacker);
            int result = comp.compareTo(defender);
            if (result == 0) {
                winners.add(attacker);
                winners.add(defender);
            } else if (result < 0) {
                winners.add(defender);
            } else {
                winners.add(attacker);
            }
        }
        winners.addAll(deck);
        return winners;
    }

    public Comparable<SuperHero> createComparator(SuperHero hero) {

        if (hero.getWeapon() > 5) {
            return new WeaponComparator(hero);
        } else if (hero.getSpecialPower()  > 7) {
            return new SpecialPowerComparator(hero);
        } else {
            return new StrengthComparator(hero);
        }
    }

    private static class StrengthComparator implements Comparable<SuperHero> {

        private final SuperHero attacker;

        StrengthComparator(SuperHero attacker) {
            this.attacker = attacker;
        }

        @Override
        public int compareTo(SuperHero defender) {

            return attacker.getPhysicalStrength() - defender.getPhysicalStrength() ;
        }
    }

    private static class SpecialPowerComparator implements Comparable<SuperHero> {

        private final SuperHero attacker;

        SpecialPowerComparator(SuperHero attacker) {
            this.attacker = attacker;
        }

        @Override
        public int compareTo(SuperHero defender) {

            return attacker.getSpecialPower() - defender.getSpecialPower() ;
        }
    }

    private static class WeaponComparator implements Comparable<SuperHero> {

        private final SuperHero attacker;

        WeaponComparator(SuperHero attacker) {
            this.attacker = attacker;
        }

        @Override
        public int compareTo(SuperHero defender) {

            return attacker.getWeapon() - defender.getWeapon();
        }
    }
}
