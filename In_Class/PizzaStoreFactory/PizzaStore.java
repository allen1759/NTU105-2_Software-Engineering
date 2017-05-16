import java.util.*;

public class PizzaStore{

	private HashMap<Pizza, Integer> havePizza;

	public PizzaStore(PizzaFactory... creators) {
		havePizza = new HashMap<Pizza, Integer>();
		for (PizzaFactory creator : creators) {
			Pizza tmp = creator.createPizza();
			havePizza.put(tmp, 1);
			System.out.println(havePizza.get(tmp)+"-");
		}
	}

	public boolean createPizza(PizzaFactory creator){
		Pizza tmpPizza = creator.createPizza();
		if (havePizza.get(tmpPizza) == 1) {
			System.out.println("Prepare "+tmpPizza.getType()+" Pizza");
			tmpPizza.bake();
			tmpPizza.cut();
			tmpPizza.box();
			return true;
		}
		return false;
	}

	public void removeUnpopularPizza(Pizza myPizza) {
		havePizza.put(myPizza, 0);
	}

	public void addNewFlavorPizza(Pizza myPizza) {
		havePizza.put(myPizza, 1);
	}
}