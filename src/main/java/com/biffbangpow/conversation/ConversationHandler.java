package com.biffbangpow.conversation;

import java.util.function.Function;

public class ConversationHandler<T, R> {

    public R startConversation(T t, Function<T, R> job, String opName) {

        try {
            startConversation();
        } catch (ConversationException e) {
            logException(opName);
        }
        logException(opName);
        return job.apply(t);
    }

    public R closeConversation(T t,Function<T, R> job, String opName) {

        try {
            closeConversation();
        } catch (ConversationException e) {
            logException(opName);
        }
        return job.apply(t);
    }

    private void logException(String opName) {
        System.out.println("Op: "+opName);
    }

    private void startConversation() throws ConversationException {

    }

    private void closeConversation() throws ConversationException {

    }
}
