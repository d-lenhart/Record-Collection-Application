package com.techelevator.dao;

import com.techelevator.model.Statistics;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;
/*
@Component
public class JdbcLibraryStatisticDao implements LibraryStatisticDao {

    private Statistics statistics;

    private final JdbcTemplate jdbcTemplate;
    public JdbcLibraryStatisticDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public Statistics totalRecords (){
        Statistics albumsCount;

        String sql = "SELECT COUNT(*) " +
                "FROM album_library;";

        albumsCount = jdbcTemplate.queryForObject(sql,Statistics.class);

        return albumsCount;
    }

    @Override
    public Statistics listMostPopularGenres() {
        Statistics genreList;

        String sql = "SELECT genre, COUNT(genre) AS genre_amount " +
                "FROM album_library " +
                "GROUP BY genre " +
                "ORDER BY genre_amount DESC " +
                "LIMIT 5;";

        genreList = jdbcTemplate.queryForObject(sql, Statistics.class);

        return genreList;
    }

    @Override
    public Statistics listMostPopularArtist() {
        Statistics list = statistics.getArtistList();

        String sql = "SELECT artist, COUNT(artist) AS artist_amount " +
                "FROM album_library " +
                "GROUP BY artist " +
                "ORDER BY artist_amount DESC " +
                "LIMIT 5;";

        list = jdbcTemplate.queryForObject(sql, Statistics.class);

        return list;
    }

    public Statistics mostRecentAlbumAdded() {
        Statistics album = statistics.getMostRecentAlbum();

        String sql = "SELECT title, artist, release_date " +
                "FROM album_library " +
                "GROUP BY release_date, artist, title " +
                "ORDER BY release_date DESC " +
                "LIMIT 1;";

        album = jdbcTemplate.queryForObject(sql, Statistics.class);

        return album;
    }

    @Override
    public Statistics totalCollections(){
        Statistics collectionsCount;

        String sql = "SELECT COUNT(*) " +
                "FROM collections;";

        collectionsCount = jdbcTemplate.queryForObject(sql,Statistics.class);

        return collectionsCount;
    }

    @Override
    public Statistics listBiggestCollections() {
        Statistics collectionList;

        String sql = "SELECT title, COUNT(album_id) " +
                "FROM collection " +
                "JOIN album_collection ON collection.collection_id = album_collection.collection_id " +
                "GROUP BY album_id, title " +
                "ORDER BY album_id DESC " +
                "LIMIT 5;";

        collectionList = jdbcTemplate.queryForObject(sql, Statistics.class);

        return collectionList;
    }




}
*/
