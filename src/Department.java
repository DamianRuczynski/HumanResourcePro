import java.util.ArrayList;

public class Department {
    private String name;
    private static ArrayList<Department> departments = new ArrayList<Department>();

    Department(String name) throws NotUniqueException{
        for (Department dep: departments) {
            if(dep.name == name) throw new NotUniqueException("Department already exist");
        }
        this.name = name;
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
        return this.name;
    }
}
