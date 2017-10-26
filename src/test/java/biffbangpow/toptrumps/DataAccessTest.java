package biffbangpow.toptrumps;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;

public class DataAccessTest {

    @Test
    public void test_read_configuration() throws IOException {
        System.out.println(System.getProperty("user.dir"));
        DataAccess access = new DataAccess("src/test/resources/heroes.yaml");
        Config conf = access.getSuperHeroes();
        Assert.assertEquals(conf.size(), 2);

        List<SuperHero> heroes = conf.getHeroes();
        SuperHero galactus = heroes.get(0);
        Assert.assertEquals(galactus.getWeapon(), 9);
    }
}
