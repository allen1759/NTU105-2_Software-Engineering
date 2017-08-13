import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Week13InClass {

	public static void main(String[] args) throws IOException {
		File file = new File("input.txt");
//		File file = new File(args[0]);
		BufferedReader reader = new BufferedReader(new FileReader(file));
		
		String line = null;
		while((line = reader.readLine()) != null) {
			String[] words = line.split(" ");
		}
		
		reader.close();
	}

}
