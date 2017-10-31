package biffbangpow.toptrumps;

import org.testng.annotations.Test;

import java.io.IOException;

public class DuelTest {

    @Test
    public void test_duel() throws IOException {
        DataAccess access = new DataAccess("src/main/resources/toptrumps.yaml");
        Config conf = access.getConf();
        Duel duel = new Duel(conf.getHeroes());
        duel.play();
    }
}
