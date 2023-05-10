package de.musiclibrary.musiclibrary.controller;

import de.musiclibrary.musiclibrary.entity.Track;
import de.musiclibrary.musiclibrary.service.TrackService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/tracks")
public class TrackController {

    private final TrackService trackService;

    public TrackController (TrackService trackService) {
        this.trackService = trackService;
    }

    @GetMapping("")
    public List<Track> getAllTracks() {
        return trackService.getAllTracks();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Track> getTrackById(@PathVariable Long id) {
        Track track = trackService.getTrackById(id);
        if(track == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(track, HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<Track> addTrack(@RequestBody Track track) {
        trackService.addTrack(track);
        return new ResponseEntity<>(track, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Track> updateTrack(@PathVariable Long id, @RequestBody Track track) {
        Track updatedTrack = trackService.updateTrack(id, track);
        if(updatedTrack == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(updatedTrack, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteTrack(@PathVariable Long id) {
        boolean deleted = trackService.deleteTrack(id);
        if(!deleted) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
