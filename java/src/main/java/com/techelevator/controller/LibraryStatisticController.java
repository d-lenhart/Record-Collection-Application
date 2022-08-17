package com.techelevator.controller;

import com.techelevator.dao.LibraryStatisticDao;
import com.techelevator.dao.StandardUserDao;
import com.techelevator.model.Statistics;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
/*
@RestController
@CrossOrigin
public class LibraryStatisticController {

    private LibraryStatisticDao libraryStatisticDao;

    public LibraryStatisticController(LibraryStatisticDao libraryStatisticDao) {
        this.libraryStatisticDao = libraryStatisticDao; }

    @RequestMapping(path = "/", method = RequestMethod.GET)
    public Statistics getTotalRecords(){
        Statistics obj2 =  libraryStatisticDao.listMostPopularArtist();
        return obj2;
    }

}
*/

