package de.musiclibrary.musiclibrary.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Track {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String artist;
    private String genre;
    private String bpm;

    public Track() {
    }

    public Track(Long id, String title, String artist, String genre, String bpm) {
        this.id = id;
        this.title = title;
        this.artist = artist;
        this.genre = genre;
        this.bpm = bpm;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getBpm() {
        return bpm;
    }

    public void setBpm(String bpm) {
        this.bpm = bpm;
    }
}
