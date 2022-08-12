package com.techelevator.controller;

import com.techelevator.dao.StandardCollectionDao;
import com.techelevator.dao.StandardUserDao;
import com.techelevator.model.Album;
import com.techelevator.model.Collection;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import com.techelevator.controller.StandardUserController;

@RestController
@CrossOrigin
public class StandardCollectionController {

    private StandardCollectionDao standardCollectionDao;
    private StandardUserDao standardUserDao;

    public StandardCollectionController(StandardCollectionDao standardCollectionDao) {
        this.standardCollectionDao = standardCollectionDao; }

    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(path = "/collections/{userId}", method = RequestMethod.POST)
    public Collection addCollection(@RequestBody Collection collection, @PathVariable int userId, Principal user) {

        String username = user.getName();
        if (userId == this.standardCollectionDao.findIdByUsername(username)) {
            return standardCollectionDao.createCollection(collection);
        }
        return null;
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
