
public class Milk extends Condiment {
	
	private final float cost = 0.2f;

	public Milk(Beverage beverage) {
		super(beverage);
	}

	@Override
	public float cost() {
		return beverage.cost() + cost;
	}

}
