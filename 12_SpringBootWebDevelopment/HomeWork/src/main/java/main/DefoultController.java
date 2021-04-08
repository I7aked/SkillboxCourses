//package main;
//
//import model.Note;
//import org.springframework.context.annotation.ComponentScan;
//import org.springframework.context.annotation.ComponentScans;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.*;
//
//
//import java.util.Map;
//import java.util.Random;
//
//@Controller
//public class DefoultController
//{
//    @GetMapping
//    public String indexPage(Map<String, Object> model)
//    {
//        Iterable<Note> notes = Storage.getAllNotes();
//        model.put("notes",notes);
//        return "index";
//    }
//
//    @PostMapping
//    public String addNote(@RequestParam String name,  Map<String,Object> model)
//    {
//        Note note = new Note (name);
//        Storage.addNote(note);
//        Iterable<Note> notes = Storage.getAllNotes();
//        model.put("notes",notes);
//        return "index";
//    }
//
//
//}
