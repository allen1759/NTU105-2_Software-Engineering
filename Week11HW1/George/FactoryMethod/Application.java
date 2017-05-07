import java.util.ArrayList;

public class Application{

	protected ArrayList<Document> allDocuments;

	public Application(){
		this.allDocuments = new ArrayList<Document>();
	}

	public void createDoc(DocumentCreator docCreator) {
		allDocuments.add(docCreator.createDocument());
	}

	public void present() {
		for (int i=0; i<allDocuments.size(); i++) {
			System.out.println(allDocuments.get(i).getType());
		}
	}
}