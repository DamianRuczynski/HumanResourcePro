import java.util.Date;

public class Main {
    public static void main(String[] args) {

        Department.createDepartment("testers");
        Department.createDepartment("programmers");

        Trainer trainerOne = new Trainer("John", "Griffin", new Date(), Department.getDepartment(0), "automation test");

        System.out.println(trainerOne);


    }

}