package main;

import main.Storage;
import model.Note;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
public class NoteController {

    @GetMapping("/notes/")
    public List<Note> pages() {
        return Storage.getAllNotes();
    }

    @PostMapping("/notes/")
    public List<Note> addNote(String name) {
        Note note = new Note(name);
        Storage.addNote(note);
        return Storage.getAllNotes();
    }


    @PutMapping("/notes/{id}")
    public Note putNote(@PathVariable int id, String newNote) {
        Storage.updateNote(id, newNote);
        return Storage.getNote(id);
    }
    @DeleteMapping("/notes/")
    public List<Note> deleteAll() {
        Storage.deleteAllNote();
        return Storage.getAllNotes();
    }

    @GetMapping("/notes/{id}")
    public Note indexPage(@PathVariable int id) {
        return Storage.getNote(id);
    }

    @DeleteMapping("/notes/{id}")
    public List<Note> deletePage(@PathVariable int id) {
        Storage.deleteOneNote(id);
        return Storage.getAllNotes();
    }

}
