

import java.util.ArrayList;
import java.util.Date;

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

    @Override
    public String toString() {
        return "Employee " + this.name + " " + this.surname + " created! Belongs to " + this.departmentBelong + " and specialize in " + this.specialisation;
    }
}
