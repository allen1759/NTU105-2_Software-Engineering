public class TextDocumentCreator implements DocumentCreator {
	
	@Override
	public Document createDocument() {
		Document document = new TextDocument();
		return document;
	}
}