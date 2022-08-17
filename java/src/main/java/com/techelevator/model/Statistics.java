package com.techelevator.model;

import java.util.List;
import java.util.Map;

public class Statistics {

    private int numberOfRecords = 0;
    private Map<String, Integer> genreList;
    private Map<String, Integer> artistList;
    private Album mostRecentAlbum;
    private int numberOfCollections;
    private Map <String, Integer> collectionList;

    public int getNumberOfRecords() {
        return numberOfRecords;
    }

    public void setNumberOfRecords(int numberOfRecords) {
        this.numberOfRecords = numberOfRecords;
    }

    public Map<String, Integer> getGenreList() {
        return genreList;
    }

    public void setGenreList(Map<String, Integer> genreList) {
        this.genreList = genreList;
    }

    public Map<String, Integer> getArtistList() {
        return artistList;
    }

    public void setArtistList(Map<String, Integer> artistList) {
        this.artistList = artistList;
    }

    public Album getMostRecentAlbum() {
        return mostRecentAlbum;
    }

    public void setMostRecentAlbum(Album mostRecentAlbum) {
        this.mostRecentAlbum = mostRecentAlbum;
    }

    public int getNumberOfCollections() {
        return numberOfCollections;
    }

    public void setNumberOfCollections(int numberOfCollections) {
        this.numberOfCollections = numberOfCollections;
    }

    public Map<String, Integer> getCollectionList() {
        return collectionList;
    }

    public void setCollectionList(Map<String, Integer> collectionList) {
        this.collectionList = collectionList;
    }
}
