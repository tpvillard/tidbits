package com.biffbangpow.comparator;

import java.util.Comparator;


public class ComparatorSample {

    public Comparator<String> createComparator() {
        return Comparator.naturalOrder();
    }
}
