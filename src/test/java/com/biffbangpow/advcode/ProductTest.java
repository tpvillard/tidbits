package com.biffbangpow.advcode;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ProductTest {

    Product product = new Product();


    @Test
    public void should_add_advantage_code() {

        AdvantageCode gh55c = new DefaultAdvantageCode("GH055C");
        product.add(gh55c);
        product.add(AdvantageCodeEnum.GH03C);

        AdvantageCode anotherGh55c = new DefaultAdvantageCode("GH055C");

        Assert.assertTrue(product.contains(AdvantageCodeEnum.GH03C));
        Assert.assertTrue(product.contains(anotherGh55c));

    }
}
