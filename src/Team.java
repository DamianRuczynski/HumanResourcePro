import java.sql.SQLOutput;
import java.util.ArrayList;

public class Team {

    static int counter = 0;
    private final int id;
    String name;
    Manager manager;
    ArrayList<Employee> employees = new ArrayList<Employee>();
    ArrayList<Task> tasks = new ArrayList<Task>();

    public Team(String name, Manager manager){
        this.id = counter;
        this.name = name;
        this.manager = manager;
        counter++;
    }

    public String getName() {
        return this.name;
    }

    public String getTasks() {
        String message = "Tasks in team " + this.name +": ";
        for(Task task : tasks){
            message += " \n- " + task.getTaskName() + " ";
        }
        return message;
    }

    public void addEmployee(Employee emp){
        if(checkIfEmpIsManager(emp)){
            System.out.println("Cannot add manager as an employee!!");/// tutaj trzeba zrobic throw CannotAddManagerException
        }else{
            this.employees.add(emp);
            System.out.println("Employee " + emp.name + " correctly added to " + this.name);
        }
    }

    public void addEmployee(Employee[] empList){
        for(Employee emp : empList){
            addEmployee(emp);
        }
    }

    public void addTask(Task task){
        if(this.tasks.contains(task)){
            System.out.println("Task: " + task.getTaskName() + " already in list!!"); // tutaj zrob throw
        }else{
            this.tasks.add(task);
            System.out.println("Task correctly added: " + task.getTaskName() + ".");
        }
    }


    private boolean checkIfEmpIsManager(Employee emp){
        return emp instanceof Manager;
    }

    public boolean haveIllEmployee(){
        return employees.stream().anyMatch(emp -> !emp.healthy);
    }

    public void startTask(String name){
        if(haveIllEmployee()) {
            System.out.println("nie mozna wykonac zadania, poniewaz nie");
            return;
        }
        this.tasks.stream().filter(e -> e.name.equals(name)).forEach(e -> e.run());
    }

    @Override
    public String toString() {
        return "Team{" +
                ", name='" + name + '\'' +
                ", manager=" + manager +
                ", employees=" + employees +
                ", tasks=" + tasks +
                '}';
    }
}
