package de.musiclibrary.musiclibrary.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import de.musiclibrary.musiclibrary.entity.Track;
import de.musiclibrary.musiclibrary.service.TrackService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest
class TrackControllerIntegrationTest {

    private final Track testTrack1 = new Track(1L, "Title1", "Artist1", "Genre1", "100");
    private final Track testTrack2 = new Track(2L, "Title2", "Artist2", "Genre2", "200");
    private final Track testTrack3 = new Track(3L, "Title3", "Artist3", "Genre3", "300");


    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private TrackService trackService;

    @Test
    void getAllTracks() throws Exception {

        List<Track> tracks = new ArrayList<>();
        tracks.add(testTrack1);
        tracks.add(testTrack2);
        tracks.add(testTrack3);

        when(trackService.getAllTracks()).thenReturn(tracks);

        mockMvc.perform(get("/tracks"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(3)));
        verify(trackService).getAllTracks();
    }

    @Test
    void getTrackById() throws Exception {
        when(trackService
                .getTrackById(1L))
                .thenReturn(testTrack1);
        mockMvc.perform(get("/tracks/1"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.title").value("Title1"));
        verify(trackService).getTrackById(1L);
    }

    @Test
    void addTrack() throws Exception {

        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(testTrack1);

        trackService.addTrack(testTrack1);
        mockMvc.perform(post("/tracks")
                        .content(json)
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isCreated());
        verify(trackService).addTrack(testTrack1);
    }

    @Test
    void updateTrack() throws Exception {
        /*ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(testTrack1);

        String url = "/tracks/" + testTrack1.getId();

        when(trackService.updateTrack(1L, testTrack1)).thenReturn()

        trackService.updateTrack(1L, testTrack1);
        mockMvc.perform(put(url)
                        .content(json)
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isCreated());
        verify(trackService).updateTrack(1L, testTrack1);*/
    }

    @Test
    void deleteTrack() {
    }
}