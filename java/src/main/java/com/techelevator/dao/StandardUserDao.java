package com.techelevator.dao;

import com.techelevator.model.Album;

import java.util.List;

public interface StandardUserDao {
    Album getAlbum(int albumId);
    Album createAlbum(Album album);
    int findIdByUsername(String username);
    List<Album> showLibrary(int userId);
    void updateNotes (Album album, int albumId, int userId);

}
