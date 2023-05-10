package de.musiclibrary.musiclibrary.repository;

import de.musiclibrary.musiclibrary.entity.Track;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ITrackRepository extends JpaRepository<Track, Long> {
}
