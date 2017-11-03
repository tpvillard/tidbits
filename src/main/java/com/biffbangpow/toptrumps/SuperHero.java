package com.biffbangpow.toptrumps;

import java.util.*;

public class SuperHero {

    private final StrengthComparator strengthComparator = new StrengthComparator();
    private final SpecialPowerComparator specialPowerComparator = new SpecialPowerComparator();
    private final WeaponComparator weaponComparator = new WeaponComparator();

    enum Type {
        STRENGTH,
        SPECIAL_POWER,
        WEAPON
    }

    private String name;
    private int physicalStrength;
    private int specialPower;
    private int weapon;
    private Map<Type, Integer> stats = new HashMap<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPhysicalStrength() {
        return physicalStrength;
    }

    public void setPhysicalStrength(int physicalStrength) {
        this.physicalStrength = physicalStrength;
    }

    public int getSpecialPower() {
        return specialPower;
    }

    public void setSpecialPower(int specialPower) {
        this.specialPower = specialPower;
    }

    public int getWeapon() {
        return weapon;
    }

    public void setWeapon(int weapon) {
        this.weapon = weapon;
    }

    public void calculateStats(List<SuperHero> deck) {

        stats.put(Type.STRENGTH, (int) (deck.stream().filter(h -> h.getPhysicalStrength() < physicalStrength).count() * 100 / deck.size()));
        stats.put(Type.SPECIAL_POWER, (int) (deck.stream().filter(h -> h.getSpecialPower() < specialPower).count() * 100 / deck.size()));
        stats.put(Type.WEAPON, (int) (deck.stream().filter(h -> h.getWeapon() < weapon).count() * 100 / deck.size()));
    }

    public Comparable<SuperHero> getComparator() {

        switch (getTypeForMaxStat()) {

            case STRENGTH:
                return strengthComparator;
            case SPECIAL_POWER:
                return specialPowerComparator;
            case WEAPON:
                return weaponComparator;
            default:
                throw new IllegalStateException("Unknown type: " + getTypeForMaxStat());
        }
    }

    Type getTypeForMaxStat() {

        int max = 0;
        Map.Entry<Type, Integer> found = null;
        for (Map.Entry<Type, Integer> entry : stats.entrySet()) {
            if (entry.getValue() >= max) {
                max = entry.getValue();
                found = entry;
            }
        }
        return found.getKey();
    }

    public Map<Type, Integer> getStats() {
        return stats;
    }

    @Override
    public String toString() {
        return name;
    }

    private class StrengthComparator implements Comparable<SuperHero> {

        @Override
        public int compareTo(SuperHero defender) {

            return physicalStrength - defender.getPhysicalStrength();
        }
    }

    private class SpecialPowerComparator implements Comparable<SuperHero> {

        @Override
        public int compareTo(SuperHero defender) {

            return specialPower - defender.getSpecialPower();
        }
    }

    private class WeaponComparator implements Comparable<SuperHero> {

        @Override
        public int compareTo(SuperHero defender) {

            return weapon - defender.getWeapon();
        }
    }
}
