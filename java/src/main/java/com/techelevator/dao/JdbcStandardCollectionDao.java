package com.techelevator.dao;

import com.techelevator.model.Album;
import com.techelevator.model.Collection;
import com.techelevator.model.UserNotFoundException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.List;

@Component
public class JdbcStandardCollectionDao implements StandardCollectionDao {

    private final JdbcTemplate jdbcTemplate;
    public JdbcStandardCollectionDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }


    @Override
    public Collection getCollection(int collectionId, int userId) {
        Collection collection = null;

        String sql = "SELECT * " +
                "FROM collection " +
                "WHERE collection_id = ? AND user_id = ? ;";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, collectionId, userId);

        if(results.next()) {
            collection = mapRowToCollection(results);
        }

        return collection;
    }

    @Override
    public Collection createCollection(Collection collection, int userId) {

        String sql = "INSERT INTO collection(user_id, title, is_public, notes) " +
                " VALUES (?, ?, ?, ?) " +
                " RETURNING collection_id;";

        Integer newId = jdbcTemplate.queryForObject(sql, Integer.class, userId, collection.getTitle(), collection.isPublic(),
                collection.getNotes());


        return getCollection(newId, userId);

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

    private Collection mapRowToCollection(SqlRowSet rowSet) {
        Collection collection = new Collection();

        collection.setCollectionId(rowSet.getInt("collection_id"));
        collection.setTitle(rowSet.getString("title"));
        collection.setPublic(rowSet.getBoolean("is_public"));
        if (rowSet.getString("notes") != null) {
            collection.setNotes(rowSet.getString("notes"));
        }

        return collection;
    }
}
