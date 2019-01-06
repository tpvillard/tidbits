package com.biffbangpow.optional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Album {

    private final String title;
    private final Artist artist;
    private final List<Track> tracks;

    private Album(AlbumBuilder builder) {
        this.title = builder.title;
        this.artist = builder.artist;
        this.tracks = builder.tracks;
    }

    public String getTitle() {
        return title;
    }

    public Artist getArtist() {
        return artist;
    }

    public List<Track> getTracks() {
        return tracks;
    }

    public static AlbumBuilder newBuilder() {
        return new AlbumBuilder();
    }

    public static class AlbumBuilder {
        private String title;
        private Artist artist;
        private List<Track> tracks;

        public AlbumBuilder withTitle(String name) {
            this.title = name;
            return this;
        }

        public AlbumBuilder withArtist(Artist artist) {
            this.artist = artist;
            return this;
        }

        public AlbumBuilder withTracks(List<Track> tracks) {
            this.tracks = tracks;
            return this;
        }

        public Album build() {

            title = Optional.ofNullable(title).orElse("");
            artist = Optional.ofNullable(artist).orElse(new Artist(""));
            tracks = Optional.ofNullable(tracks).orElse(new ArrayList<>());
            return new Album(this);
        }
    }
}
