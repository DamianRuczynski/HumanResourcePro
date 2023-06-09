import java.util.ArrayList;
import java.util.Date;

abstract class Employee implements Comparable<Employee>, IGoodEmployee {

    static int counter = 0;
    private final int id;
    protected static ArrayList<Employee> employees = new ArrayList<Employee>();
    protected String name;
    protected String surname;
    protected Date dateOfBirth;
    protected int experience;
    protected Department departmentBelong;
    protected boolean healthy = true;

    protected Employee(String name, String surname, Date birth, Department dept) {
        this.id = counter;
        this.name = name;
        this.surname = surname;
        this.dateOfBirth = birth;
        this.departmentBelong = dept;
        counter++;
    }

    @Override
    public void workHard(Work work) {
        work.startAllTasks();
        System.out.println(this.name + " working hard at task: " + work.toString());
    }

    @Override
    public String askQuestions(Task task) {
        return task.getName() + " is asked, you have to do: " + task.desc;
    }

    @Override
    public void raiseHand() {
        System.out.println("Hand raised");
    }

    public String getName() {
        return this.name + " " + this.surname;
    }
    public void fallSick() {
        this.healthy = false;
    }

    // -----------------------------------------------------



    public static void showEmployees(boolean isManagerial) {
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
    // -------------------------------------------------

    @Override
    public int compareTo(Employee comparedEmployee) {
        int comparison = this.experience - comparedEmployee.experience;

        if (comparison == 0) {
            comparison = this.dateOfBirth.compareTo(comparedEmployee.dateOfBirth);
        }
        return comparison;
    }

    @Override
    public String toString() {
        return this.getName() +" born in: " + this.dateOfBirth + " belongs to " + this.departmentBelong;
    }
}

