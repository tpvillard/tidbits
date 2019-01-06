package com.biffbangpow.optional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Album {

    private final String name;
    private final List<Artist> artists;
    private final List<Track> tracks;

    private Album(AlbumBuilder builder) {
        this.name = builder.name;
        this.artists = builder.artists;
        this.tracks = builder.tracks;
    }

    public String getName() {
        return name;
    }

    public List<Artist> getArtists() {
        return artists;
    }

    public List<Track> getTracks() {
        return tracks;
    }

    public static class AlbumBuilder {
        private String name;
        private List<Artist> artists;
        private List<Track> tracks;

        public AlbumBuilder withName(String name) {
            this.name = name;
            return this;
        }

        public AlbumBuilder withArtists(List<Artist> artists) {
            this.artists = artists;
            return this;
        }

        public AlbumBuilder withTracks(List<Track> tracks) {
            this.tracks = tracks;
            return this;
        }

        public Album build() {

            name = Optional.ofNullable(name).orElse("");
            artists = Optional.ofNullable(artists).orElse(new ArrayList<>());
            tracks = Optional.ofNullable(tracks).orElse(new ArrayList<>());
            return new Album(this);
        }
    }
}
