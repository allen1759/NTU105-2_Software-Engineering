import java.util.ArrayList;

public class Application{

	private ArrayList<Document> documents;

	public Application() {
		documents = new ArrayList<Document>();
	}

	public void createDoc(DocumentCreator docCreator) {
		Document tmpDoc = docCreator.createDocument();
		documents.add(tmpDoc);
	}

	public void present() {
		for (Document doc : documents) {
			doc.printType();
		}
	}

	public void manage() {
	}
}