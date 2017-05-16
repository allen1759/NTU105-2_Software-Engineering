import java.io.*;
import java.util.ArrayList;

public class Week11HW2 {
	public static void main(String[] args) {
		String fileName = args[0];

		FileReader fr;
		BufferedReader br;
		
		try {
			fr = new FileReader(fileName);
			br = new BufferedReader(fr);

			ArrayList<String> order = new ArrayList<String>();
			order.add("Window");
			order.add("ScrollBar");
			order.add("Button");

			GUIApplication app = new GUIApplication(order);
			String currentLine;
			while ((currentLine = br.readLine()) != null) {
				String[] input = currentLine.split("\\s");
				switch(input[0]) {
					case ("Present"):
						app.present();
						break;
					case ("Motif"):
						app.switchStyle("Motif");
						break;
					case ("PM"):
						app.switchStyle("PM");
						break;
					default:
						app.createWidget(input[0], input[1]);
						break;
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}