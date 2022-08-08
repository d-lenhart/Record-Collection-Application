package com.techelevator.dao;

import com.techelevator.model.Album;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import javax.sql.DataSource;

public class JdbcStandardUserDao implements StandardUserDao{
    private final JdbcTemplate jdbcTemplate;
    public JdbcStandardUserDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public Album getAlbum(int albumId) {
        Album album = null;

        String sql = "SELECT columns " +
                "FROM album " +
                "WHERE album_id = ? ;";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, albumId);

        if(results.next()) {
            album = mapRowToAlbum(results);
        }

        return album;
    }

    @Override
    public Album createAlbum(Album album) {
        String sql = "INSERT INTO album(artist, title, genre, play_time, notes, release_date, track_list, number_of_tracks) " +
                " VALUES (?, ?, ?, ?, ?, ?, ?, ? ) RETURNING album_id;";

        Integer newId = jdbcTemplate.queryForObject(sql, Integer.class, album.getArtist(), album.getTitle(), album.getGenre(),
                album.getPlayTime(), album.getNotes(), album.getReleaseDate(), album.getTracklist(), album.getNumberOfTracks());

        return album;
    }

    private Album mapRowToAlbum(SqlRowSet rowSet) {
        Album album = new Album();

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
