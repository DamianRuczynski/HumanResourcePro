import java.util.Date;

public class Recepcionist extends Employee {

    static int counter = 0;
    private final int id;
    private String login;
    private String password;
    private String initial;

    public Recepcionist(String name, String surname, Date birth, Department dept, String login, String password) {
        super(name, surname, birth, dept);
        this.id = counter;
        this.login = login;
        this.password = password;
        this.initial = generateInitial(name, surname);
        counter++;
    }

    protected String generateInitial(String name, String surname) {
        String namePart = name.substring(0, 3).toUpperCase();
        String surnamePart = surname.substring(0, 3).toUpperCase();
        return namePart + surnamePart;
    }

    @Override
    public String toString() {
        return "Recepcionist: " + this.getName();
    }
}
