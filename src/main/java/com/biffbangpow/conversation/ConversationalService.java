package com.biffbangpow.conversation;

import java.util.function.Function;
import java.util.function.Supplier;

public class ConversationalService {

    private ConversationHandler<Context, ResultOp> handler = new ConversationHandler<>();
    private Supplier<ResultOp> supplier;

    public ConversationalService(Supplier<ResultOp> supplier) {
        this.supplier = supplier;
    }

    public ResultOp operation1(Context context) {

        Function<Context, ResultOp> job = context1 -> supplier.get();
        return handler.startConversation(context, job, "Operation1");
    }

    public ResultOp operation2(Context context) {

        Function<Context, ResultOp> job = context1 -> supplier.get();
        return handler.closeConversation(context, job, "Operation2");
    }

}
