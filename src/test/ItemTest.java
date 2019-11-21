package test;

import static org.junit.jupiter.api.Assertions.*;
import static warehouse.Category.*;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;

import warehouse.Item;
class ItemTest {

		@Test
		public void parseOneImportedItemTest() {
			
			Item item = Item.parseOrderToItem("1 imported box of chocolates at 10.00");
			
			assertEquals("1", item.getQuantity());
			assertEquals("box of chocolates", item.getProductName());
			assertEquals(new BigDecimal("10.00"), item.getNetPrice());
			assertEquals(true, item.isImported());
			assertEquals(FOOD, item.getCategory());
			
		}
		
		@Test
		public void parseOneItemTest() {
			
			Item item = Item.parseOrderToItem("1 box of chocolates at 10.00");
			
			assertEquals("1", item.getQuantity());
			assertEquals("box of chocolates", item.getProductName());
			assertEquals(new BigDecimal("10.00"), item.getNetPrice());
			assertEquals(false, item.isImported());
			assertEquals(FOOD, item.getCategory());
			
		}

}