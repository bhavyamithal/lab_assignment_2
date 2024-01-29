import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

class Employee {
    private int id;
    private String name;
    private int age;
    private double salary;

    public Employee(int id, String name, int age, double salary) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public double getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return id + " | " + name + " | " + age + " | " + salary;
    }
}

public class Main {
    public static void main(String[] args) {
        
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee(1, "John Smith", 30, 50000));
        employees.add(new Employee(2, "Jane Doe", 25, 40000));
        employees.add(new Employee(3, "Mike Jones", 40, 60000));

        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose sorting parameter: 1. Age, 2. Name, 3. Salary");
        int sortingParameter = scanner.nextInt();
        List<Employee> sortedEmployees = sortEmployees(new ArrayList<>(employees), sortingParameter);
        if (sortedEmployees != null) {
            System.out.println("Sorted data:");
            for (Employee employee : sortedEmployees) {
                System.out.println(employee);
            }
        }
    }

    public static List<Employee> sortEmployees(List<Employee> employees, int sortingParameter) {
        if (sortingParameter == 1) {
            Collections.sort(employees, Comparator.comparingInt(Employee::getAge));
        } else if (sortingParameter == 2) {
            Collections.sort(employees, Comparator.comparing(Employee::getName));
        } else if (sortingParameter == 3) {
            Collections.sort(employees, Comparator.comparingDouble(Employee::getSalary));
        } else {
            System.out.println("Invalid sorting parameter. Please choose 1 for Age, 2 for Name, or 3 for Salary.");
            return null;
        }

        return employees;
    }
}
