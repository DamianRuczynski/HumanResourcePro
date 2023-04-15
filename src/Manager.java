import java.util.ArrayList;
import java.util.Date;

public class Manager extends Recepcionist{
    private ArrayList<Team> teams;
    private ArrayList<String> tasks;

    public Manager(String name, String surname, Date birth, Department dept, String login, String password) {
        super(name, surname, birth, dept, login, password);
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
}
