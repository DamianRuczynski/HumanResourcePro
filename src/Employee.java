import java.util.ArrayList;
import java.util.Date;

abstract class Employee implements Comparable<Employee>{
    protected static ArrayList<Employee> employees;
    protected String name;
    protected String surname;
    protected Date dateOfBirth;
    protected int experience;
    protected Department departmentBelong;
    protected boolean healthy = true;

    protected Employee(String name, String surname, Date birth, Department dept ){
        this.name = name;
        this.surname = surname;
        this.dateOfBirth = birth;
        this.departmentBelong = dept;
    }
    @Override
    public int compareTo(Employee comparedEmployee) {
        int comparison = this.experience - comparedEmployee.experience;

        if (comparison == 0) {
            comparison = this.dateOfBirth.compareTo(comparedEmployee.dateOfBirth);
        }
        return comparison;
    }
}

