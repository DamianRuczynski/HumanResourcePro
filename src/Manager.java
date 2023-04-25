
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Manager extends Recepcionist{

    public static ArrayList<Manager> managers = new ArrayList<Manager>();
    static int counter = 0;
    private final int id;
    private ArrayList<Team> teams = new ArrayList<Team>();
    private ArrayList<Task> tasks = new ArrayList<Task>();
    private String initial;

    public Manager(String name, String surname, Date birth, Department dept, String login, String password) {
        super(name, surname, birth, dept, login, password);
        this.id = counter;
        this.initial = generateInitial(name, surname);
        counter++;
    }

    public static Manager getManagerByName(String managerName) {
        return managers.stream().filter(e -> e.name.equals(managerName)).findFirst().orElse(null);
    }

    public String getTeams(){
        String message = "Manager " + this.name +" teams: ";
        for(Team team : this.teams){
            message += team.getName() + " ";
        }

        return message;
    }

    public String getTasksForSelectedTeam(Team selectedTeam){
        String teamTasksMessage = "Manager " + this.name +" tasks: " + selectedTeam.getTasks();

        return teamTasksMessage;
    }

    public String getAllTasks(){
        String allTasksMessage = "Manager " + this.name +" tasks: ";

        for(Team team : this.teams){
            allTasksMessage += team.getTasks() + "\n";
        }
        return allTasksMessage;
    }

    public void assignTeam(Team team){
        this.teams.add(team);
    }

    public void setTask(Task task){
        this.tasks.add(task);
    }


    //-------------------------------------------------------------------------------------------------
    public static void createManager() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter Manager's first name: ");
        String firstName = scanner.nextLine();

        System.out.print("Enter Manager's last name: ");
        String lastName = scanner.nextLine();

        System.out.print("Enter Manager's date of birth (yyyy-mm-dd): ");
        String birth = scanner.nextLine();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-dd-MM");
        Date birthDate = null;
        try {
            birthDate = formatter.parse(birth);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

        System.out.print("Enter Manager's department ID (0 for IT, 1 for HR): ");
        Department department = Department.getDepartment(scanner.nextInt());

        System.out.print("Enter Manager's username: ");
        String username = scanner.nextLine();

        System.out.print("Enter Manager's password: ");
        String password = scanner.nextLine();

        Manager manager = new Manager(firstName, lastName, birthDate, department, username, password);

        Manager.managers.add(manager);
        Employee.employees.add(manager);

        System.out.println("New Manager created: " + manager);
        Employee.showEmployees(true);

    }

    //-------------------------------------------------------------------------------------------------

    @Override
    public String toString() {
        return "Manager: " + this.getName();
    }
}
