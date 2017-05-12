import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Week12HW1 {

	public static void main(String[] args) throws IOException {
//		File file = new File("input.txt");
		File file = new File(args[0]);
		BufferedReader reader = new BufferedReader(new FileReader(file));
		
		String line = null;
		ChocolateBoiler chocolateBoiler = null;
		Chocolate chocolate = null;
		while((line = reader.readLine()) != null) {
			chocolateBoiler = ChocolateBoiler.getInstance();
			if(line.equals("Fill"))
				chocolateBoiler.fill(new Chocolate());
			else if(line.equals("Boil"))
				chocolateBoiler.boil();
			else if(line.equals("Drain"))
				chocolate = chocolateBoiler.drain();
		}

		reader.close();
	}

}
