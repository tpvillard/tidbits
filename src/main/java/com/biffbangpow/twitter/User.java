package com.biffbangpow.twitter;

import java.util.ArrayList;
import java.util.List;

public class User {

    private final String userName;
    private final List<User> followers = new ArrayList<>();

    public User(String userName) {
        this.userName = userName;
    }

    public String getUserName() {
        return userName;
    }

    public boolean isFollowedBy(User user) {
        return followers.contains(user);
    }

    public void addFollower(User user) {
        followers.add(user);
    }
}
