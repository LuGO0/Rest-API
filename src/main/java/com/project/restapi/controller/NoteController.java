package com.project.restapi.controller;

import com.project.restapi.entities.Note;
import com.project.restapi.services.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/notes")
public class NoteController {

    @Autowired
    private NoteService service;

    @PostMapping("")
    public Note saveNote(@RequestBody Note note) {
        return service.saveNote(note);
    }

    @PutMapping("/{id}")
    public Note updateNote(@RequestBody Note note,
                                 @PathVariable("id") Long id) {
        return service.updateNote(note, id);
    }

    @GetMapping("")
    public List<Note> getNotes() {
        return service.getNotes();
    }

    @GetMapping("/{id}")
    public Note getNote(@PathVariable("id") Long id) {
        return service.getNoteById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteNote(@PathVariable("id") Long id) {
        service.deleteNote(id);
    }

}
