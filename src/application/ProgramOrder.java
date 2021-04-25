package application;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import entities.Clients;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import entities_enums.OrderStatus;

public class ProgramOrder {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter cliente data:");
		System.out.print("Name: ");
		String name = sc.nextLine();
		System.out.print("Email: ");
		String email = sc.nextLine();
		System.out.print("Birth date (DD/MM/YYYY):");
		String date = sc.nextLine();
		LocalDate br = LocalDate.parse(date, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		Clients clients = new Clients(name, email, br);

		System.out.println("Enter order data: ");
		System.out.print("Status:");
		OrderStatus status = OrderStatus.valueOf(sc.next());

		Order order = new Order(LocalDate.now(), status, clients);

		System.out.print("How many items to this order?");
		int item = sc.nextInt();
		for (int i = 0; i < item; i++) {
			System.out.println("Enter" + i + "item data:");
			System.out.print("Product name: ");
			String productName = sc.next();
			System.out.print("Product price: ");
			double productPrice = sc.nextDouble();

			Product product = new Product(productName, productPrice);
			System.out.print("Quantity: ");
			int quantity = sc.nextInt();
			OrderItem orderItem= new OrderItem(quantity, productPrice,product);
			order.addItem(orderItem);

		}
		
		System.out.println("ORDER SUMMARY: ");
		
		System.out.println(order);

		sc.close();

	}
}
