package model;

import java.util.Date;

public class Note
{
    //private boolean isAlive = true;
    private String name;
    private int id;


    public Note(){}

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
