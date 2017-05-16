
public class Chocolate {

	private boolean isBoiled;
	
	public Chocolate() {
		isBoiled = false;
	}
	
	public boolean boil() {
		if(!isBoiled) {
			isBoiled = true;
			return true;
		}
		return false;
	}
	
	public boolean isBoiled() {
		return isBoiled;
	}
}
