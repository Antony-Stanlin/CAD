package com.taskmanager.setup;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

import com.taskmanager.dto.Task;
import com.taskmanager.repository.Repository;

class TaskModel {

    TaskView view;

    public TaskModel(TaskView view){
        this.view=view;
    }

    public void insertTask(Task task) {
        Repository.getInstance().newTask(task);
    }

    public void getTaskByPriority(){
        Map<Integer,List<Task>> map=new TreeMap<>();

        Queue<Task> taskQueue=Repository.getInstance().getTaskList();

        if(taskQueue.isEmpty()){
            view.printTask(null);
            return;
        }

        for(Task task:taskQueue){
            map.computeIfAbsent(task.getPriority(), k -> new ArrayList<>()).add(task);
        }

        view.printTask(map);
        return;
    }

    public void execute() {
        Task currentTask=Repository.getInstance().simulate();

        if(currentTask!=null && currentTask.getTime()==0)
            currentTask=Repository.getInstance().simulate();

        if(currentTask==null){
            view.status(null);
            return;
        }
            
        currentTask.setTime(currentTask.getTime()-1);

        insertTask(currentTask);

        view.status(currentTask);
        return;
    }

    public void markCompleted() {
        Task task = Repository.getInstance().simulate();

        if(task!=null)
            task.setTime(0);
        
        view.status(task);
        return;
    }

    public void calculateTotalTime() {
        Queue<Task> tasks=Repository.getInstance().getTaskList();
        int totalTime=0;
        for(Task task:tasks)
            totalTime+=task.getTime();

        view.showTotalTime(totalTime);
        return;
    }

}
