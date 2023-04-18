import java.util.ArrayList;
import java.util.Date;

public class Main {
    public static void main(String[] args) {
        // Tworzenie struktoru aplikacji..
        Department testers = Department.createDepartment("testers");
        Department programmers = Department.createDepartment("programmers");

        Trainer trainerOne = new Trainer("John", "Griffin", new Date(), Department.getDepartment(0), "automation test");
        Manager Adam = new Manager("Adam", "Smith", new Date(), programmers, "AdaSmt", " weakPassword");
        Employee Michael = new Trainer("Michael", "De Santa", new Date() ,testers, "automation tests");

        Team teamm = new Team("Fast Five", Adam);

        Task zadanko = new Task("Testowe zadanie");
        Task zadanko2 = new Task("Bithces drip sossy");

        //Operacje na istniejacych zespolach taskach itd..

        teamm.addEmployee(new Employee[]{trainerOne, Michael});


        teamm.addTask(zadanko);
        teamm.addTask(zadanko2);
        zadanko2.run();


        // Wyswietlanie list taskow, pracownikow itd...
        System.out.println("------------");
        System.out.println(zadanko);

//        System.out.println(teamm.getTasks());


    }

}