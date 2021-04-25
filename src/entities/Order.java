package entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import entities_enums.OrderStatus;

public class Order {

	private LocalDate moment;
	private OrderStatus status;
	private Clients client;

	private List<OrderItem> orderItens = new ArrayList<>();

	public Order() {

	}

	public Order(LocalDate moment, OrderStatus status, Clients client) {

		this.moment = moment;
		this.status = status;
		this.client = client;
	}

	public LocalDate getMoment() {
		return moment;
	}

	public void setMoment(LocalDate moment) {
		this.moment = moment;
	}

	public OrderStatus getStatus() {
		return status;
	}

	public void setStatus(OrderStatus status) {
		this.status = status;
	}

	public Clients getClient() {
		return client;
	}

	public void setClient(Clients client) {
		this.client = client;
	}

	public void addItem(OrderItem item) {
		orderItens.add(item);
	}

	public void removeItem(OrderItem item) {
		orderItens.remove(item);
	}

	public double total() {
		double total = 0;
		for (OrderItem t : orderItens) {
			total += t.subTotal();

		}
		return total;

	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Order moment: ");

		sb.append("Order status: ");
		sb.append(status + "\n");
		sb.append("Client: ");
		sb.append(client + "\n");
		sb.append("Order items:\n");
		for (OrderItem item : orderItens) {
			sb.append(item + "\n");
		}
		sb.append("Total price: $");
		sb.append(String.format("%.2f", total()));
		return sb.toString();
	}

}
