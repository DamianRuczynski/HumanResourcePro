

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Trainer extends Employee{

    public static ArrayList<Trainer> trainers = new ArrayList<Trainer>();
    static int counter = 0;
    private final int id;
    public String specialisation;
    public Trainer(String name, String surname, Date birth, Department dept, String specialisation){
        super(name, surname, birth, dept);
        this.id = counter;
        this.specialisation = specialisation;
        counter++;
    }

    public String getAddedInfo(){
        return "Employee " + this.name + " " + this.surname + " created! Belongs to " + this.departmentBelong + " and specialize in " + this.specialisation;
    }



    //-------------------------------------------------------------------------------------------------
    static void createTrainer() {
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

        System.out.println("New Trainer created: " + trainer.getAddedInfo());

        Employee.showEmployees(false);
    }

    //-------------------------------------------------------------------------------------------------

    @Override
    public String askQuestions(Task task) {
        return super.askQuestions(task);
    }

    @Override
    public void workHard(Work work) {
        System.out.println("Work hard, play hard..!!");;
    }

    @Override
    public void raiseHand() {
        System.out.println("Sorry boss.. my people needs promotion");
    }
    @Override
    public String toString() {
        return this.name + this.surname + "specialized in: " + this.specialisation;
    }
}
