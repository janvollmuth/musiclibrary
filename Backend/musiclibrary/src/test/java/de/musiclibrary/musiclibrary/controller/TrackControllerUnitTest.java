package de.musiclibrary.musiclibrary.controller;

import de.musiclibrary.musiclibrary.entity.Track;
import de.musiclibrary.musiclibrary.service.TrackService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;

import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class TrackControllerUnitTest {

    private final Track testTrack1 = new Track(1L, "Title1", "Artist1", "Genre1", "100");
    private final Track testTrack2 = new Track(2L, "TTitle2", "Artist2", "Genre2", "200");
    private final Track testTrack3 = new Track(3L, "Title3", "Artist3", "Genre3", "300");

    @Test
    void getAllTracks() {
        List<Track> tracks = new ArrayList<>();
        tracks.add(testTrack1);
        tracks.add(testTrack2);


        TrackService trackService = Mockito.mock(TrackService.class);
        when(trackService.getAllTracks()).thenReturn(tracks);

        TrackController trackController = new TrackController(trackService);

        List<Track> response = trackController.getAllTracks();

        assertEquals("Title1",response.get(0).getTitle());
    }

    @Test
    void getTrackById() {
        TrackService trackService = Mockito.mock(TrackService.class);
        when(trackService.getTrackById(1L)).thenReturn(testTrack1);
        TrackController trackController = new TrackController(trackService);
        Track response = trackController.getTrackById(1L).getBody();
        assertEquals("Title1",response.getTitle());
    }

    @Test
    void addTrack() {
        TrackService trackService = Mockito.mock(TrackService.class);
        trackService.addTrack(testTrack1);
        verify(trackService).addTrack(testTrack1);
    }

    @Test
    void updateTrack() {
        TrackService trackService = Mockito.mock(TrackService.class);
        trackService.updateTrack(1L, testTrack1);
        verify(trackService).updateTrack(1L, testTrack1);
    }

    @Test
    void deleteTrack() {
        TrackService trackService = Mockito.mock(TrackService.class);
        when(trackService.deleteTrack(1L)).thenReturn(true);
        TrackController trackController = new TrackController(trackService);
        HttpStatusCode response = trackController.deleteTrack(1L).getStatusCode();
        assertEquals(HttpStatus.NO_CONTENT, response);
        verify(trackService).deleteTrack(1L);
    }
}