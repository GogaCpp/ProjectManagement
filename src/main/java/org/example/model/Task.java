package org.example.model;

public class Task {

    private String task;
    private boolean done;
    public String getTask() {
        return task;
    }
    public void setTask(String task) {
        this.task = task;
    }
    public Task(String task){
        this.task=task;
        this.done=false;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

}
