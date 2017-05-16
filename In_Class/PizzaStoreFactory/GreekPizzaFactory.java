public class GreekPizzaFactory implements PizzaFactory{

	@Override
	public Pizza createPizza() {
		return (new GreekPizza());
	}
}