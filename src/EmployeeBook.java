public class EmployeeBook {
    private final Employee[] employees = new Employee[10];
    public void addNewEmployee(String name, int department, int salary) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] == null) {
                employees[i] = new Employee(name, department, salary);
                return;
            }
        }
        throw new RuntimeException("EmployeeBook is over overflow");
    }

    public void delEmployee(String name) { delEmployee(name,0); }
    public void delEmployee(int id) { delEmployee("",id); }
    public void delEmployee(String name, int id) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null && (id == 0 && employees[i].getName().equals(name)
                                      || name.equals("") && employees[i].getId() == id
                                      || employees[i].getName().equals(name) && employees[i].getId() == id)) {
                employees[i] = null;
            }
        }
    }
    public void changeEmployeeSalary(String name, int salary) {
        for (Employee employee : employees) {
            if (employee != null && employee.getName().equals(name)) {
                employee.setSalary(salary);
                return;
            }
        }
    }
    public void changeEmployeeDepartment(String name, int department) {
        for (Employee employee : employees) {
            if (employee != null && employee.getName().equals(name)) {
                employee.setDepartment(department);
                return;
            }
        }
    }
    public void listOfLessSalary(int salary) {
        System.out.println("Список сотрудников с зарплатой меньше " + salary + " :");
        for (Employee employee : employees) {
            if (employee != null && employee.getSalary() < salary) {
                System.out.println("Employee " + employee.getId() + ": " + employee.getName() + ", salary " + employee.getSalary());
            }
        }
    }
    public void listOfMoreSalary(int salary) {
        System.out.println("Список сотрудников с зарплатой больше " + salary + " :");
        for (Employee employee : employees) {
            if (employee != null && employee.getSalary() >= salary) {
                    System.out.println("Employee " + employee.getId() + ": " + employee.getName() + ", salary " + employee.getSalary());
            }
        }
    }
    public void indexSalary(int index) {
        indexSalary(0, index);
    }
    public void indexSalary(int department, int index) {
        for (Employee employee : employees) {
            if (employee != null && (department == 0 || employee.getDepartment() == department)) {
                    employee.setSalary(employee.getSalary() + employee.getSalary() * index / 100);
            }
        }
    }
    public void listOfEmployeeData() {
        for (Employee employee : employees) {
            if (employee != null) {
                System.out.println(employee);
            }
        }
    }
    public void listOfEmployeeName() {
        for (Employee employee : employees) {
            if (employee != null) {
                System.out.println(employee.getName());
            }
        }
    }

    public void listOfDepartment(int department) {
        System.out.println("Список сотрудников отдела " + department + ":");
        for (Employee employee : employees) {
            if (employee != null && employee.getDepartment() == department) {
                    System.out.println("Employee " + employee.getId() + ": " + employee.getName() + ", salary " + employee.getSalary());
            }
        }
    }

    public void listOfEmployeeDep() {
        System.out.println("Ф. И. О. всех сотрудников по отделам");
        for (int i = 1; i <= 5; i++) {
            System.out.println("Сотрудники отдела " + i + ":");
            for (Employee employee : employees) {
                if (employee != null && employee.getDepartment() == i) {
                    System.out.println(employee.getName());
                }
            }
        }

    }
    public int salaryMonthSum() { return salaryMonthSum(0); }
    public int salaryMonthSum(int department) {
        int sum = 0;
        for (Employee employee : employees) {
            if (employee != null && (department == 0 || employee.getDepartment() == department)) {
                sum += employee.getSalary();
            }
        }
        return sum;
    }

    public double averageSalary() { return averageSalary(0); }
    public double averageSalary(int department) {
        int count = 0;
        int i = findDepartmentIndex(department);
        for (;i<employees.length;i++) {
            if (employees[i] != null && (department == 0 || employees[i].getDepartment() == department)) {
                count++;
            }
        }
        return (double) salaryMonthSum(department) / count;
    }
    public String minSalary() {return minSalary(0);}

    public String minSalary(int department) { return employees[findSalaryIndex(department,true)].getName(); }
    public String maxSalary() { return maxSalary(0); }

    public String maxSalary(int department) { return employees[findSalaryIndex(department,false)].getName(); }

    private int findDepartmentIndex(int department) {
        for (int i = 0; i < employees.length; i++) {
            if(employees[i] != null && (department == 0 || employees[i].getDepartment() == department)) {
                return i;
            }
        }
        throw new RuntimeException("Сотрудники в отделе " + department + " отсутствуют");
    }

    private int findSalaryIndex(int department, boolean min) {
        int i = findDepartmentIndex(department);
        int index = i;
        int salary = employees[i].getSalary();
        boolean extremal;
        for (;i<employees.length;i++) {
            if (employees[i] != null && (department == 0 || employees[i].getDepartment() == department)) {
                if (min) {
                    extremal = employees[i].getSalary() < salary;
                } else extremal = employees[i].getSalary() > salary;
                if (extremal) {
                    salary = employees[i].getSalary();
                    index = i;
                }
            }
        }
        return index;
    }

}
