import jdk.jshell.Snippet;

import java.time.LocalDateTime;
import java.time.LocalTime;

public class Task extends Thread {
    String name;
    String desc;
    Status status;
    LocalDateTime started;
    LocalDateTime finished;
    int durationTime = (int)((Math.random() * 6) + 3);

    Task(String name){
        this.name = name;
        this.desc = "";
        this.status = status.NEW;
    }

    public String getTaskName() {
        return "\""+this.name+"\"";
    }

    private Status getStatus() {
        return this.status;
    }

    private String getTime(LocalDateTime date){
        return date.getHour() + ":" + date.getMinute();
    }

    @Override
    public String toString() {
        return "Task: " + this.getTaskName() + "\nduration: " + this.durationTime +"\nhave status: " + this.status;
    }


    @Override
    public void run() {
        super.run();
//        if(assignedTeam.haveIllEmployee()) System.out.println("Cannot execute task, while some employees are ill"); return;
        this.getStatus();
        this.finished = LocalDateTime.now();
        System.out.println("Task: " + this.getTaskName() + " finished at " + getTime(this.finished) + ".\nNow at status: " + this.getStatus());
    }
}
