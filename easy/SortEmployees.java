import java.util.*;

public class SortEmployees {
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("Alice", 30, 70000));
        employees.add(new Employee("Bob", 25, 50000));
        employees.add(new Employee("Charlie", 35, 90000));
        employees.add(new Employee("David", 28, 65000));

        Scanner scanner = new Scanner(System.in);
        System.out.println("Sort by:\n1. Name\n2. Age\n3. Salary");
        System.out.print("Choose an option: ");
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                employees.sort((e1, e2) -> e1.getName().compareToIgnoreCase(e2.getName()));
                System.out.println("\nSorted by Name:");
                break;
            case 2:
                employees.sort((e1, e2) -> Integer.compare(e1.getAge(), e2.getAge()));
                System.out.println("\nSorted by Age:");
                break;
            case 3:
                employees.sort((e1, e2) -> Double.compare(e1.getSalary(), e2.getSalary()));
                System.out.println("\nSorted by Salary:");
                break;
            default:
                System.out.println("Invalid option.");
                return;
        }

        for (Employee e : employees) {
            System.out.println(e);
        }
    }
}
