public class TextDocumentCreator implements DocumentCreator {
	private Document myDocument;
	
	@Override
	public Document createDocument() {
		myDocument = new TextDocument();
		return myDocument;
	}
}