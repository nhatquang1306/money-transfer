package com.techelevator.notes.controller;

import com.techelevator.notes.dao.JdbcNoteDao;
import com.techelevator.notes.model.Note;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

@Component
@RestController
@PreAuthorize("isAuthenticated()")
public class NoteController {
    @Autowired
    JdbcNoteDao notesDao;


    // create

    @RequestMapping(path="/notes", method = RequestMethod.POST)
    public Note createNote(@RequestBody Note note){
        return notesDao.createNote(note);
    }


    // read
    @RequestMapping(path = "/notes/{id}", method = RequestMethod.GET)
    public Note getNoteById(@PathVariable int id){
        return notesDao.getNote(id);
    }


    // update
    @RequestMapping(path = "/notes/{id}", method = RequestMethod.PUT)
    public Note updateNote(@PathVariable int id, @RequestBody Note note){
        if(id == note.getId()){
            Note updatedNote = notesDao.updateNote(note);
            return updatedNote;
        }
        return null;
    }

    // delete
    @RequestMapping(path= "/notes/{id}", method = RequestMethod.DELETE)
    public void deleteNote(@PathVariable int id){
        notesDao.deleteNote(id);
    }


}