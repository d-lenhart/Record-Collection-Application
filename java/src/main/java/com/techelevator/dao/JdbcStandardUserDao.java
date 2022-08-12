package com.techelevator.dao;

import com.techelevator.model.Album;
import com.techelevator.model.UserNotFoundException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;


@Component
public class JdbcStandardUserDao implements StandardUserDao{
    private final JdbcTemplate jdbcTemplate;
    public JdbcStandardUserDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public Album getAlbum(int albumId) {
        Album album = null;

        String sql = "SELECT * " +
                "FROM album_library " +
                "WHERE album_id = ? ;";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, albumId);

        if(results.next()) {
            album = mapRowToAlbum(results);
        }

        return album;
    }

    @Override
    public Album createAlbum(Album album) {
        String sql = "INSERT INTO album_library(user_id, release_date, artist, title, number_of_tracks, genre, notes, play_time) " +
                " VALUES (?, ?, ?, ?, ?, ?, ?, ? ) RETURNING album_id;";

        Integer newId = jdbcTemplate.queryForObject(sql, Integer.class, album.getUserId(), album.getReleaseDate(), album.getArtist(), album.getTitle(),
                album.getNumberOfTracks(), album.getGenre(), album.getNotes(), album.getPlayTime());


        return getAlbum(newId);
    }

    @Override
    public int findIdByUsername(String username) {
        if (username == null) throw new IllegalArgumentException("Username cannot be null");

        int userId;
        try {
            userId = jdbcTemplate.queryForObject("select user_id from users where username = ?", int.class, username);
        } catch (NullPointerException | EmptyResultDataAccessException e) {
            throw new UserNotFoundException();
        }

        return userId;
    }

    @Override
    public List<Album> showLibrary(int userId) {
        List<Album> library = new ArrayList<>();

        String sql = "SELECT * " +
                     "FROM album_library " +
                     "WHERE user_id = ?;";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, userId);

        while(results.next()) {
            library.add(mapRowToAlbum(results));
        }
        return library;
    }
    @Override
    public void updateNotes (String notes, int userId, int albumId){
        String sql = "UPDATE album_library " +
                "SET notes = ? " +
                "WHERE user_id = ? AND album_id = ? ;";
        jdbcTemplate.update(sql, notes, userId, albumId);
    }


    private Album mapRowToAlbum(SqlRowSet rowSet) {
        Album album = new Album();

        album.setAlbumId(rowSet.getInt("album_id"));
        album.setUserId(rowSet.getInt("user_id"));

        album.setArtist(rowSet.getString("artist"));
        album.setTitle(rowSet.getString("title"));
        if (rowSet.getDate("release_date") != null) {
            album.setReleaseDate(rowSet.getDate("release_date").toLocalDate());
        }
        if (rowSet.getInt("number_of_tracks") != 0) {
            album.setNumberOfTracks(rowSet.getInt("number_of_tracks"));
        }
        if (rowSet.getString("genre") != null) {
            album.setGenre(rowSet.getString("genre"));
        }
        if (rowSet.getString("notes") != null) {
            album.setNotes(rowSet.getString("notes"));
        }
        if (rowSet.getTime("play_time") != null) {
            album.setPlayTime(rowSet.getTime("play_time").toLocalTime());
        }

        return album;
    }



}
