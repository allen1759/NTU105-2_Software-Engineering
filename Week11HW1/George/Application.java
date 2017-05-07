import java.util.ArrayList;

public class Application{

	protected ArrayList<Document> allDocuments;

	public Application(){
		allDocuments = new ArrayList<Document>();
	}

	public void createDocument(String type) {
		Document tmpDoc;
		switch(type) {
			case("Draw"):
				tmpDoc = new DrawingDocument();
				break;
			case("Text"):
				tmpDoc = new TextDocument();
				break;
			default:
				tmpDoc = null;
				break;
		}
		allDocuments.add(tmpDoc);
	}

	public void present() {
		for (int i=0; i<allDocuments.size(); i++) {
			System.out.println(allDocuments.get(i).getType());
		}
	}
}