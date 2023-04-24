import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Work implements Runnable{
    //dla kazdej klasy stworz id i counter(static) oraz metode tostring
    static int counter = 0;
    int taskCounter = 0;
    int id;
//    ArrayList<Task> tasks = new ArrayList<Task>();
    Map<Integer, Task> tasks = new HashMap<>();
    Map<Task, Work> taskWorkMap = new HashMap<>();
    String desc;
    Team team;

    Work(String desc, Team team){
        this.id = counter;
        counter++;
        this.desc = desc;
        this.team= team;
    }

    public void addTask(Task task){
        int taskId = task.getTaskId();
        this.tasks.put(taskId, task);
    }

//    public static Work getTaskFromWork(int id){ // zwracaj dane o pracy/prac ktore maja przypisane zadanie o danym id
//        return tasks.containsKey(id) ? tasks.get(id) : null;
//        return this;
//    }

//    public static Task getTaskInfo(int taskId){
////        allWorks.stream().anyMatch(task -> task.id == taskId);
////        tasks.
//    };

    @Override
    public void run() {

    }
}
