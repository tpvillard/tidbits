package com.biffbangpow.twitter;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by tvillard on 20/08/2019.
 */
public class TweetRepo {

    private final List<Tweet> tweets = new ArrayList<>();

    public List<Tweet> getFollowedUserTweets(User followed) {
        return tweets.stream().filter(tweet -> tweet.getUser().isFollowerOf(followed)).collect(Collectors.toList());
    }

    public List<Tweet> getOwnedTweets(User user) {
        return tweets.stream().filter(tweet -> tweet.getUser().equals(user)).collect(Collectors.toList());
    }

    public void add(Tweet tweet) {
        tweets.add(tweet);
    }
}
