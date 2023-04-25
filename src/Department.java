import java.util.ArrayList;

public class Department {
    static int counter = 0;
    private  final int id;
    private String name;
    private static ArrayList<Department> departments = new ArrayList<Department>();

    private Department(String name) throws NotUniqueException{
        for (Department dep: departments) {
            if(dep.name == name) throw new NotUniqueException("Department already exist");
        }
        this.name = name;
        this.id = counter;
        counter++;
    }


    public static Department createDepartment(String name){
        try {
            Department created = new Department(name);
            departments.add(created);
            System.out.println("Department " + name + " created!!");
            return created;
        } catch (NotUniqueException e) {
            System.out.println("Cannot create department: " + name);
            throw new RuntimeException(e);
        }
    }

    public static Department getDepartment(int index){
        return departments.get(index);
    }

    public static ArrayList<Department> showDepartments(){
        return departments;
    }

    @Override
    public String toString() {
        return "Department: " + this.name;
    }

}
