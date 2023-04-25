import java.sql.SQLOutput;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Department IT = createNewDepartment("IT");
        Department HR = createNewDepartment("HR");
        Task zadanko = new Task("Testowe zadanie");
        Task zadanko2 = new Task("Bithces drip sossy");

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
                createManager();
                break;
            case 2:
                createTrainer();
                break;
            default:
                System.out.println("wrong number!");
                startProgramm();
                break;
        }
    }


    private static void createTrainer() {
        Scanner sca = new Scanner(System.in);

        System.out.print("Enter Trainer's first name: ");
        String firstName = sca.next();

        System.out.print("Enter Trainer's last name: ");
        String lastName = sca.next();

        System.out.print("Enter Trainer's birth date (yyyy-mm-dd): ");
        String birthDateStr = sca.next();
        Date birthDate = java.sql.Date.valueOf(birthDateStr);

        System.out.print("Enter Trainer's department ID (0 for IT, 1 for HR): ");
        int deptId = sca.nextInt();
        Department dept = Department.getDepartment(deptId);

        System.out.print("Enter Trainer's speciality: ");
        String speciality = sca.next();

        Trainer trainer = new Trainer(firstName, lastName, birthDate, dept, speciality);
        Trainer.trainers.add(trainer);
        Employee.employees.add(trainer);

        System.out.println("New Trainer created: " + trainer);

        showEmployees(false);
    }

    private static void createManager() {
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
        showEmployees(true);

    }

    private static void showEmployees(boolean isManagerial) {
        if (isManagerial) {
            System.out.println("Active managers: ");
            for (Manager manager : Manager.managers) {
                System.out.println(manager);
            }
            System.out.println("------");
        } else {
            System.out.println("Active trainers: ");
            for (Trainer trainer : Trainer.trainers) {
                System.out.println(trainer);
            }
            System.out.println("------");
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
                createTeam();
                break;
            case 2:
                addEmpToTeam();
                break;
            case 3:
                showTeams();
                break;
            default:
                System.out.println("wrong number!");
                startProgramm();
                break;
        }
    }

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

    private static void showTeams() {
        System.out.println("Active teams: ");
        for (Team team : Team.teams) {
            System.out.println(team);
        }
        System.out.println("------");
    }

    private static void addEmpToTeam() {
        Scanner sca = new Scanner(System.in);
        System.out.println("Provide team ID:");
        int id = sca.nextInt();
        Team team = Team.teams.get(id);
        System.out.println("Provide emp ID:");
        int empId = sca.nextInt();
        Employee emp = Employee.employees.get(empId);
        team.addEmployee(emp);
    }

    // ------------------------------------------------------------------------------------------------------------------------------------------------------------------

    private static void taskOptions() {
        System.out.println("Please select what do you want with tasks: ");
        System.out.println("1.Create new Task\n2.Run Task\n3.Creae new work from task\4.Start work(By work id)");
        Scanner sca = new Scanner(System.in);
        int option = sca.nextInt();
        switch (option) {
            case 1:
                createTask();
                break;
            case 2:
                runTask();
                break;
            case 3:
                getWork();
                break;
            case 4:
                startWork();
                break;
            default:
                System.out.println("wrong number!");
                startProgramm();
                break;
        }
    }


    private static void createTask() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter task name:");
        String name = scanner.nextLine();

        System.out.println("Enter task description:");
        String desc = scanner.nextLine();

        Task task = new Task(name, desc);
        Work.allTasks.put(task.getTaskId(),task);

        System.out.println("Task " + task.getName() + " successfully created!");
        showTasks();

    }

    private static void showTasks() {
        System.out.println(Work.allTasks);
    }

    private static void runTask() {
        Scanner sca = new Scanner(System.in);
        System.out.println("Provide team which will execute this task:");
        int index = sca.nextInt();
        Team team = Team.teams.get(index);
        System.out.println("Provide task name for team " + team.getName() + " : ");
        String taskName = sca.next();
        team.startTask(taskName);

    }

    private static void getWork() {
        Scanner sca = new Scanner(System.in);
        System.out.println("Provide task id");
        int taskId = sca.nextInt();
        Work work = Work.getTaskFromWork(taskId);
        Work.works.add(work);
        System.out.println("Work created!");
    }
    private static void startWork() {
        Scanner sca = new Scanner(System.in);
        System.out.println("Please provide work id: ");
        int workId = sca.nextInt();
        Work work = Work.works.get(workId);
        work.startAllTasks();
        System.out.println("All task for this work should be done");
    }


}