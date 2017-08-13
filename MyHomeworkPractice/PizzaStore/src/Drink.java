
public class Drink extends Product {

	private String drink;

	public Drink(String drink) {
		this.drink = new String(drink);
	}

	@Override
	public String getDisplay() {
		// TODO Auto-generated method stub
		return drink + "\n";
	}

}
