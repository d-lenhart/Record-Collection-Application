package com.techelevator.model;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public class Statistics {

    private String genre;
    private int genreAmount;
    private String artist;
    private int artistAmount;
    private String title;
    private LocalDate releaseDate;

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getGenreAmount() {
        return genreAmount;
    }

    public void setGenreAmount(int genreAmount) {
        this.genreAmount = genreAmount;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public int getArtistAmount() {
        return artistAmount;
    }

    public void setArtistAmount(int artistAmount) {
        this.artistAmount = artistAmount;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }
}
