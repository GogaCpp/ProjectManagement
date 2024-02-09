package org.example;


import org.example.model.Project;
import org.example.model.Task;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Project> projects= new ArrayList<>();

        System.out.println("""
                Добро пожаловать в приложение "Управление проектами"!
                1. Создать проект
                2. Просмотреть список проектов
                3. Добавить задачу к проекту
                4. Отметить задачу как выполненную
                5. Выход""");
        while (true){
            System.out.println("Выберите действие (введите номер)");
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            int num;
            try {
                num = Integer.parseInt(reader.readLine());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            switch (num){
                case 1:{
                    String name;
                    System.out.print("Введите название проекта: ");
                    try {
                        name =reader.readLine();
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                    projects.add(new Project(name));
                    System.out.println("Проект успешно создан.");
                    break;
                }
                case 2:{
                    printAllProjects(projects);
                    break;
                }
                case 3:{
                    int i;
                    String string;
                    System.out.println("Введите номер проекта для добавления задачи:");
                    try {
                        i = Integer.parseInt(reader.readLine());
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                    if(i >projects.size() || i<=0){
                        System.out.println("Такого проекта нет");
                        break;
                    }
                    System.out.println("Введите описание задачи");
                    try {
                        string =reader.readLine();
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                    projects.get(i-1).addTask(new Task(string));
                    System.out.println("Задача успешно добавлена к проекту \""+ projects.get(i-1).getProjectName()+"\"");
                    break;
                }
                case 4:{
                    int pr,tk;
                    System.out.print("Введите номер проекта: ");
                    try {
                        pr = Integer.parseInt(reader.readLine());
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                    if(pr > projects.size()|| pr<=0){
                        System.out.println("Такого проекта нет");
                        break;
                    }
                    System.out.println("Введите номер задачи для отметки как выполненной: ");
                    try {
                        tk = Integer.parseInt(reader.readLine());
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                    if(tk > projects.get(pr-1).taskSize() || tk<=0){
                        System.out.println("Такой задачи нет");
                        break;
                    }
                    projects.get(pr-1).doneTask(tk-1);
                    System.out.println("Задача \""+ projects.get(pr-1).getTaskNameForId(tk-1)+ "\" выполнена.");
                    break;
                }
                case 5:{
                    System.out.println("До свидания!");
                    return;
                }
                default:{
                    System.out.println("Введите корректное значение");
                    break;
                }

            }
        }

    }
    static public void printAllProjects(ArrayList<Project> projects){
        for(int i=0;i<projects.size();i++){
            System.out.println(i + 1 +") "+projects.get(i).getProjectName());
            projects.get(i).printAllTasks();

        }
    }

}