public class DrawingDocumentCreator implements DocumentCreator {
	
	@Override
	public Document createDocument() {
		Document document = new DrawingDocument();
		return document;
	}
}