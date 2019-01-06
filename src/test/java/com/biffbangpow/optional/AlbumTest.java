package com.biffbangpow.optional;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.biffbangpow.optional.Track.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by tvillard on 06/01/2019.
 */
public class AlbumTest {


    private Album ceremony;

    @BeforeClass
    public void setup() {

        List<Track> tracks = new ArrayList<>();
        tracks.add(Track.newBuilder().withTitle("Ceremony").withDuration(180).build());
        tracks.add(Track.newBuilder().withTitle("Blue Monday").withDuration(240).build());

        Artist newOrder = new Artist("New Order");
        ceremony = Album.newBuilder().withArtist(newOrder).withTitle("Ceremony").withTracks(tracks).build();
    }

    @Test
    public void should_return_songs_greater_than_3_minutes_first() {

        List<Track> tracks = ceremony.getTracks().stream()
                .filter(track -> track.durationExceeds(180))
                .collect(Collectors.toList());
        Assert.assertEquals(tracks.size(), 1);
    }

    @Test
    public void should_return_songs_greater_than_3_minutes_second() {

        List<Track> tracks = ceremony.getTracks().stream()
                .filter(checkDurationExceeds(180))
                .collect(Collectors.toList());
        Assert.assertEquals(tracks.size(), 1);
    }

    @Test
    public void should_return_songs_greater_than_3_minutes_third() {

        List<Track> tracks = ceremony.getTracks().stream()
                .filter(Track::durationOver3Minutes)
                .collect(Collectors.toList());
        Assert.assertEquals(tracks.size(), 1);
    }

    private static boolean durationExceeds3Minutes(Track track) {
        return track.getDuration() > 180;
    }
}
