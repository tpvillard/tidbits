package com.biffbangpow.shift;


import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.lang.*;
import java.lang.Integer;
import java.util.TreeMap;

public class TreeMapTest {

    private TreeMap<java.lang.Integer, String> map = new TreeMap<>();

    @BeforeClass
    public void setUp() {
        map.put(1, "1");
        map.put(4, "1");
        map.put(5, "1");
        map.put(7, "1");
        map.put(8, "1");
        map.put(9, "1");
    }

    @Test
    public void test_get_floor_key() {

        Assert.assertEquals((int) map.floorKey(6), 5);
    }

    @Test
    public void test_get_ceiling_key() {

        Assert.assertEquals((int) map.ceilingKey(6), 7);
    }

    @Test
    public void test_get_first_key() {

        Assert.assertEquals((int) map.firstKey(), 1);
    }
}
