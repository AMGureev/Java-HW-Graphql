package com.guryasha.graphqlhw.dao;

public class TaskEntity {
    private int id;
    private String desc;
    private String title;

    public TaskEntity(int id, String title, String desc) {
        this.id = id;
        this.desc = desc;
        this.title = title;
    }

    public int getId() {
        return id;
    }
}
