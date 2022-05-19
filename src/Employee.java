public class Employee {
    private final String name;
    private int department;
    private  int salary;
    private static int count = 0;
    private final int id;

    public Employee(String name, int department, int salary) {
        this.name = name;
        this.department = department;
        this.salary = salary;
        id = ++count;
    }

    @Override
    public String toString() {
        return "Employee " + id + ": " + name + ", department " + department + ", salary " + salary;
    }

    public String getName() {
        return name;
    }

    public int getDepartment() {
        return department;
    }

    public int getSalary() {
        return salary;
    }

    public static int getCount() {
        return count;
    }

    public int getId() {
        return id;
    }

    public void setDepartment(int department) {
        this.department = department;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }
}
