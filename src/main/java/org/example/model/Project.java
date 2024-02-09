package org.example.model;

import java.util.ArrayList;

public class Project {


    private String projectName;
    private final ArrayList <Task> tasks;

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public Project(String name){
        this.projectName=name;
        tasks=new ArrayList<>();
    }

    public void addTask(Task task){
        tasks.add(task);
    }
    public int taskSize(){
        return tasks.size();
    }
    public void printAllTasks(){
        for (int i=0;i<tasks.size();i++){
            System.out.println("    "+(i+1)+") "
                    + tasks.get(i).getTask()
                    + (tasks.get(i).isDone() ? " ✅" : " ❌"));
        }

    }
    public void doneTask(int id){
        if(!tasks.get(id).isDone())
            tasks.get(id).setDone(true);
        else
            System.out.println("Задача уже выполнена");
    }
    public String getTaskNameForId(int id){
        return tasks.get(id).getTask();
    }
}
