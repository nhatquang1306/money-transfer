package com.techelevator.notes.dao;

import com.techelevator.notes.model.Note;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

@Component
public class JdbcNoteDao implements NoteDao {

    @Autowired
    JdbcTemplate jdbcTemplate;


    @Override
    public Note createNote(Note note) {
        String sql  = "INSERT INTO note (user_id, created_date, todo_date, message) VALUES (?,?,?,?) RETURNING note_id;";
        int newNoteId = jdbcTemplate.queryForObject(sql, int.class, note.getUserId(), note.getCreatedDate(), note.getTodoDate(), note.getMessage());

        return getNote(newNoteId);
    }

    @Override
    public Note getNote(int id) {
        String sql = "SELECT note_id, user_id, message, todo_date, created_date FROM note WHERE note_id = ?;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, id);
        if(results.next()) {
            return mapRowToNote(results);
        }
        return null;
    }

    @Override
    public Note updateNote(Note note) {
        String sql = "UPDATE note SET user_id = ?, created_date = ?, todo_date = ?, message = ? WHERE note_id = ? RETURNING note_id;";
        int newNoteId = jdbcTemplate.queryForObject(sql, int.class, note.getUserId(), note.getCreatedDate(), note.getTodoDate(), note.getMessage(), note.getId());
        return getNote(newNoteId);
    }

    @Override
    public void deleteNote(int id) {
        String sql = "DELETE FROM note WHERE note_id = ?;";
        jdbcTemplate.update(sql, id);
    }

    private Note mapRowToNote(SqlRowSet rs){
        Note note = new Note();

        note.setId(rs.getInt("note_id"));
        note.setUserId(rs.getInt("user_id"));
        note.setMessage(rs.getString("message"));
        if(rs.getDate("created_date") != null){
            note.setCreatedDate(rs.getDate("created_date").toLocalDate());
        }
        if(rs.getDate("todo_date") != null){
            note.setTodoDate(rs.getDate("todo_date").toLocalDate());
        }

        return note;

    }
}
