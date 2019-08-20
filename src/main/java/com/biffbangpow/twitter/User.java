package com.biffbangpow.twitter;

import java.util.ArrayList;
import java.util.List;

public class User {

    private final String userName;
    private final List<User> followed = new ArrayList<>();

    public User(String userName) {
        this.userName = userName;
    }

    public String getUserName() {
        return userName;
    }

    public boolean isFollowerOf(User user) {
        return followed.contains(user);
    }

    public void follow(User user) {
        followed.add(user);
    }
}
