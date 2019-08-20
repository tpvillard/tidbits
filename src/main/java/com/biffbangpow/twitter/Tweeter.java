package com.biffbangpow.twitter;

public class Tweeter {

    private final TweetRepo tweets = new TweetRepo();
    private final UserRepo userRepo = new UserRepo();

    public void post(Tweet tweet) {
        tweets.add(tweet);
    }

    public void register(User user) {
        userRepo.add(user);
    }

    public void addFollower(User follower, User followed) {
        followed.addFollower(follower);
    }
}
