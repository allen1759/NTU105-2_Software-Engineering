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
				DocumentCreator docCreator = null;
				switch (currentLine) {
					case "Draw":
						docCreator = new DrawingDocumentCreator();
						app.createDoc(docCreator);
						break;
					case "Text":
						docCreator = new TextDocumentCreator();
						app.createDoc(docCreator);
						break;
					case "Present":
						app.present();
						break;
					default:
						break;
				}
			}

		} catch(Exception e) {
			e.printStackTrace();
		}

		return;
	}
}