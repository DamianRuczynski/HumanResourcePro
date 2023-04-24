import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

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
//        zadanko2.run();

//        teamm.startTask("Testowe zadanie");
        teamm.startTask("Bithces drip sossy");

        // Wyswietlanie list taskow, pracownikow itd...
//        System.out.println("------------");
//        System.out.println(zadanko);
//
//        System.out.println(teamm.getTasks());

        /// NA POZNIEJ ZROB COS CO DZIALA JAK APLIKACJA

//        System.out.println("Welcome in Human Resources Pro Master 2023");
//        System.out.println("1. Create Team; \n2. Add new Task;\n3. Create Department \n0.EXIT");
//        System.out.println("Please provide number:");
//        Scanner sca = new Scanner(System.in);
//        int action = sca.nextInt();
//        while (action != 0) {
//            if (action == 0) {
//                return;
//            }
//            switch (action) {
//                case 1:
//                    System.out.println("new Team added!");
//                    break;
//                case 2:
//                    System.out.println("task created!");
//                    break;
//            }
//        }
//        ;

    }

}