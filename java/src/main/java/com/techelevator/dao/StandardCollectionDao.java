package com.techelevator.dao;

import com.techelevator.model.Album;
import com.techelevator.model.Collection;

import java.util.List;

public interface StandardCollectionDao {

    Collection getCollection(int collectionId, int userId);

    List<Collection> getAllCollections(int userId);

    List<Collection> getAllPublicCollections();

    void addToCollection(int albumId, int collectionId);

    Collection createCollection(Collection collection, int userId);
    int findIdByUsername(String username);
    void deleteCollection(int userId, int collectionId);

    void deleteAlbumFromCollection(int albumId, int collectionId);
}
