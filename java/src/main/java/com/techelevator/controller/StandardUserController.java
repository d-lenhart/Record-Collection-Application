package com.techelevator.controller;

import com.techelevator.dao.StandardCollectionDao;
import com.techelevator.dao.StandardUserDao;
import com.techelevator.model.Album;

import org.springframework.http.HttpStatus;

import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;
import java.security.Principal;
import java.util.List;

@RestController
@CrossOrigin
public class StandardUserController {
    private static final String API_BASE_URL = "http://localhost:9000";


    private StandardUserDao standardUserDao;

    public StandardUserController(StandardUserDao standardUserDao) { this.standardUserDao = standardUserDao; }

//    @RequestMapping(path = "/albums/{albumId}", method = RequestMethod.GET)
//    public Album getAlbumByUserId(@RequestBody @PathVariable int albumId) {
//
//        return standardUserDao.getAlbum(albumId);
//    }

    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(path = "/albums/{userId}", method = RequestMethod.POST)
    public Album addAlbum(@RequestBody Album album, @PathVariable int userId, Principal user) {

        String username = user.getName();
        if (userId == this.standardUserDao.findIdByUsername(username)) {
            return standardUserDao.createAlbum(album);
        }
        return null;
    }

    @RequestMapping(path = "/albums/{userId}", method = RequestMethod.GET)
    public List<Album> showLibrary(@PathVariable int userId, Principal user) {
        String username = user.getName();
        if (userId == this.standardUserDao.findIdByUsername(username)) {
            return standardUserDao.showLibrary(userId);
        }
        return null;
    }


    @RequestMapping(path = "/albums/{userId}/{albumId}", method = RequestMethod.PUT)
    public void updateNotes(@RequestBody String notes, @PathVariable int userId, @PathVariable int albumId, Principal user) {
        String username = user.getName();
        if (userId == this.standardUserDao.findIdByUsername(username)) {
            standardUserDao.updateNotes(notes, userId, albumId);
        }
    }

    @RequestMapping(path = "/albums/{userId}/delete/{albumId}", method = RequestMethod.DELETE)
    public void deleteAlbum(@Valid  @PathVariable int userId, @Valid @PathVariable int albumId, Principal user) {
        String username = user.getName();
        if (userId == this.standardUserDao.findIdByUsername(username)) {
            standardUserDao.deleteAlbum(userId, albumId);
        }
    }


}

