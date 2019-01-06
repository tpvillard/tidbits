package com.biffbangpow.optional;

import java.util.Optional;
import java.util.function.Predicate;

public class Track {

    private final String title;
    private final int duration;

    private Track(TrackBuilder builder) {
        this.title = builder.title;
        this.duration = builder.duration;
    }

    public String getTitle() {
        return title;
    }

    public int getDuration() {
        return duration;
    }

    public static TrackBuilder newBuilder() {
        return new TrackBuilder();
    }

    boolean durationExceeds(int duration) {
        return this.duration > duration;
    }

    /**
     * Check whether the track duration exceeds 3 minutes.
     *
     * This form is suitable for  a predicate method reference in a stream filter
     *
     * @return true when song duration exceeds 3 minutes
     */
    boolean durationOver3Minutes() {
        return this.duration > 180;
    }

    public static Predicate<Track> checkDurationExceeds(int duration) {
        return track -> track.getDuration() > duration;
    }

    public static class TrackBuilder {

        private String title;
        private int duration;

        public TrackBuilder withTitle(String title) {
            this.title = title;
            return this;
        }

        public TrackBuilder withDuration(int duration) {
            this.duration = duration;
            return this;
        }

        public Track build() {
            title = Optional.ofNullable(title).orElse("");
            return new Track(this);
        }
    }
}
