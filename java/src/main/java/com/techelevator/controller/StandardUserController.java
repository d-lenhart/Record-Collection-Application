package com.techelevator.controller;

import com.techelevator.dao.StandardUserDao;
import com.techelevator.model.Album;

import org.springframework.http.HttpStatus;

import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;
import java.security.Principal;

@RestController

public class StandardUserController {
    private static final String API_BASE_URL = "http://localhost:9000";


    private StandardUserDao standardUserDao;


    public StandardUserController(StandardUserDao standardUserDao) {
        this.standardUserDao = standardUserDao;

    }

    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(path = "/albums/{userId}", method = RequestMethod.POST)
    public Album addAlbum(@Valid @RequestBody Album album, @PathVariable int userId, Principal user) {

        String username = user.getName();
        userId = this.standardUserDao.findIdByUsername(username);

        return standardUserDao.createAlbum(album);




    }




}

