package shoppingCart;

import java.math.BigDecimal;
import java.util.ArrayList;

import taxes.TaxCalculator;
import warehouse.Item;

public class Receipit {

	private TaxCalculator taxCalculator;
	private ArrayList<Item> selledItems;
	private BigDecimal salesTaxes;
	private BigDecimal total;

	public Receipit() {

		this.taxCalculator = new TaxCalculator();
		this.selledItems = new ArrayList<Item>();
		this.salesTaxes = BigDecimal.ZERO;
		this.total = BigDecimal.ZERO;
	}

	public void add(Item item) {

		BigDecimal taxOnItem = taxCalculator.calculateTaxOnItem(item);
		BigDecimal grossPrice = calculateGrossPrice(item);

		selledItems.add(item);
		salesTaxes = salesTaxes.add(taxOnItem);
		total = total.add(grossPrice);
	}

	private BigDecimal calculateGrossPrice(Item item) {
		BigDecimal taxOnItem = taxCalculator.calculateTaxOnItem(item);
		BigDecimal grossPrice = item.getNetPrice().add(taxOnItem);

		return grossPrice;
	}

	public String printReceipit() {
		String recipit = "";

		for (Item item : selledItems) {
			recipit += printItemOnReceipit(item);
		}

		recipit += "Sales Taxes: " + salesTaxes + "\n";
		recipit += "Total: " + total;

		return recipit;
	}

	private String printItemOnReceipit(Item item) {
		String recipit = item.getQuantity() + " " + importedPrint(item) + item.getProductName() + ": "
				+ calculateGrossPrice(item) + "\n";
		return recipit;
	}

	private String importedPrint(Item item) {
		if (item.isImported()) {
			return "imported ";
		}
		return "";
	}
}
