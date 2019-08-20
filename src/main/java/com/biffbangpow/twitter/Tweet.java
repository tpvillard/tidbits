package com.biffbangpow.twitter;

/**
 * Created by tvillard on 20/08/2019.
 */
public class Tweet {

    private final User user;
    private final String message;

    public Tweet(User user, String message) {
        this.user = user;
        this.message = message;
    }

    public User getUser() {
        return user;
    }

    public String getMessage() {
        return message;
    }
}
