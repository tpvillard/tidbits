package com.biffbangpow.advcode;

import java.util.HashSet;
import java.util.Set;

public class Product {

    private final Set<AdvantageCode> codes = new HashSet<>();


    public void add(AdvantageCode code) {
        codes.add(code);
    }

    boolean contains(AdvantageCode code) {
        return codes.contains(code);
    }
}
