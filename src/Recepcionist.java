import java.util.Date;

public class Recepcionist extends Employee {
    private String login;
    private String password;
    private String initial;

    public Recepcionist(String name, String surname, Date birth, Department dept, String login, String password) {
        super(name, surname, birth, dept);
        this.login = login;
        this.password = password;
        this.initial = generateInitial(name, surname);
    }


    private String generateInitial(String name, String surname) {
        String namePart = name.substring(0, 3).toUpperCase();
        String surnamePart = surname.substring(0, 3).toUpperCase();
        return namePart + surnamePart;
    }

}
