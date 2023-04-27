import java.util.Scanner;

public class Main {

// hello, this is link to my github repo https://github.com/DamianRuczynski/HumanResourcePro

    public static void main(String[] args) {

        Department IT = createNewDepartment("IT");
        Department HR = createNewDepartment("HR");
        Task zadanko = new Task("Testowe zadanie");
        Task zadanko2 = new Task(" Running");

        startProgramm();

    }

    private static void startProgramm() {
        boolean running = true;
        Scanner sca = new Scanner(System.in);
        while (running) {
            System.out.println("Choose an option:");
            System.out.println("1. Employees Management");
            System.out.println("2. Team options");
            System.out.println("3. Tasks/Work");
            System.out.println("4. Exit");

            int choice = sca.nextInt();
            sca.nextLine();

            switch (choice) {
                case 1:
                    createEmployee();
                    break;
                case 2:
                    teamOptions();
                    break;
                case 3:
                    taskOptions();
                    break;
                case 4:
                    System.out.println("Thank tou for using HR Pro MaX");
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice");
                    break;
            }
        }
    }
// ------------------------------------------------------------------------------------------------------------------------------------------------------------------

    public static Department createNewDepartment(String name) {
        return Department.createDepartment(name);
    }


    // ------------------------------------------------------------------------------------------------------------------------------------------------------------------
    public static void createEmployee() {
        System.out.println("Please choose what type of employee do you want to create: ");
        System.out.println("1.Manager\n2.Trainer");
        Scanner sca = new Scanner(System.in);
        int option = sca.nextInt();
        switch (option) {
            case 1:
                Manager.createManager();
                break;
            case 2:
                Trainer.createTrainer();
                break;
            default:
                System.out.println("wrong number!");
                startProgramm();
                break;
        }
    }


    // ------------------------------------------------------------------------------------------------------------------------------------------------------------------

    private static void teamOptions() {
        System.out.println("Please select what do you want with team: ");
        System.out.println("1.Create new\n2.Add existing employee to team\n3.Show teams");
        Scanner sca = new Scanner(System.in);
        int option = sca.nextInt();
        switch (option) {
            case 1:
                Team.createTeam();
                break;
            case 2:
                Team.addEmpToTeam();
                break;
            case 3:
                Team.showTeams();
                break;
            default:
                System.out.println("wrong number!");
                startProgramm();
                break;
        }
    }

    // ------------------------------------------------------------------------------------------------------------------------------------------------------------------

    private static void taskOptions() {
        System.out.println("Please select what do you want with tasks: ");
        System.out.println("1.Create new Task\n2.Run Task\n3.Creae new work from task\4.Start work(By work id)");
        Scanner sca = new Scanner(System.in);
        int option = sca.nextInt();
        switch (option) {
            case 1:
                Task.createTask();
                break;
            case 2:
                Task.runTask();
                break;
            case 3:
                Work.getWork();
                break;
            case 4:
                Work.startWork();
                break;
            default:
                System.out.println("wrong number!");
                startProgramm();
                break;
        }
    }
}