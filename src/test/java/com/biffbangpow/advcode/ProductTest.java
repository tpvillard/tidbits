package com.biffbangpow.advcode;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ProductTest {

    Product product;

    @BeforeMethod
    public void setUp() {
        product = new Product();
    }


    @Test
    public void should_add_advantage_code() {

        AdvantageCode gh55c = new DefaultAdvantageCode("GH055C");
        product.add(gh55c);
        product.add(AdvantageCodeEnum.GH03C);

        AdvantageCode anotherGh55c = new DefaultAdvantageCode("GH055C");

        Assert.assertTrue(product.contains(AdvantageCodeEnum.GH03C));
        Assert.assertTrue(product.contains(anotherGh55c));

    }

    @Test
    public void should_return_product_requested() {

        AdvantageCode gh55c = new DefaultAdvantageCode("GH055C");
        product.add(gh55c);
        product.add(AdvantageCodeEnum.GH03C);

        Passenger pax = new Passenger();
        pax.add(AdvantageCodeEnum.GH03C);

        Assert.assertTrue(product.isRequestedForPassenger(pax));
    }

    @Test
    public void should_not_return_product_requested() {

        AdvantageCode gh55c = new DefaultAdvantageCode("GH055C");
        product.add(gh55c);

        Passenger pax = new Passenger();
        pax.add(AdvantageCodeEnum.GH03C);

        Assert.assertFalse(product.isRequestedForPassenger(pax));
    }

    @Test
    public void should_return_product_requested_for_gh03c() {

        AdvantageCode gh03c = new DefaultAdvantageCode("GH03C");
        product.add(gh03c);

        Passenger pax = new Passenger();
        pax.add(AdvantageCodeEnum.GH03C);

        Assert.assertTrue(product.isRequestedForPassenger(pax));
    }
}
