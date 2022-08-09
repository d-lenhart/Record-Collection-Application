package com.techelevator.dao;

import com.techelevator.model.Album;

public interface StandardUserDao {
    Album getAlbum(int albumId);
    Album createAlbum(Album album);
    int findIdByUsername(String username);

}
