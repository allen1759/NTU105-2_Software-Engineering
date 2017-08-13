
public class Soy extends Condiment {
	
	private final float cost = 0.1f;

	public Soy(Beverage beverage) {
		super(beverage);
	}

	@Override
	public float cost() {
		return beverage.cost() + cost;
	}

}
