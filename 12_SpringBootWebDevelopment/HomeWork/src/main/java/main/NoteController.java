package main;

import main.Storage;
import model.Note;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
public class NoteController
{
    @GetMapping("/notes/")
    public List<Note> pages()
    {
        return Storage.getAllNotes();
    }

    @PostMapping("/notes/")
    public List<Note> addNote(String name)
    {
        Note note = new Note (name);
        Storage.addNote(note);
        return Storage.getAllNotes();
    }

//    @DeleteMapping
//    public ResponseEntity get(@RequestParam int id)
//    {
//        Note note = Storage.getNote(id);
//        if (note == null){
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
//        } else{
//            Storage.deleteAllNote();
//            return new ResponseEntity(HttpStatus.OK);
//        }
//    }

    @DeleteMapping("/notes/")
    public List<Note> deleteAll()
    {
        Storage.deleteAllNote();
        return Storage.getAllNotes();
    }

    @GetMapping("/notes/{id}")
    public String indexPage(@PathVariable int id)
    {
        return Storage.getNote(id).toString();
    }

    @DeleteMapping("/notes/{id}")
    public List<Note> deletePage(@PathVariable int id)
    {
        Storage.getAllNotes().remove(Storage.getNote(id));
        return Storage.getAllNotes();
    }

}
