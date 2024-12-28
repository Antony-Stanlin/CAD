package com.taskmanager.setup;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.taskmanager.dto.Task;

public class TaskView {

    private TaskModel model;

    public TaskView(){
        model=new TaskModel(this);
    }

    public void init(){
        while(true){

            Scanner sc=new Scanner(System.in);
    
            System.out.println("\nWelcome to the Task Schduling System");
            System.out.println("1.Add Task\n2.View Tasks by priority");
            System.out.println("3.Simulate Task Execution\n4.Mark Task as Completed");
            System.out.println("5.Calculate Total Time\n6.Exit");
    
            int choice = sc.nextInt();
            
            switch (choice) {
                case 1:
                    addTask();
                    break;
                case 2:
                    model.getTaskByPriority();
                    break;
                case 3:
                    model.execute();
                    break;
                case 4:
                    model.markCompleted();
                    break;
                case 5:
                    model.calculateTotalTime();
                    break;
                case 6:
                    return;
            }
        }
    }
    

    private void addTask(){
        Scanner sc=new Scanner(System.in);
        Task task=new Task();
        System.out.println("Enter the Task name:");
        task.setName(sc.nextLine());
        System.out.println("Enter the priority:");
        task.setPriority(sc.nextInt());
        System.out.println("Enter the time taken:");
        task.setTime(sc.nextInt());
        model.insertTask(task);
        System.out.println("Task added: "+task);
    }

    public void printTask(Map<Integer,List<Task>> map){
        map.forEach((priority,tasks)->{
            System.out.println("Priority " + priority + ":");
            tasks.forEach(System.out::println);
        });
    }

    public void status(Task currentTask){

        if(currentTask==null){
            System.out.println("All Tasks were executed successfully");
            return;
        }
        else
            System.out.print("Executing Task:\""+currentTask.getName()+"\",");

        if(currentTask.getTime()>0)
            System.out.println("Remaining Time: "+currentTask.getTime()+" mins");
        else
            System.out.println("Completed");

    }

    public void showTotalTime(int totalTime) {
        System.out.println("Total time to execute all Task: "+totalTime+" mins");
    }


}
