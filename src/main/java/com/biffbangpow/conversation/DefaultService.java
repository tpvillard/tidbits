package com.biffbangpow.conversation;

import java.util.function.Supplier;

public class DefaultService extends AbstractService<ResultOp, Context> {

    private Supplier<ResultOp> supplier;

    public DefaultService(Supplier<ResultOp> supplier) {
        this.supplier = supplier;
    }


    public ResultOp operation1(Context context) {

        Job<ResultOp, Context> job = context1 -> supplier.get();
        return startConversation(context, job);
    }

    public ResultOp operation2(Context context) {

        Job<ResultOp, Context> job = context1 -> supplier.get();
        return closeConversation(context, job);
    }

    public ResultOp operation3(Context context) {

        Job<ResultOp, Context> job = context1 -> supplier.get();
        return closeConversation(context, job);
    }

}
