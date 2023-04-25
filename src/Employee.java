import java.util.ArrayList;
import java.util.Date;

abstract class Employee implements Comparable<Employee> {

    static int counter = 0;
    private final int id;
    protected static ArrayList<Employee> employees;
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

    public String getName() {
        return this.name + " " + this.surname;
    }
    public void fallSick() {
        this.healthy = false;
    }

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

