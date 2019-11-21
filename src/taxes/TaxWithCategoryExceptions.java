package taxes;

import java.util.List;

import warehouse.Category;
import warehouse.Item;

public class TaxWithCategoryExceptions extends Tax {

	private List<Category> exceptions;

	public TaxWithCategoryExceptions(String name, double rate, List<Category> exceptions) {
		super(name, rate);
		this.exceptions = exceptions;

	}

	public List<Category> getExceptions() {

		return this.exceptions;

	}

	public boolean applyToProduct(Item i) {
		if (this.getExceptions().contains(i.getCategory())) {
			return false;
		}
		return true;
	}

}
