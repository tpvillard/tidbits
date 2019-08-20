package com.biffbangpow.twitter;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TweetRepo {

    private final List<Tweet> tweets = new ArrayList<>();

    public List<Tweet> getFollowedUsersTweets(User follower) {
        return tweets.stream().filter(tweet -> tweet.getUser().isFollowedBy(follower)).collect(Collectors.toList());
    }

    public List<Tweet> getTweetsFrom(User user) {
        return tweets.stream().filter(tweet -> tweet.getUser().equals(user)).collect(Collectors.toList());
    }

    public void add(Tweet tweet) {
        tweets.add(tweet);
    }
}
