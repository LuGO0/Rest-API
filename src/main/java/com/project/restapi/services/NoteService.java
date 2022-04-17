package com.project.restapi.services;

import com.project.restapi.entities.Note;
import com.project.restapi.repository.NotesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.OptimisticLockException;
import java.util.List;

// This represents by business logic means I do every custom stuff here.
@Service
public class NoteService {

    @Autowired
    private NotesRepository repository;

    public Note saveNote(Note note) {
        return repository.save(note);
    }

    public java.util.List<Note> saveNotes(List<Note> notes) {
        return repository.save(notes);
    }

    public List<Note> getNotes(){
        return repository.findAll();
    }

    public Note getNoteById(Long id) {
        return repository.getOne(id);
    }

    // Optimistic Locking Scheme, will not use Transactional as reads way more than writes.
    public Note updateNote(Note note) {
        Note current = repository.getOne(note.getId());
        current.setTitle(note.getTitle());
        current.setDetail(note.getDetail());
        // This already has the OptimisticLockException handled inside the merge method.
        return repository.save(current);
    }

    public void deleteNote(Long id) {
        repository.delete(id);
    }
}
