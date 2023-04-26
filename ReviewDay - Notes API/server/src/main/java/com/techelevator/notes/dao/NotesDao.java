package com.techelevator.notes.dao;

import com.techelevator.notes.model.Note;

public interface NotesDao {

    //create
    public Note createNote(Note note);

    //read
    public Note getNote(int id);

    //update
    public Note updateNote(Note note);

    //delete
    public void deleteNote(int id);
}
