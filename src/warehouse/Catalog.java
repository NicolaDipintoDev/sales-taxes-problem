package warehouse;

import static warehouse.Category.*;

import java.util.HashMap;
import java.util.Map;

public class Catalog {

	private final Map<String, Category> catalog = new HashMap<String, Category>();

	public Catalog() {
		catalog.put("book", BOOK);
		catalog.put("music CD", OTHER);
		catalog.put("box of chocolates", FOOD);
		catalog.put("bottle of perfume", OTHER);
		catalog.put("packet of headache pills", MEDICAL);
		catalog.put("chocolate bar", FOOD);
	}

	public Category getCategory(String productName) {
		return catalog.get(productName);
	}

}
