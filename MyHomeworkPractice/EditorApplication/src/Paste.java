
public class Paste extends MenuItem {

	public Paste(Scrapbook scrapbook, Document document) {
		super(scrapbook, document);
	}

	@Override
	public void Operate() {
		System.out.println("Paste Done");
	}

}
