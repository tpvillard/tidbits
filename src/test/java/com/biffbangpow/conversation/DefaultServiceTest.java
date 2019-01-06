package com.biffbangpow.conversation;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

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
    public void should_print_operation3() {

        service.operation1(new Context());
    }

    @Test
    public void should_print_operation2() {

        service.operation2(new Context());
    }
}
