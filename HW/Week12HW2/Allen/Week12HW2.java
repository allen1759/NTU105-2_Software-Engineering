import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Week12HW2 {

	public static void main(String[] args) throws IOException {
//		File file = new File("input.txt");
		File file = new File(args[0]);
		BufferedReader reader = new BufferedReader(new FileReader(file));
		
		String line = null;
		Reader rtfReader = new Reader();
		while((line = reader.readLine()) != null) {
			if(line.equals("TeX")) {
				rtfReader.setConverter(new RTF2TexConverter());
				line = reader.readLine();
				rtfReader.convertText(line);
				System.out.println(rtfReader.getResult());
			}
			else if(line.equals("TextWidget")) {
				rtfReader.setConverter(new RTF2WidgetConverter());
				line = reader.readLine();
				rtfReader.convertText(line);
				System.out.println(rtfReader.getResult());
			}
		}
		
		reader.close();

	}

}
