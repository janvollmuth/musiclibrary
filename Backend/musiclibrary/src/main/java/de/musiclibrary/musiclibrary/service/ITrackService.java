package de.musiclibrary.musiclibrary.service;

import de.musiclibrary.musiclibrary.entity.Track;
import org.springframework.stereotype.Service;

import java.util.List;

public interface ITrackService {

    List<Track> getAllTracks();

    Track getTrackById(Long id);

    void addTrack(Track track);

    Track updateTrack(Long id, Track track);

    boolean deleteTrack(Long id);
}
