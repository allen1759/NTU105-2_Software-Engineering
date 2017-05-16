public abstract class Document {
	protected String type;

	public void printType() {
		System.out.println(type);
	}

	public String getType() {
		return type;
	}
}