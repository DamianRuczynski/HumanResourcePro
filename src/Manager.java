
import java.util.ArrayList;
import java.util.Date;

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

    @Override
    public String toString() {
        return "Manager: " + this.getName();
    }
}
