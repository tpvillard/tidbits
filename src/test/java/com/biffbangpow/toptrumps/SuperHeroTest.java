package com.biffbangpow.toptrumps;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;

public class SuperHeroTest {

    @Test
    public void test_calculate_stats() throws IOException {

        DataAccess access = new DataAccess("src/test/resources/heroes.yaml");
        Config conf = access.getConf();
        Assert.assertEquals(conf.getHeroes().size(), 2);

        List<SuperHero> deck = conf.getHeroes();

        SuperHero thor = new SuperHero();
        thor.setPhysicalStrength(9);
        thor.setSpecialPower(8);
        thor.setWeapon(6);
        thor.calculateStats(deck);

        Assert.assertTrue(thor.getStats().get(SuperHero.Type.STRENGTH) == 0);
        Assert.assertTrue(thor.getStats().get(SuperHero.Type.SPECIAL_POWER) == 50);
        Assert.assertTrue(thor.getStats().get(SuperHero.Type.WEAPON) == 50);

        Assert.assertEquals(thor.getTypeForMaxStat(), SuperHero.Type.WEAPON);
    }
}
