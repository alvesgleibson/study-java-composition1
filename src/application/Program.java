package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Department;
import entities.HourContract;
import entities.Worker;
import entities.enums.WorkerLevel;

public class Program {

	public static void main(String[] args) throws ParseException {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		System.out.print("Enter department's name: ");
		String department = sc.nextLine();

		System.out.println("Enter Worker data");
		System.out.print("Name: ");
		String name = sc.nextLine();

		System.out.print("Level: ");
		String workerLevel = sc.nextLine();

		System.out.print("Base Salary: ");
		double baseSalary = sc.nextDouble();

		Worker worker = new Worker(name, WorkerLevel.valueOf(workerLevel), baseSalary, new Department(department));

		System.out.print("How many contracts to this worker? ");
		int numberContract = sc.nextInt();

		for (int i = 1; i <= numberContract; i++) {
			System.out.println("Enter contract #" + i + " data");
			System.out.print("Date: ");
			Date date = sdf.parse(sc.next());
			System.out.print("Value per Hour: ");
			double valuePerHour = sc.nextDouble();
			System.out.print("Duration: ");
			int hours = sc.nextInt();
			HourContract contract = new HourContract(date, valuePerHour, hours);
			worker.addContract(contract);
		}
		System.out.println();
		System.out.print("Enter moth and year to calculate income (MM/YYYY): ");
		String dateCalcular = sc.next();

		System.out.println();
		int moth_cc = Integer.parseInt(dateCalcular.substring(0, 2));
		int year_cc = Integer.parseInt(dateCalcular.substring(3));

		System.out.println("Name: " + worker.getName());
		System.out.println("Department: " + worker.getDepartment().getName());
		System.out.println("Income for " + dateCalcular + ": " + String.format("%.2f",worker.income(year_cc, moth_cc)));

		sc.close();
	}

}
