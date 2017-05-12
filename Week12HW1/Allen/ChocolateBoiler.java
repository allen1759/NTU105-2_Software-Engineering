
public class ChocolateBoiler {

	private static ChocolateBoiler chocolateBoiler = null;
	
	private boolean isEmpty;
	private Chocolate chocolate;
	
	public static ChocolateBoiler getInstance() {
		if(chocolateBoiler == null)
			chocolateBoiler = new ChocolateBoiler();
		return chocolateBoiler;
	}
	
	private ChocolateBoiler() {
		isEmpty = true;
		chocolate = null;
	}
	
	public void fill(Chocolate chocolate) {
		if(isEmpty) {
			System.out.println("Fill chocolate");
			this.chocolate = chocolate;
			isEmpty = false;
		}
	}
	
	public void boil() {
		if(chocolate != null && !chocolate.isBoiled()) {
			System.out.println("Boil chocolate");
			chocolate.boil();
		}
	}
	
	public Chocolate drain() {
		if(chocolate != null && chocolate.isBoiled()) {
			System.out.println("Drain the boiled chocolate");
			Chocolate ret = chocolate;
			chocolate = null;
			isEmpty = true;
			return ret;
		}
		return null;
	}
}
