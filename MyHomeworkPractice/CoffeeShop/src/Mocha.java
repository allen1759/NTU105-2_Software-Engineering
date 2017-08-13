
public class Mocha extends Condiment {

	private final float cost = 0.25f;

	public Mocha(Beverage beverage) {
		super(beverage);
	}

	@Override
	public float cost() {
		return beverage.cost() + cost;
	}

}
