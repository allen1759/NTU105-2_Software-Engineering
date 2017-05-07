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
				GUICreator creator = null;
				LookAndFeelCreator styleCreator = null;
				switch(input[0]) {
					case "Present":
						app.present();
						break;
					case "Motif":
						styleCreator = new MotifCreator();
						app.switchStyle(styleCreator);
						break;
					case "PM":
						styleCreator = new PMCreator();
						app.switchStyle(styleCreator);
						break;
					case "Window":
						creator = new WindowCreator();
						app.createWidget(creator, input[1]);
						break;
					case "ScrollBar":
						creator = new ScrollBarCreator();
						app.createWidget(creator, input[1]);
						break;
					case "Button":
						creator = new ButtonCreator();
						app.createWidget(creator, input[1]);
						break;
					default:
						break;
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}