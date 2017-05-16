

public abstract class Beverage {

	protected float cost;

	public abstract float calculate();

	public void setCost(float tmpCost) {
		this.cost = tmpCost;
		return;
	}

	public float getCost() {
		return this.cost; 
	}

} 