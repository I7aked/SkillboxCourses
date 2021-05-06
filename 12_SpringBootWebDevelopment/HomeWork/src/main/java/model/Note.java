package model;

import java.util.Date;

public class Note {

    public Note() {}

    public Note(String name, int id) {
        this.name = name;
        this.id = id;
    }

    private int id;

    private String name;

    public Note(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


}
