
public class Mocha extends Condiment{

	public Mocha(Beverage thisBev) {
		super(thisBev);
		this.cost = 0.25f;
	}

	@Override
	public float calculate() {
		return (super.calculate() + this.cost);
	}

}