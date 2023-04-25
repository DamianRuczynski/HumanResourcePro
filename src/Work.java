import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Work implements Runnable {
    //dla kazdej klasy stworz id i counter(static) oraz metode tostring
    private static int counter = 0;
    private final int id;
    static Map<Integer, Task> allTasks = new HashMap<>();
    private ArrayList<Task> tasks = new ArrayList<Task>();
    public static ArrayList<Work> works = new ArrayList<Work>();

    private String desc;
    private Team team;

    Work(String desc, Team team) {
        this.id = counter;
        counter++;
        this.desc = desc;
        this.team = team;
    }

    Work(String desc) {
        this.id = counter;
        counter++;
        this.desc = desc;
        this.team = null;
    }


    private String getDesc() {
        return "\"" + this.desc + "\"";
    }

    public static Work getTaskFromWork(int taskId) {
        if (allTasks.containsKey(taskId)) {
            return new Work(allTasks.get(taskId).getDescription());
        }
        return null;
    }

    public void addTask(Task task) {
        this.tasks.add(task);
        int taskId = task.getTaskId();
        allTasks.put(taskId, task);
    }

    public void startAllTasks() {
        this.tasks.stream().filter(e -> e.getStatus() != Status.NEW).forEach(task -> task.run());
        for (Task task : this.tasks) {
            if (task.getStatus() != Status.NEW) {
                task.run();
            } else {
                System.out.println("Task in status: " + Status.NEW + " cannot be started before approval!");
            }
        }
    }
// -----------------------------------------------------------

    public static void getWork() {
        Scanner sca = new Scanner(System.in);
        System.out.println("Provide task id");
        int taskId = sca.nextInt();
        Work work = Work.getTaskFromWork(taskId);
        Work.works.add(work);
        System.out.println("Work created!");
    }

    public static void startWork() {
        Scanner sca = new Scanner(System.in);
        System.out.println("Please provide work id: ");
        int workId = sca.nextInt();
        Work work = Work.works.get(workId);
        work.startAllTasks();
        System.out.println("All task for this work should be done");
    }

    //-------------------------------------------------------------------
    @Override
    public void run() {
        System.out.println("Work: " + this.getDesc() + " started...");
        this.startAllTasks();
        System.out.println("Work ended.");
    }

    @Override
    public String toString() {
        return "Work: " + this.getDesc() + (this.team != null ? "worked by: " + this.team.getName() : "is not assigned to the team");
    }
}
