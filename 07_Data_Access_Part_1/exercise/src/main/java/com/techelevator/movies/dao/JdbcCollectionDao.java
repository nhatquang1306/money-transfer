package com.techelevator.movies.dao;

import com.techelevator.movies.model.Collection;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

public class JdbcCollectionDao implements CollectionDao{

    private final JdbcTemplate jdbcTemplate;

    public JdbcCollectionDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public List<Collection> getCollections() {
        List<Collection> collectionList = new ArrayList<>();
        String sql = "Select * From collection;";
        SqlRowSet result = jdbcTemplate.queryForRowSet(sql);
        while(result.next()) {
            Collection collection = new Collection();
            collection.setId(result.getInt("collection_id"));
            collection.setName(result.getString("collection_name"));
            collectionList.add(collection);
        }
        return collectionList;
    }

    @Override
    public Collection getCollectionById(int id) {
        Collection collection = new Collection();
        String sql = "Select * From collection WHERE collection_id = ?;";
        SqlRowSet result = jdbcTemplate.queryForRowSet(sql, id);
        if (result.next()) {
            collection.setId(result.getInt("collection_id"));
            collection.setName(result.getString("collection_name"));
        } else {
            return null;
        }
        return collection;
    }

    @Override
    public List<Collection> getCollectionsByName(String name, boolean useWildCard) {
        List<Collection> collectionList = new ArrayList<>();
        String sql = "Select * From collection WHERE collection_name ILIKE ?;";
        if (useWildCard){
            name= "%" + name + "%";
        }
        SqlRowSet result = jdbcTemplate.queryForRowSet(sql, name);
        while(result.next()) {
            Collection collection = new Collection();
            collection.setId(result.getInt("collection_id"));
            collection.setName(result.getString("collection_name"));
            collectionList.add(collection);
        }
        return collectionList;
    }
}
