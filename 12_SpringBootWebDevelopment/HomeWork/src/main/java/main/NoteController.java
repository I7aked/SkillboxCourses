package main;

import main.Storage;
import model.Note;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping(value = "/notes/")
public class NoteController {

    @GetMapping("")
    public List<Note> pages() {
        return Storage.getAllNotes();
    }

    @PostMapping("")
    public ResponseEntity addNote(@RequestBody String str) {
        Note note = new Note(str);
        Storage.addNote(note);
        return ResponseEntity.ok(HttpStatus.OK);
    }
//    public List<Note> addNote(String name) {
//        Note note = new Note(name);
//        Storage.addNote(note);
//        return Storage.getAllNotes();
//    }


    @PutMapping("{id}")
    public ResponseEntity putNote(@RequestBody @PathVariable int id, String str) {
        Storage.updateNote(id, str);
        return ResponseEntity.ok(HttpStatus.OK);
    }
//    public Note putNote(@PathVariable int id, String newNote) {
//        Storage.updateNote(id, newNote);
//        return Storage.getNote(id);
//    }

    @DeleteMapping("")
    public List<Note> deleteAll() {
        Storage.deleteAllNote();
        return Storage.getAllNotes();
    }

    @GetMapping("{id}")
    public Note indexPage(@PathVariable int id) {
        return Storage.getNote(id);
    }

    @DeleteMapping("{id}")
    public List<Note> deletePage(@PathVariable int id) {
        Storage.deleteOneNote(id);
        return Storage.getAllNotes();
    }

}
