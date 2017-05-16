
public abstract class Condiment extends Beverage{

	protected Beverage thisBev;

	public Condiment(Beverage thisBev) {
		this.thisBev = thisBev;
	}

	public float calculate() {
		return this.thisBev.cost;
	}

}