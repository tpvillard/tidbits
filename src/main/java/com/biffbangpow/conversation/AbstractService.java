package com.biffbangpow.conversation;

public abstract class AbstractService<R, T> {


    protected interface Job<R, T>  {

        R execute(T t);
    }

    protected R startConversation(T t, Job<R, T> job) {

        try {
            startConversation();
        } catch (ConversationException e) {
            logException(job.getClass());
        }
        logException(job.getClass());
        return job.execute(t);
    }

    protected R closeConversation(T t, Job<R, T> job) {

        try {
            closeConversation();
        } catch (ConversationException e) {
            logException(job.getClass());
        }
        return job.execute(t);
    }

    private void logException(Class<? extends Job> opName) {
        System.out.println("Op: "+opName);
    }

    private void startConversation() throws ConversationException {

    }

    private void closeConversation() throws ConversationException {

    }
}
