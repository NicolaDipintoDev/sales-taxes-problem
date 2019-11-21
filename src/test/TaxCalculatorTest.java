package test;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;


import org.junit.jupiter.api.Test;

import taxes.TaxCalculator;
import warehouse.Item;

class TaxCalculatorTest {

private TaxCalculator taxCalculator = new TaxCalculator();;
	
	
	@Test
	void noTaxTest() {
		
		Item item = Item.parseOrderToItem("1 box of chocolates at 3.61");
		
		assertEquals(new BigDecimal("0.00"), taxCalculator.calculateTaxOnItem(item));
	}
	
	@Test
	void BasicTaxTest() {
		
		Item item = Item.parseOrderToItem("1 bottle of perfume at 18.99");
		
		assertEquals(new BigDecimal("1.90"), taxCalculator.calculateTaxOnItem(item) );
	}
	
	@Test
	void ImportDutyTaxTest() {
		
		Item item = Item.parseOrderToItem("1 imported box of chocolates at 10.00");
		
		assertEquals(new BigDecimal("0.50"), taxCalculator.calculateTaxOnItem(item) );
	}
	
	@Test 
	void BasicAndImportDutyTaxTest() {
		
		Item item = Item.parseOrderToItem("1 imported bottle of perfume at 47.50");
		
		assertEquals(new BigDecimal("7.15"), taxCalculator.calculateTaxOnItem(item) );
	}
	
	
	

}

