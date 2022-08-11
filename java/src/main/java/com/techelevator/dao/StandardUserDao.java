package com.techelevator.dao;

import com.techelevator.model.Album;

import javax.validation.Valid;
import java.util.List;

public interface StandardUserDao {
    Album getAlbum(int albumId);
    Album createAlbum(Album album);
    int findIdByUsername(String username);
    List<Album> showLibrary(int userId);
    void updateNotes (@Valid String album, int albumId, int userId);

}
