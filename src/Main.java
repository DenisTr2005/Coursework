public class Main {
    public static Employee[] employees = new Employee[10];
    public static void main(String[] args) {
        employees[0] = new Employee("Ivanov1 Ivan Ivanovich", 1, 105_000);
        employees[1] = new Employee("Ivanov2 Ivan Ivanovich", 3, 90_000);
        employees[2] = new Employee("Ivanov3 Ivan Ivanovich", 3, 95_000);
        employees[3] = new Employee("Ivanov4 Ivan Ivanovich", 5, 100_000);
        employees[4] = new Employee("Ivanov5 Ivan Ivanovich", 4, 120_000);
        employees[5] = new Employee("Ivanov6 Ivan Ivanovich", 1, 110_110);
        employees[6] = new Employee("Ivanov7 Ivan Ivanovich", 2, 115_000);

        listOfEmployeeData();
        System.out.println("Сумма затрат на зарплаты в месяц: " + salaryMonthSum());
        System.out.println("Сотрудник с минимльной зарплатой: " +  employees[minSalaryId()-1].getName());
        System.out.println("Сотрудник с максимальной зарплатой: " + employees[maxSalaryId()-1].getName());
        System.out.printf("Среднее значение зарплат: %.2f\n", averageSalary());
        listOfEmployeeName();
    }
    public static void listOfEmployeeData() {
        for (Employee employee : employees) {
            if (employee != null) {
                System.out.println(employee);
            } else return;
        }
    }
    public static void listOfEmployeeName() {
        for (Employee employee : employees) {
            if (employee != null) {
                System.out.println(employee.getName());
            } else return;
        }
    }

    public static int salaryMonthSum() {
        int sum = 0;
        for (Employee employee : employees) {
            if (employee != null) {
                sum += employee.getSalary();
            } else return sum;
        }
        return sum;
    }

    public static int minSalaryId() {
        return findSalaryId(true);
    }

    public static int maxSalaryId() {
        return findSalaryId(false);
    }

    public static double averageSalary() {return (double) salaryMonthSum() / Employee.getCount();}

    private static int findSalaryId(boolean min) {
        int salary, id;
        if (employees[0] != null) {
            salary = employees[0].getSalary();
            id = 1;
        } else throw new RuntimeException("В базе нет сотрудников");
        boolean extremal;
        for (Employee employee : employees) {
            if (employee == null) {
                return id;
            }
            if (min) {
                extremal = employee.getSalary() < salary;
            } else extremal = employee.getSalary() > salary;
            if (extremal) {
                salary = employee.getSalary();
                id = employee.getId();
            }
        }
        return id;
    }
}
