package main;

import main.model.Note;
import main.model.NoteReposirore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping(value = "/notes/")
public class NoteController {

    @Autowired
    private NoteReposirore noteReposirore;

    @GetMapping("")
    public List<Note> pages(Note note) {
        List<Note> noteList = new ArrayList<>();
        Iterable<Note> notes = noteReposirore.findAll();
        notes.forEach(noteList::add);
        return noteList;
    }

    @PostMapping("")
    public ResponseEntity addNote(@RequestBody String str) {
        Note note = new Note(str);
        noteReposirore.save(note);
        return ResponseEntity.ok(HttpStatus.OK);
    }



    @PutMapping(value ="{id}")
    public ResponseEntity putNote(  @PathVariable int id, @RequestBody String str) {
        Optional<Note> optionalNote =  noteReposirore.findById(id);
        if (!optionalNote.isPresent())
        {
         return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        else {
            noteReposirore.findById(id).get().setName(str);
    }

        return ResponseEntity.ok(HttpStatus.OK);
    }


    @DeleteMapping("")
    public List<Note> deleteAll() {
        noteReposirore.deleteAll();
        return null;
    }

    @GetMapping("{id}")
    public ResponseEntity get(@RequestBody @PathVariable int id) {

        Optional<Note> optionalNote =  noteReposirore.findById(id);
        if (!optionalNote.isPresent())
        {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
            return new ResponseEntity(optionalNote.get(),HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public List<Note> deletePage(@PathVariable int id) {
        noteReposirore.deleteById(id);
        List<Note> noteList = new ArrayList<>();
        Iterable<Note> notes = noteReposirore.findAll();
        notes.forEach(noteList::add);
        return noteList;
    }

}
