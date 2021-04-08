package main;

import model.Note;

import java.util.*;

public class Storage
{
    private static int currentId = 1;
    private static HashMap<Integer,Note> noteList = new HashMap<>();

    public static List<Note> getAllNotes()
    {
        ArrayList<Note> noteArrayList = new ArrayList<>();
        noteArrayList.addAll(noteList.values());
        return noteArrayList;
    }

    public static int addNote (Note note)
    {
        int id = currentId++;
        note.setId(id);
        noteList.put(id, note);
        return id;
    }

    public static Note getNote(int noteId)
    {
        if (noteList.containsKey(noteId))
        {
        return noteList.get(noteId);
        }
        return null;
    }

    public static void deleteAllNote()
    {
        Set<Note> localSet = new HashSet<>();
        for (Map.Entry<Integer,Note> entry : noteList.entrySet())
            localSet.add(entry.getValue());

        for (Note note :localSet)
        {
            noteList.remove(note);
        }
    }
}
