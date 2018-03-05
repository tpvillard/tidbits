package com.biffbangpow.batch;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Main {

    public Map<String, Long> fillMap(List<String> books) {

        // Given a book table, this would be expressed as.
        // Select distinct title, count(*) from book
        return books.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    }
}
