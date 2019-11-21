package taxes;

import static warehouse.Category.*;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import warehouse.Category;
import warehouse.Item;

public class TaxCalculator {

	private final int importedTax = 5;
	private List<Tax> taxes;

	public TaxCalculator() {
		// insert all taxes
		List<Tax> taxList = new ArrayList<>();
		Tax t = new TaxWithCategoryExceptions("basic", 10,
				new ArrayList<>(Arrays.asList(new Category[] { BOOK, FOOD, MEDICAL })));
		taxList.add(t);
		this.taxes = taxList;
	}

	public BigDecimal calculateTaxOnItem(Item item) {
		int taxRate = taxRatePerItem(item);
		BigDecimal price = item.getNetPrice();

		BigDecimal taxOnItem = price.divide(new BigDecimal(100)).multiply(new BigDecimal(taxRate));

		taxOnItem = roundToNearestFiveCent(taxOnItem);

		taxOnItem = taxOnItem.setScale(2, RoundingMode.HALF_UP);
		return taxOnItem;
	}

	private int taxRatePerItem(Item item) {
		int taxRate = 0;

		if (item.isImported()) {
			taxRate += importedTax;
		}
		for (Tax t : taxes) {
			if (t.applyToProduct(item)) {
				taxRate += t.getRate();
			} 
		} 
		return taxRate;

	}

	private BigDecimal roundToNearestFiveCent(BigDecimal num) {
		return num.multiply(new BigDecimal(20.00)).setScale(0, RoundingMode.UP).divide(new BigDecimal(20.00));
	}

}
