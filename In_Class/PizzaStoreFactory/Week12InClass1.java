import java.io.*;

public class Week12InClass1{
	public static void main(String[] args) throws IOException{
		FileReader fr = new FileReader(args[0]);
		BufferedReader br = new BufferedReader(fr);

		String currentLine;
		PizzaStore store = new PizzaStore(new CheesePizzaFactory(), new GreekPizzaFactory(), new PepperoniPizzaFactory());

		while ((currentLine = br.readLine()) != null) {
			String[] inputs = currentLine.split("\\s");

			switch(inputs[0]) {
				case "Create":
					PizzaFactory factory = null;
					if (inputs[1].equals("Cheese"))
						factory = new CheesePizzaFactory();
					else if (inputs[1].equals("Greek"))
						factory = new GreekPizzaFactory();
					else if (inputs[1].equals("Pepperoni"))
						factory = new PepperoniPizzaFactory();
					if ( !store.createPizza(factory) ) {
						System.out.println("PizzaStore doesn't provide this kind of pizza now.");
					}
					break;
				case "RemoveUnpopularPizza":
					if (inputs[1].equals("Cheese"))
						store.removeUnpopularPizza(new CheesePizza());
					else if (inputs[1].equals("Greek"))
						store.removeUnpopularPizza(new GreekPizza());
					else if (inputs[1].equals("Pepperoni"))
						store.removeUnpopularPizza(new PepperoniPizza());
					break;
				case "AddNewFlavorPizza":
					if (inputs[1].equals("Cheese"))
						store.addNewFlavorPizza(new CheesePizza());
					else if (inputs[1].equals("Greek"))
						store.addNewFlavorPizza(new GreekPizza());
					else if (inputs[1].equals("Pepperoni"))
						store.addNewFlavorPizza(new PepperoniPizza());
					break;
				default:
					break;
			}
		}
	}
}