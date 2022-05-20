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

        System.out.println("Данные о всех сотрудниках:");
        listOfEmployeeData();
        System.out.println("Сумма затрат на зарплаты в месяц: " + salaryMonthSum());
        System.out.println("Сотрудник с минимльной зарплатой: " +  employees[minSalaryId()-1].getName());
        System.out.println("Сотрудник с максимальной зарплатой: " + employees[maxSalaryId()-1].getName());
        System.out.printf("Среднее значение зарплат: %.2f\n", averageSalary());
        System.out.println("Список имен сотрудников:");
        listOfEmployeeName();

        indexSalary(10);
        System.out.println("Данные о всех сотрудниках после индексации зарплаты на 10%:");
        listOfEmployeeData();
        System.out.println("Сотрудник отдела 1 с минимальной зарплатой: " +  employees[minSalaryId(1)-1].getName());
        System.out.println("Сотрудник отдела 3 с максимальной зарплатой: " + employees[maxSalaryId(3)-1].getName());
        System.out.println("Сумма затрат на зарплату по отделу 3: " + salaryMonthSum(3));
        System.out.println("Средняя зарплата по отделу 3: " + averageSalary(3));
        System.out.println("Индексация зарплаты сотрудников отдела 3 на 10%");
        indexSalary(3,10);
        listOfDepartment(3);
        int salary = 115_500;
        listOfLessSalary(salary);
        listOfMoreSalary(salary);
    }

    public static void listOfLessSalary(int salary) {
        System.out.println("Список сотрудников с зарплатой меньше " + salary + " :");
        for (Employee employee : employees) {
            if (employee != null) {
                if (employee.getSalary() < salary) {
                    System.out.println("Employee " + employee.getId() + ": " + employee.getName() + ", salary " + employee.getSalary());
                }
            } else return;
        }
    }
    public static void listOfMoreSalary(int salary) {
        System.out.println("Список сотрудников с зарплатой больше " + salary + " :");
        for (Employee employee : employees) {
            if (employee != null) {
                if (employee.getSalary() >= salary) {
                    System.out.println("Employee " + employee.getId() + ": " + employee.getName() + ", salary " + employee.getSalary());
                }
            } else return;
        }
    }
    public static void indexSalary(int index) {
        indexSalary(0, index);
    }
    public static void indexSalary(int department, int index) {
        for (Employee employee : employees) {
            if (employee != null) {
                if (department == 0 || employee.getDepartment() == department) {
                    employee.setSalary(employee.getSalary() + employee.getSalary() * index / 100);
                }
            } else return;
        }
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

    public static void listOfDepartment(int department) {
        System.out.println("Список сотрудников отдела " + department + ":");
        for (Employee employee : employees) {
            if (employee != null) {
                if (employee.getDepartment() == department) {
                    System.out.println("Employee " + employee.getId() + ": " + employee.getName() + ", salary " + employee.getSalary());
                }
            } else return;
        }
    }

    public static int salaryMonthSum() { return salaryMonthSum(0); }
    public static int salaryMonthSum(int department) {
        int sum = 0;
        for (Employee employee : employees) {
            if (employee != null) {
                if (department!=0 && employee.getDepartment() != department) {
                    continue;
                }
                sum += employee.getSalary();
            } else {
                return sum;
            }
        }
        return sum;
    }

    public static double averageSalary() { return averageSalary(0); }
    public static double averageSalary(int department) {
        int count = 0;
        int i = findDepartmentId(department);
        if (department == 0) {
            return (double) salaryMonthSum() / Employee.getCount();
        }
        for (;i<Employee.getCount();i++) {
            if (employees[i-1].getDepartment() == department) {
                count++;
            }
        }
        return (double) salaryMonthSum(department) / count;
    }
    public static int minSalaryId() {return minSalaryId(0);}

    public static int minSalaryId(int department) {
        return findSalaryId(department,true);
    }
    public static int maxSalaryId() { return maxSalaryId(0); }

    public static int maxSalaryId(int department) { return findSalaryId(department,false); }

    private static int findDepartmentId(int department) {
        if(department==0) return 1;
        for (Employee employee : employees) {
            if (employee == null) {
                break;
            }
            if (employee.getDepartment() == department) {
                return employee.getId();
            }
        }
        throw new RuntimeException("Сотрудники в отделе " + department + " отсутствуют");
    }

    private static int findSalaryId(int department, boolean min) {
        int salary, id;
        if (employees[0] != null) {
            salary = employees[findDepartmentId(department)-1].getSalary();
            id = findDepartmentId(department);
        } else throw new RuntimeException("В базе нет сотрудников");
        boolean extremal;
        for (Employee employee : employees) {
            if (employee == null) {
                return id;
            }
            if (department!=0 && employee.getDepartment() != department) {
                continue;
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
