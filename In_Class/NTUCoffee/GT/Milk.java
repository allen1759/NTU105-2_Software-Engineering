
public class Milk extends Condiment{

	public Milk(Beverage thisBev) {
		super(thisBev);
		this.cost = 0.2f;
	}

	@Override
	public float calculate() {
		return (super.calculate() + this.cost);
	}

}