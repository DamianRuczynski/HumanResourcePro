import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Scanner;

public class Team {

    static int counter = 0;
    private final int id;
    private String name;
    private Manager manager;
    private ArrayList<Employee> employees = new ArrayList<Employee>();
    private ArrayList<Task> tasks = new ArrayList<Task>();
    public static ArrayList<Team> teams = new ArrayList<Team>();

    public Team(String name, Manager manager) {
        this.id = counter;
        this.name = name;
        this.manager = manager;
        counter++;
    }

    public String getName() {
        return this.name;
    }

    public String getTasks() {
        String message = "Tasks in team " + this.name + ": ";
        for (Task task : tasks) {
            message += " \n- " + task.getTaskName() + " ";
        }
        return message;
    }

    public void addEmployee(Employee emp) {
        if (checkIfEmpIsManager(emp)) {
            System.out.println("Cannot add manager as an employee!!");/// tutaj trzeba zrobic throw CannotAddManagerException
        } else {
            this.employees.add(emp);
            System.out.println("Employee " + emp.name + " correctly added to " + this.name);
        }
    }

    public void addEmployee(Employee[] empList) {
        for (Employee emp : empList) {
            addEmployee(emp);
        }
    }

    public void addTask(Task task) {
        if (this.tasks.contains(task)) {
            System.out.println("Task: " + task.getTaskName() + " already in list!!"); // tutaj zrob throw
        } else {
            this.tasks.add(task);
            System.out.println("Task correctly added: " + task.getTaskName() + ".");
        }
    }


    private boolean checkIfEmpIsManager(Employee emp) {
        return emp instanceof Manager;
    }

    public boolean haveIllEmployee() {
        return employees.stream().anyMatch(emp -> !emp.healthy);
    }

    public void startTask(String name) {
        if (haveIllEmployee()) {
            System.out.println("nie mozna wykonac zadania, poniewaz nie");
            return;
        }
        this.tasks.stream().filter(e -> e.name.equals(name)).forEach(e -> e.run());
    }

    // ----------------------------------------------------------------------------------


    public static void createTeam() {
        Scanner sca = new Scanner(System.in);
        System.out.print("Team name: ");
        String name = sca.next();
        System.out.print("Provide Manager name: ");
        String managerName = sca.next();
        Manager manager = Manager.getManagerByName(managerName);
        Team team = new Team(name, manager);
        manager.assignTeam(team);
        Team.teams.add(team);
        System.out.println("Team " + team.getName() + " successfully created!");
        showTeams();
    }

    public static void showTeams() {
        System.out.println("Active teams: ");
        for (Team team : Team.teams) {
            System.out.println(team);
        }
        System.out.println("------");
    }

    public static void addEmpToTeam() {
        Scanner sca = new Scanner(System.in);
        System.out.println("Provide team ID:");
        int id = sca.nextInt();
        Team team = Team.teams.get(id);
        System.out.println("Provide emp ID:");
        int empId = sca.nextInt();
        Employee emp = Employee.employees.get(empId);
        team.addEmployee(emp);
    }

    // -----------------------------------------------------------------------------------

    @Override
    public String toString() {
        return this.getName() + ", " + manager;
    }
}
