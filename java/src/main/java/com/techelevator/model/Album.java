package com.techelevator.model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public class Album {

    private int albumId;
    private int userId;
    private String title;
    private LocalDate releaseDate;
    private String artist;
    private int numberOfTracks;
    private LocalTime playTime;
    private List<Song> tracklist;
    private String genre;
    private String notes;

    public void setUserId(int userId) { this.userId = userId; }
    public int getUserId() { return userId; }
    public int getAlbumId() { return albumId; }
    public void setAlbumId(int albumId) { this.albumId = albumId; }
    public LocalDate getReleaseDate() { return releaseDate; }
    public void setReleaseDate(LocalDate releaseDate) { this.releaseDate = releaseDate; }
    public String getArtist() { return artist; }
    public void setArtist(String artist) { this.artist = artist; }
    public int getNumberOfTracks() { return numberOfTracks; }
    public void setNumberOfTracks(int numberOfTracks) { this.numberOfTracks = numberOfTracks; }
    public LocalTime getPlayTime() { return playTime; }
    public void setPlayTime(LocalTime playTime) { this.playTime = playTime; }
    public List<Song> getTracklist() { return tracklist; }
    public void setTracklist(List<Song> tracklist) { this.tracklist = tracklist; }
    public String getGenre() { return genre; }
    public void setGenre(String genre) { this.genre = genre; }
    public String getNotes() { return notes; }
    public void setNotes(String notes) { this.notes = notes; }
    public String getTitle() {return title;}
    public void setTitle(String title) {this.title = title;}
}
