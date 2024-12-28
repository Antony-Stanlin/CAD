package com.taskmanager.repository;

import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

import com.taskmanager.dto.Task;

public class Repository {

    Task task1=new Task("cvbn", 1, 2);
    Task task2=new Task("erty", 2, 1);
    Task task3=new Task("cvdfghbn", 1, 3);
    private static Repository repository;

    private Queue<Task> taskList=new PriorityQueue<>(List.of(task1,task2,task3));

   


    private Repository(){}

    public static Repository getInstance(){
        if(repository==null)
            repository=new Repository();
        return repository;
    }

    public void newTask(Task task){
        taskList.add(task);
    }

    public Queue<Task> getTaskList(){
        return taskList;
    }

    public Task simulate(){
        if(taskList.isEmpty())
            return null;

        return taskList.remove();
    }

}
