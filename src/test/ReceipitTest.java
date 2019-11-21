package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import shoppingCart.Receipit;
import warehouse.Item;

class ReceipitTest {

	Receipit receipit = new Receipit();
	
	@Test
	void addAndPrintNoTaxItemtest() {
		
		Item item = Item.parseOrderToItem("1 book at 12.49");
		receipit.add(item);
		String expected = "1 book: 12.49\n" +
				"Sales Taxes: 0.00\n" + 
				"Total: 12.49";
		assertEquals(expected, receipit.printReceipit() );
	}
	
	@Test
	void addAndPrintBasicTaxItemtest() {
		
		Item item = Item.parseOrderToItem("1 music CD at 14.99");
		receipit.add(item);
		String expected = "1 music CD: 16.49\n" +
				"Sales Taxes: 1.50\n" + 
				"Total: 16.49";
		assertEquals(expected, receipit.printReceipit() );
	}
	
	@Test
	void addAndPrintImportDutyTaxItemtest() {
		
		Item item = Item.parseOrderToItem("1 imported box of chocolates at 10.00");
		receipit.add(item);
		String expected = "1 imported box of chocolates: 10.50\n" + 
				"Sales Taxes: 0.50\n" + 
				"Total: 10.50";
		assertEquals(expected, receipit.printReceipit() );
	}
	
	@Test
	void addAndPrintBasicAndImportDutyTaxItemtest() {
		
		Item item = Item.parseOrderToItem("1 imported bottle of perfume at 47.50");
		receipit.add(item);
		String expected = "1 imported bottle of perfume: 54.65\n" + 
				"Sales Taxes: 7.15\n" + 
				"Total: 54.65";
		assertEquals(expected, receipit.printReceipit() );
	}
	
	@Test
	void multipleItemtest() {
		
		Item item = Item.parseOrderToItem("1 book at 12.49");
		Item item2 = Item.parseOrderToItem("1 music CD at 14.99");
		Item item3 = Item.parseOrderToItem("1 chocolate bar at 0.85");
		receipit.add(item);
		receipit.add(item2);
		receipit.add(item3);
		String expected = "1 book: 12.49\n" + 
				"1 music CD: 16.49\n" + 
				"1 chocolate bar: 0.85\n" + 
				"Sales Taxes: 1.50\n" + 
				"Total: 29.83";
		assertEquals(expected, receipit.printReceipit() );
	}
	
}
