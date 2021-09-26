package main;

import main.model.Note;
import main.model.NoteReposirore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import java.util.ArrayList;
import java.util.Map;
import java.util.Random;

@Controller
public class DefoultController {

    @Autowired
    NoteReposirore noteReposirore;


    @RequestMapping("/")
    public String index(Model model) {
        Iterable<Note> noteIterable = noteReposirore.findAll();
        ArrayList<Note> notes = new ArrayList<>();
        for (Note note : noteIterable) {
            notes.add(note);
        }
        model.addAttribute("notes", notes);
        model.addAttribute("notesCount", notes.size());
        return "index";
    }


}
