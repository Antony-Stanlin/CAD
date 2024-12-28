package com.taskmanager.dto;

public class Task implements Comparable<Task>{

    private int id;
    private String name;
    private int priority;
    private int time;
    private static int count = 1;

    public Task(String name, int priority, int time) {
        this.id = count++;
        this.time = time;
        this.priority = priority;
        this.name = name;

    }

    public Task() {
        id = count++;

    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    @Override
    public int compareTo(Task task) {
        if(this.getPriority()!=task.getPriority())
            return Integer.compare(this.getPriority(), task.getPriority());
        return Integer.compare(this.getId(), task.getId());
    }

    @Override
    public String toString(){
        return """
        [ID: %d, Name: %s, Priority: %d, Time: %d mins]
                """.formatted(getId(),getName(),getPriority(),getTime());
    }

}
