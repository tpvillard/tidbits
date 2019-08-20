package com.biffbangpow.twitter;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class UserRepo {

    private final List<User> users = new ArrayList<>();

    public void add(User user) {
        users.add(user);
    }

    public void addFollower(User follower, User followed) {
        follower.follow(followed);
    }
}
