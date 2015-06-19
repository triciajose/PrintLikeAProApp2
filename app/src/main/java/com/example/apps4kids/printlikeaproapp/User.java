package com.example.apps4kids.printlikeaproapp;

/**
 * Created by Jonathan on 2015-06-13.
 */
public class User {


    private int id;
    private String name;
    private int letterIndex;
    private int level;
    private String writtenName;
    private int score;



    public User(int id, String name, int letterIndex, int level, String writtenName, int score) {
        this.id = id;
        this.name = name;
        this.letterIndex = letterIndex;
        this.level = level;
        this.writtenName = writtenName;
        this.score = score;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLetterIndex() {
        return letterIndex;
    }

    public void setLetterIndex(int letterIndex) {
        this.letterIndex = letterIndex;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getWrittenName() {
        return writtenName;
    }

    public void setWrittenName(String writtenName) {
        this.writtenName = writtenName;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String toString() {
        return this.getName();
    }


}
