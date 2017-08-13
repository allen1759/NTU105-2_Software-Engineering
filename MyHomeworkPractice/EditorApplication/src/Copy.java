
public class Copy extends MenuItem {

	public Copy(Scrapbook scrapbook, Document document) {
		super(scrapbook, document);
	}

	@Override
	public void Operate() {
		System.out.println("Copying");
	}

}
