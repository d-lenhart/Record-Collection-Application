package com.techelevator.dao;

import com.techelevator.model.Statistics;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcLibraryStatisticDao implements LibraryStatisticDao {

    private Statistics statistics;

    private final JdbcTemplate jdbcTemplate;
    public JdbcLibraryStatisticDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public Statistics totalRecords(){
        Statistics albumsCount;

        String sql = "SELECT COUNT(*) " +
                "FROM album_library;";

        albumsCount = jdbcTemplate.queryForObject(sql,Statistics.class);

        return albumsCount;
    }
/*
    @Override
    public Statistics listMostPopularGenres() {
        Statistics statistics = new Statistics();

        String sql = "SELECT genre, COUNT(genre) AS genre_amount " +
                "FROM album_library " +
                "GROUP BY genre " +
                "ORDER BY genre_amount DESC " +
                "LIMIT 5;";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);

        if (results.next()) {
            statistics = mapRowToStatistics(results);
        }

        return statistics;
    }
*/
   @Override
    public Statistics listMostPopularArtists() {
        Statistics statistics = new Statistics();

        String sql = "SELECT artist, COUNT(artist) AS artist_amount " +
                "FROM album_library " +
                "GROUP BY artist " +
                "ORDER BY artist_amount DESC " +
                "LIMIT 5;";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);

        if (results.next()) {
            statistics = mapRowToStatistics(results);
        }

        return statistics;
    }
    /*
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
    */


    private Statistics mapRowToStatistics(SqlRowSet rowSet) {
        Statistics statistics = new Statistics();

        if (rowSet.getString("genre") != null) {
            statistics.setGenre(rowSet.getString("genre"));
        }
        if (rowSet.getInt("genre_amount") != 0) {
            statistics.setGenreAmount(rowSet.getInt("genre_amount"));
        }
        if (rowSet.getString("artist") != null) {
            statistics.setArtist(rowSet.getString("artist"));
        }
        if (rowSet.getInt("artist_amount") != 0) {
            statistics.setArtistAmount(rowSet.getInt("artist_amount"));
        }
        if (rowSet.getString("title") != null) {
            statistics.setTitle(rowSet.getString("title"));
        }
        if (rowSet.getDate("release_date") != null) {
            statistics.setReleaseDate(rowSet.getDate("release_date").toLocalDate());
        }
        return statistics;
    }




}

