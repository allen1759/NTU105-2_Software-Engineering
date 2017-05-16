import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Week11Exercise {
	
	public static void main(String[] args) throws IOException {
		String inputFileName = args[0];
		FileReader     fr = new FileReader(inputFileName);
		BufferedReader br = new BufferedReader(fr);

		String currentLine = new String();
            while((currentLine = br.readLine()) != null) {

                  String[] input = currentLine.split("\\s");

                  Beverage thisBev = null;
          //        Condiment thisCondiment;
                  if(input[0].equals("HouseBlend")) {
                  	thisBev = new HouseBlend();
          //        	thisCondiment = new HouseBlend(thisBev);
                  }
                  else if (input[0].equals("DarkRoast")) {
                  	thisBev = new DarkRoast();
          //        	thisCondiment = new DarkRoast(thisBev);
                  }
                  else if (input[0].equals("Decaf")) {
                  	thisBev = new Decaf();
          //        	thisCondiment = new Decaf(thisBev);
                  }
                  else if (input[0].equals("Espresso")) {
                  	thisBev = new Espresso();
          //        	thisCondiment = new Espresso(thisBev);
                  }

                  // add condiments
                  for (int i=1; i<input.length; i++) {
                  	
                  	if (input[i].equals("Milk")) {
                  		thisBev = new Milk(thisBev);
                  	}
                  	else if (input[i].equals("Soy")) {
                  		thisBev = new Soy(thisBev);
                  	}
                  	else if (input[i].equals("Mocha")) {
                  		thisBev = new Mocha(thisBev);
                  	}
                  }
                  // price: 1.3800000000000001
                  System.out.println("price: "+thisBev.calculate());
            }
        br.close();
	}

}