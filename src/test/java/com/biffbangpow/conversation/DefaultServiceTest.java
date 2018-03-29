package com.biffbangpow.conversation;


import com.biffbangpow.tennis.Game;
import com.biffbangpow.tennis.Player;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.function.Supplier;

public class DefaultServiceTest {

    private DefaultService service;

    @BeforeMethod
    public void setUp() {

        service = new DefaultService(ResultOp::new);
    }

    @Test
    public void should_print_operation() {

        service.operation1(new Context());
    }

    @Test
    public void should_print_operation2() {

        service.operation2(new Context());
    }
}
