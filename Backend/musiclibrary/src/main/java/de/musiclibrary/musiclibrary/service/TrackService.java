package de.musiclibrary.musiclibrary.service;

import de.musiclibrary.musiclibrary.entity.Track;
import de.musiclibrary.musiclibrary.repository.ITrackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrackService implements ITrackService{

    @Autowired
    private ITrackRepository trackRepository;


    @Override
    public List<Track> getAllTracks() {
        return trackRepository.findAll();
    }

    @Override
    public Track getTrackById(Long id) {
        return trackRepository.findById(id).orElse(null);
    }

    @Override
    public void addTrack(Track track) {
        trackRepository.save(track);
    }

    @Override
    public Track updateTrack(Long id, Track track) {
        Track existingTrack = trackRepository.findById(id).orElse(null);
        if(existingTrack == null) {
            return null;
        }
        return trackRepository.save(track);
    }

    @Override
    public boolean deleteTrack(Long id) {
        Track existingTrack = trackRepository.findById(id).orElse(null);
        if(existingTrack == null) {
            return false;
        }
        trackRepository.delete(existingTrack);
        return true;
    }
}
