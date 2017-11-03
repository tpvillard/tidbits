package com.biffbangpow.toptrumps;

import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.constructor.Constructor;
import org.yaml.snakeyaml.representer.Representer;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class DataAccess {

    private final String fileName;

    public DataAccess(String fileName) {
        this.fileName = fileName;
    }


    public Config getConf() throws IOException {

        Representer representer = new Representer();
        representer.getPropertyUtils().setSkipMissingProperties(true);
        Yaml yaml = new Yaml(new Constructor(Config.class), representer);
        return (Config) yaml.load(readFile(fileName));
    }

    private String readFile(String fileName) throws IOException {
        return new String(Files.readAllBytes(Paths.get(fileName)));
    }
}
