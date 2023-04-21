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
        try {
            System.out.println("Rozpoczęcie zadania: " + this.name);
            this.status = Status.PROGRAMMING;
            this.finished = LocalDateTime.now().plusSeconds(this.durationTime);

            for (int i = 1; i <= this.durationTime; i++) {
                System.out.println("Minęła " + i + " sekunda. Zadanie w toku.");
                Thread.sleep(1000);
            }

            System.out.println("Zakończenie zadania: " + this.name);
            this.status = Status.FINISHED;
            this.finished = LocalDateTime.now();
        } catch (InterruptedException e) {
            System.out.println("Przerwanie zadania: " + this.name);
            this.status = Status.NEW;
            this.finished = null;
        }
    }
}
