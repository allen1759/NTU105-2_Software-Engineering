
public abstract class MenuItem {

	private Scrapbook scrapbook;
	private Document document;
	
	public MenuItem(Scrapbook scrapbook, Document document) {
		this.scrapbook = scrapbook;
		this.document = document;
	}
	
	abstract public void Operate();
}
