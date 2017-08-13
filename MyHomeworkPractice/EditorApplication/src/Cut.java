
public class Cut extends MenuItem {

	public Cut(Scrapbook scrapbook, Document document) {
		super(scrapbook, document);
	}

	@Override
	public void Operate() {
		System.out.println("Cut~");
	}

}
