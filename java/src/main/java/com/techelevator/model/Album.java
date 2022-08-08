package com.techelevator.model;

import java.time.LocalDate;

public class Album {

    private int albumId;
    private LocalDate releaseDate;
    private String artist;
    private int numberOfTracks;
    private int lengthInMinutes;
    private Song tracklist;
    private String genre;
    private String notes;

    public int getAlbumId() { return albumId; }
    public void setAlbumId(int albumId) { this.albumId = albumId; }
    public LocalDate getReleaseDate() { return releaseDate; }
    public void setReleaseDate(LocalDate releaseDate) { this.releaseDate = releaseDate; }
    public String getArtist() { return artist; }
    public void setArtist(String artist) { this.artist = artist; }
    public int getNumberOfTracks() { return numberOfTracks; }
    public void setNumberOfTracks(int numberOfTracks) { this.numberOfTracks = numberOfTracks; }
    public int getLengthInMinutes() { return lengthInMinutes; }
    public void setLengthInMinutes(int lengthInMinutes) { this.lengthInMinutes = lengthInMinutes; }
    public Song getTracklist() { return tracklist; }
    public void setTracklist(Song tracklist) { this.tracklist = tracklist; }
    public String getGenre() { return genre; }
    public void setGenre(String genre) { this.genre = genre; }
    public String getNotes() { return notes; }
    public void setNotes(String notes) { this.notes = notes; }
}
