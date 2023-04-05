import java.util.Date;

public class Trainer extends Employee{
    public String specialisation;
    public Trainer(String name, String surname, Date birth, Department dept, String specialisation){
        super(name, surname, birth, dept);
        this.specialisation = specialisation;
    }

    @Override
    public String toString() {
        return "Employee " + this.name + " " + this.surname + " created! Belongs to " + this.departmentBelong + " and specialize in " + this.specialisation;
    }
}
