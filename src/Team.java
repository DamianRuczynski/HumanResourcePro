import java.sql.SQLOutput;
import java.util.ArrayList;

public class Team {
    String name;
    Manager manager;
    ArrayList<Employee> employees = new ArrayList<Employee>();
    ArrayList<Task> tasks = new ArrayList<Task>();

    public Team(String name, Manager manager){
        this.name = name;
        this.manager = manager;
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


    private boolean checkIfEmpIsManager(Employee emp){
        return emp instanceof Manager;
    }

    public boolean haveIllEmployee(){
        return employees.stream().anyMatch(emp -> !emp.healthy);
    }
}
