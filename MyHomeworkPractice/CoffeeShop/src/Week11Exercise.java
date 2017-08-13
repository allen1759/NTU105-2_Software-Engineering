import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Week11Exercise {

	public static void main(String[] args) throws IOException {

		String inputFileName = args[0];
		FileReader fr = new FileReader(inputFileName);
//		FileReader fr = new FileReader("input.txt");
		BufferedReader br = new BufferedReader(fr);


        String currentLine = new String();
        while((currentLine = br.readLine()) != null) {
            String[] input = currentLine.split("\\s");
            String coffee = input[0];

            Beverage beverage = null;
            if(coffee.equals("HouseBlend"))
            	beverage = new HouseBlend();
            else if(coffee.equals("DarkRoast"))
            	beverage = new DarkRoast();
            else if(coffee.equals("Decaf"))
            	beverage = new Decaf();
            else if(coffee.equals("Espresso"))
            	beverage = new Espresso();
            
            for(int i=1; i<input.length; i+=1) {
            	if(input[i].equals("Milk"))
            		beverage = new Milk(beverage);
            	else if(input[i].equals("Soy"))
            		beverage = new Soy(beverage);
            	else if(input[i].equals("Mocha"))
            		beverage = new Mocha(beverage);
            }
            
            System.out.println("price: " + Float.toString(beverage.cost()));
        }
        br.close();
	}

}
