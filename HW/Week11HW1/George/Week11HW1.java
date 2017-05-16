import java.io.*;

public class Week11HW1 {
	public static void main(String[] args) {
		String inputFilename = args[0];
		FileReader fr;
		BufferedReader br;

		try {
			fr = new FileReader(inputFilename);
			br = new BufferedReader(fr);

			String currentLine;
			Application app = new Application();

			while ((currentLine = br.readLine()) != null) {
				switch (currentLine) {
					case "Present":
						app.present();
						break;
					default:
						app.createDocument(currentLine);
						break;
				}
			}

		} catch(Exception e) {
			e.printStackTrace();
		}

		return;
	}
}