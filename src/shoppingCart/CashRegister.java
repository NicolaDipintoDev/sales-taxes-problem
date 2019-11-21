package shoppingCart;

import java.util.Scanner;

import warehouse.Item;

public class CashRegister {

	private Receipit receipit;

	public CashRegister() {

		this.receipit = new Receipit();
	}

	public void checkoutOrder(String order) {
		Scanner scanner = new Scanner(order);
		while (scanner.hasNextLine()) {
			String itemOrder = scanner.nextLine();
			checkoutItem(itemOrder);
		}
		scanner.close();
	}

	private void checkoutItem(String order) {

		Item item = Item.parseOrderToItem(order);
		receipit.add(item);
	}

	public String printReceipit() {
		return receipit.printReceipit();
	}

}

