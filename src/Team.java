import java.util.ArrayList;

public class Team {
    String name;
    Manager manager;
    ArrayList<Employee> employees;
    ArrayList<String> tasks;

    public Team(String name, Manager manager){
        this.name = name;
        this.manager = manager;
    }

    public void addEmployee(Employee emp){
        if(checkIfEmpIsManager(emp)){
            System.out.println("Cannot add manager as an employee!!");/// tutaj trzeba zrobic throw CannotAddManagerException
        }else{
            this.employees.add(emp);
        }
    }

    public void addEmployee(ArrayList<Employee> empList){
        for(Employee emp : empList){
            addEmployee(emp);
        }
    };
    private boolean checkIfEmpIsManager(Employee emp){
        return emp instanceof Manager;
    }
    public String getName() {
        return this.name;
    }

    public String getTasks() {
        String message = "";
        for(String task : tasks){
            message += task + " ";
        }
        return message;
    }
}
