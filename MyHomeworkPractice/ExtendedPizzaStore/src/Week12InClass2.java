import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Week12InClass2 {

	public static void main(String[] args) throws IOException {
//		File file = new File("input.txt");
		File file = new File(args[0]);
		BufferedReader reader = new BufferedReader(new FileReader(file));
		
		String line = null;
		while((line = reader.readLine()) != null) {
			String[] words = line.split(" ");
			IngredientsFactory ingFact = null;
			if(words[1].equals("Chicago"))
				ingFact = new ChicagoIngredientsFactory();
			else if(words[1].equals("NY"))
				ingFact = new NYIngredientsFactory();
				
			Pizza pizza = null;
			if(words[0].equals("Cheese"))
				pizza = new CheesePizza(ingFact);
			else if(words[0].equals("Pepperoni"))
				pizza = new PepperoniPizza(ingFact);
			
			pizza.prepare();
		}
		
		reader.close();
	}

}
