public class DrawingDocumentCreator implements DocumentCreator {
	private Document myDocument;
	
	@Override
	public Document createDocument() {
		myDocument = new DrawingDocument();
		return myDocument;
	}
}