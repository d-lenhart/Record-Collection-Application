package com.techelevator.controller;

import com.techelevator.dao.StandardCollectionDao;
import com.techelevator.dao.StandardUserDao;
import com.techelevator.model.Album;
import com.techelevator.model.Collection;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

import com.techelevator.controller.StandardUserController;

import javax.validation.Valid;

@RestController
@CrossOrigin
public class StandardCollectionController {

    private StandardCollectionDao standardCollectionDao;
    private StandardUserDao standardUserDao;

    public StandardCollectionController(StandardCollectionDao standardCollectionDao) {
        this.standardCollectionDao = standardCollectionDao;
    }

    @RequestMapping(path = "/collections/{userId}/{collectionId}", method = RequestMethod.GET)
    public Collection getCollection(@PathVariable int userId, @PathVariable int collectionId, Principal user) {

        String username = user.getName();
        if (userId == this.standardCollectionDao.findIdByUsername(username)) {
            return standardCollectionDao.getCollection(collectionId, userId);
        }
        return null;
    }
    @RequestMapping(path = "/collections/{userId}/", method = RequestMethod.GET)
    public List<Collection> getAllCollections(@PathVariable int userId, Principal user) {

        String username = user.getName();
        if (userId == this.standardCollectionDao.findIdByUsername(username)) {
            return standardCollectionDao.getAllCollections(userId);
        }
        return null;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(path = "/collections/{userId}", method = RequestMethod.POST)
    public Collection createCollection(@RequestBody Collection collection, @PathVariable int userId, Principal user) {

        String username = user.getName();
        if (userId == this.standardCollectionDao.findIdByUsername(username)) {
            return standardCollectionDao.createCollection(collection, userId);
        }
        return null;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(path = "/collections/{userId}/{collectionId}/{albumId}", method = RequestMethod.GET)
    public void addToCollection( @PathVariable int userId, @PathVariable int collectionId, @PathVariable int albumId, Principal user) {

        String username = user.getName();
        if (userId == this.standardCollectionDao.findIdByUsername(username)) {
            standardCollectionDao.addToCollection(albumId, collectionId);
        }

    }
    @RequestMapping(path = "/collections/{userId}/delete/{collectionId}/{albumId}", method = RequestMethod.DELETE)
    public void deleteAlbumFromCollection( @PathVariable int userId, @PathVariable int collectionId, @PathVariable int albumId, Principal user) {

        String username = user.getName();
        if (userId == this.standardCollectionDao.findIdByUsername(username)) {
            standardCollectionDao.deleteAlbumFromCollection(albumId, collectionId);
        }

    }


    @RequestMapping(path = "/collections/{userId}/delete/{collectionId}", method = RequestMethod.DELETE)
    public void deleteCollection(@Valid @PathVariable int userId, @Valid @PathVariable int collectionId, Principal user) {
        String username = user.getName();
        if (userId == this.standardCollectionDao.findIdByUsername(username)) {
            standardCollectionDao.deleteCollection(userId, collectionId);
        }

   /* @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(path = "/albums/{userId}", method = RequestMethod.POST)
    public Album addAlbum(@RequestBody Album album, @PathVariable int userId, Principal user) {

        String username = user.getName();
        if (userId == this.standardUserDao.findIdByUsername(username)) {
            return standardUserDao.createAlbum(album);
        }
        return null;
    }*/
    }
}

