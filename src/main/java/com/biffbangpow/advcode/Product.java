package com.biffbangpow.advcode;

import java.util.HashSet;
import java.util.Set;

public class Product {

    private final Set<AdvantageCode> codes = new HashSet<>();


    public void add(AdvantageCode code) {
        codes.add(code);
    }

    public boolean contains(AdvantageCode code) {
        return codes.contains(code);
    }

    public boolean isRequestedForPassenger(Passenger pax) {
        Set<AdvantageCode> intersection = new HashSet<>(codes);
        intersection.retainAll(pax.getAdvantages());
        return intersection.size() != 0;
    }
}
