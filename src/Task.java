import jdk.jshell.Snippet;

import java.time.LocalDateTime;
import java.time.LocalTime;

public class Task extends Thread {
    String name;
    String desc;
    Status status;
    LocalDateTime started;
    LocalDateTime finished;
    int durationTime = (int) ((Math.random() * 6) + 3);

    Task(String name) {
        this.name = name;
        this.desc = "";
        this.status = status.NEW;
    }

    public String getTaskName() {
        return "\"" + this.name + "\"";
    }

    private Status getStatus() {
        return this.status;
    }

    private String getTime(LocalDateTime date) {
        return date.getHour() + ":" + date.getMinute() + ":" + date.getSecond();
//        return String.format("%d:%02d'%02d", date.getHour(), date.getMinute(), date.getSecond());
    }


    @Override
    public String toString() {
        return "Task: " + this.getTaskName() + "\nduration: " + this.durationTime + "\nhave status: " + this.status;
    }

    @Override
    public void run() {
        try {
            this.status = Status.STARTED;
            this.started = LocalDateTime.now();
            System.out.println("Task: " + this.getTaskName() + " in status: " + this.getStatus() + " started at: " + this.getTime(this.started));

            this.status = Status.PROGRAMMING;

            for (int i = 1; i <= this.durationTime; i++) {
                System.out.println(i + " seconds have passed. Work in progress.");
                Thread.sleep(1000);
            }

            this.status = Status.FINISHED;
            this.finished = LocalDateTime.now();
            System.out.println("Work end at: " + this.getTime(this.finished) + ". Task " + this.getTaskName() + " is now in status: " + this.getStatus());
        } catch (InterruptedException e) {
            System.out.println("OH NO! Task " + this.name + " aborted due to the conflicts: " + e);
            this.status = Status.NEW;
            this.finished = null;
        }
    }
}
