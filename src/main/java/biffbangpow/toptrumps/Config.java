package biffbangpow.toptrumps;


import java.util.List;

public class Config {

    private List<SuperHero> heroes;

    List<SuperHero> getHeroes() {
        return heroes;
    }

    public void setHeroes(List<SuperHero> heroes) {
        this.heroes = heroes;
    }


    int size() {
        return heroes.size();
    }
}
