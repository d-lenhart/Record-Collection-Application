package com.techelevator.dao;

import com.techelevator.model.Statistics;

import java.util.List;

public interface LibraryStatisticDao {
    Statistics totalRecords();
//    Statistics listMostPopularGenres();
    Statistics listMostPopularArtists();

}
