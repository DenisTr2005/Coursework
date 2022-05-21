public class Main {
    public static void main(String[] args) {
        EmployeeBook employeeBook = new EmployeeBook();
        employeeBook.addNewEmployee("Ivanov1 Ivan Ivanovich", 1, 105_000);
        employeeBook.addNewEmployee("Ivanov2 Ivan Ivanovich", 3, 90_000);
        employeeBook.addNewEmployee("Ivanov3 Ivan Ivanovich", 3, 95_000);
        employeeBook.addNewEmployee("Ivanov4 Ivan Ivanovich", 5, 100_000);
        employeeBook.addNewEmployee("Ivanov5 Ivan Ivanovich", 4, 120_000);
        employeeBook.addNewEmployee("Ivanov6 Ivan Ivanovich", 1, 110_000);
        employeeBook.addNewEmployee("Ivanov7 Ivan Ivanovich", 2, 115_000);
        employeeBook.addNewEmployee("Ivanov8 Ivan Ivanovich", 1, 115_000);
        employeeBook.delEmployee(7);
        employeeBook.addNewEmployee("Ivanov9 Ivan Ivanovich", 2, 115_000);
        employeeBook.changeEmployeeSalary("Ivanov9 Ivan Ivanovich", 112_000);
        employeeBook.changeEmployeeDepartment("Ivanov9 Ivan Ivanovich", 3);

        System.out.println("Данные о всех сотрудниках:");
        employeeBook.listOfEmployeeData();
        System.out.println("Сумма затрат на зарплаты в месяц: " + employeeBook.salaryMonthSum());
        System.out.println("Сотрудник с минимльной зарплатой: " +  employeeBook.minSalary());
        System.out.println("Сотрудник с максимальной зарплатой: " + employeeBook.maxSalary());
        System.out.printf("Среднее значение зарплат: %.2f\n", employeeBook.averageSalary());
        System.out.println("Список имен сотрудников:");
        employeeBook.listOfEmployeeName();

        employeeBook.indexSalary(10);
        System.out.println("Данные о всех сотрудниках после индексации зарплаты на 10%:");
        employeeBook.listOfEmployeeData();
        System.out.println("Сотрудник отдела 1 с минимальной зарплатой: " +  employeeBook.minSalary(1));
        System.out.println("Сотрудник отдела 3 с максимальной зарплатой: " + employeeBook.maxSalary(3));
        System.out.println("Сумма затрат на зарплату по отделу 3: " + employeeBook.salaryMonthSum(3));
        System.out.println("Средняя зарплата по отделу 3: " + employeeBook.averageSalary(3));
        System.out.println("Индексация зарплаты сотрудников отдела 3 на 10%");
        employeeBook.indexSalary(3,10);
        employeeBook.listOfDepartment(3);
        int salary = 115_500;
        employeeBook.listOfLessSalary(salary);
        employeeBook.listOfMoreSalary(salary);
        employeeBook.listOfEmployeeDep();
    }
}
