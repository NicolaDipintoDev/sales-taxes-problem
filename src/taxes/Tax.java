package taxes;

import warehouse.Item;

public abstract class Tax {

	private String name;
	private double rate;

	public Tax(String name, double rate) {
		this.name = name;
		this.rate = rate;
	}

	public double getRate() {
		return this.rate;
	}

	abstract boolean applyToProduct(Item i);

}
