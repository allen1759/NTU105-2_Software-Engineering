public class CheesePizzaFactory implements PizzaFactory{

	@Override
	public Pizza createPizza() {
		return (new CheesePizza());
	}
}