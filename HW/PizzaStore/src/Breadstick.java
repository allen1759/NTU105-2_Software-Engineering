
public class Breadstick extends Product {

	private String breadstick;
	
	public Breadstick(String breadstick) {
		this.breadstick = new String(breadstick);
	}

	@Override
	public String getDisplay() {
		// TODO Auto-generated method stub
		return breadstick + "\n";
	}
}
