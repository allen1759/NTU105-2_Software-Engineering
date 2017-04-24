import java.util.ArrayList;

public class Order implements Comparable<Order> {

	private int confirmNumber;
	private String customName;
	
	private String deliveryMechanism;
	private String deliveryTime;
	private ArrayList<Product> products = new ArrayList<Product>();
	
	public Order(String name) {
		this.customName = name;
	}

//	public String getCustomerName() {
//		return customName;
//	}
	
	@Override
	public int compareTo(Order rhs) {
		// TODO Auto-generated method stub
        return confirmNumber - rhs.confirmNumber;
	}
	
	public void AddProduct(String words[]) {
		if(words[0].equals("pizza")) {
			products.add(new Pizza(words));
		}
		else if(words[0].equals("salad")) {
			products.add(new Salad(words));
		}
		else if(words[0].equals("breadstick")) {
			products.add(new Breadstick(words[0]));
		}
		else if(words[0].equals("drink")) {
			products.add(new Drink(words[0]));
		}
	}
	
	public void SelectDeliveryMechanism(String mechanism) {
		deliveryMechanism = mechanism;
	}
	
	public void SelectDeliveryTime(String time) {
		deliveryTime = time;
	}
	
	public void setConfirmationNum(int num) {
		confirmNumber = num;
	}
	
	public String getConfirmNumDisplay() {
		return customName + " gets Confirmation Number:" + Integer.toString(confirmNumber) + "\n";
	}
	
	public String getCongirmEmailDisplay(String email) {
		return customName + " gets an email confirmation in " + email + "\n";
	}

	public ArrayList<Pizza> getPizzaList() {
		ArrayList<Pizza> list = new ArrayList<Pizza>();;
		for(Product product : products)
			if(product instanceof Pizza)
				list.add((Pizza)product);
		return list;
	}
	
	public String getDisplay() {
		String ret = new String();
		ret += "Confirmation Number:" + Integer.toString(confirmNumber) + "\n";
		ret += "Customer:" + customName + "\n";
		ret += "Products:" + "\n";
		for(Product product : products)
			ret += product.getDisplay();
		ret += "DeliveryMechanism:" + deliveryMechanism + "\n";
		ret += "DeliveryTime:" + deliveryTime + "\n";
		
		return ret;
	}
}
