package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import shoppingCart.CashRegister;

class CashRegisterTest {

	public CashRegister cashRegister = new CashRegister();

	@Test
	public void sellOneNoTaxItem() {

		cashRegister.checkoutOrder("1 book at 12.49");

		String recipit = cashRegister.printReceipit();

		String expected = "1 book: 12.49\n" + "Sales Taxes: 0.00\n" + "Total: 12.49";
		assertEquals(expected, recipit);
	}

	@Test
	public void sellOneBasicTaxItem() {

		cashRegister.checkoutOrder("1 music CD at 14.99");

		String recipit = cashRegister.printReceipit();

		String expected = "1 music CD: 16.49\n" + "Sales Taxes: 1.50\n" + "Total: 16.49";
		assertEquals(expected, recipit);
	}

	@Test
	public void sellOneImportedItemTaxFree() {
		cashRegister.checkoutOrder("1 imported box of chocolates at 10.00");

		String recipit = cashRegister.printReceipit();

		String expected = "1 imported box of chocolates: 10.50\n" + "Sales Taxes: 0.50\n" + "Total: 10.50";
		assertEquals(expected, recipit);
	}

	@Test
	public void sellOneImportedItemWithAlsoStandardTax() {
		cashRegister.checkoutOrder("1 imported bottle of perfume at 47.50");

		String recipit = cashRegister.printReceipit();

		String expected = "1 imported bottle of perfume: 54.65\n" + "Sales Taxes: 7.15\n" + "Total: 54.65";
		assertEquals(expected, recipit);
	}

	@Test
	public void sellMultipleItem() {
		cashRegister.checkoutOrder("1 book at 12.49\n" + "1 music CD at 14.99\n" + "1 chocolate bar at 0.85\n");

		String recipit = cashRegister.printReceipit();

		String expected = "1 book: 12.49\n" + "1 music CD: 16.49\n" + "1 chocolate bar: 0.85\n" + "Sales Taxes: 1.50\n"
				+ "Total: 29.83";
		assertEquals(expected, recipit);
	}

}

