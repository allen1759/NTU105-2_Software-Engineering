
public class Soy extends Condiment{

	public Soy(Beverage thisBev) {
		super(thisBev);
		this.cost = 0.1f;
	}

	@Override
	public float calculate() {
		return (super.calculate() + this.cost);
	}

}