package program;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Employees;

public class Program {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);

		Scanner sc = new Scanner(System.in);

		List<Employees> list = new ArrayList<>();

		System.out.println("How many emplloyees will be registered?");
		int n = sc.nextInt();

		for (int i = 1; i <= n; i++) {
			System.out.println("Employee #" + i + ":");
			System.out.println("Id:");
			int id = sc.nextInt();
			System.out.println("Name:");
			sc.nextLine();
			String name = sc.nextLine();
			System.out.println("Salary:");
			double salary = sc.nextDouble();
			list.add(new Employees(id, name, salary));

		}

		System.out.println("Enter the employee id that will have salary increase:");
		int id = sc.nextInt();
		Employees emp = list.stream().filter(x -> x.getId() == id).findFirst().orElse(null);

		if (emp == null) {
			System.out.println("This id does not exist!");
		} else {
			System.out.print("Enter the percentage: ");
			double percentage = sc.nextDouble();
			emp.increaseSalary(percentage);
		}

		for (Employees e : list) {
			System.out.println(e.ToString());
		}

	}

}
