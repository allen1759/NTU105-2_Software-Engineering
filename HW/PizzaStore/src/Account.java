import java.util.ArrayList;

public class Account {

	private String customerName;
	private String emailAddress;
	private ArrayList<Pizza> favoritePizza;
	
	public Account(String customerName, String emailAddress) {
		this.customerName = customerName;
		this.emailAddress = emailAddress;
		favoritePizza = new ArrayList<Pizza>();
	}
	
	public String getCustomerName() {
		return customerName;
	}
	
	public String getEmailAddress() {
		return emailAddress;
	}
	
	public String getDisplay() {
		return customerName + " " + emailAddress + "\n";
	}
	
	public void addFavorPizza(Order order) {
		for(Pizza pizza : order.getPizzaList()) {
			boolean isEqual = false;
			for(Pizza favor : favoritePizza)
				if(pizza.equals(favor)) {
					isEqual = true;
					break;
				}
			if(!isEqual)
				favoritePizza.add(pizza);
		}
	}

	public String getFavorPizza() {
		String ret = new String();
		for(Pizza pizza : favoritePizza) {
			ret += pizza.getDisplay();
		}
		return ret;
	}
	
	public boolean hasEqualName(String name) {
		return customerName.equals(name);
	}
}
