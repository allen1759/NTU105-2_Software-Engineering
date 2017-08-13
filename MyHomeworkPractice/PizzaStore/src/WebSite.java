import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.TreeSet;

public class WebSite {

	private int currConfirmNumber = 0;
	
	private PrintWriter pw;
	private TreeSet<Order> orders = new TreeSet<Order>();
	private HashMap<String, Order> pendingOrders = new HashMap<String, Order>();
	private Order currOrder = null;
	private ArrayList<Account> accounts = new ArrayList<Account>();
	
	public WebSite(String filePath) throws FileNotFoundException {
		File file = new File(filePath);
		pw = new PrintWriter(file);
	}
	
	public void greeting(Account account) {
		pw.println("Welcome " + account.getCustomerName());
		pw.println("Your favorite pizza");
		pw.print(account.getFavorPizza());
		showNewPizza();
		pendingOrders.put(account.getCustomerName(), new Order(account.getCustomerName()));
		addAccount(account);
	}
	
	public void setUpAccout() {
		pw.println("Welcome new customer");
		pw.println("Please set up your account");
		showNewPizza();
	}
	
	private void showNewPizza() {
		pw.println("This week new pizza");
		pw.println("pizza 8 normal seafood");
	}

	public void selectProduct(String words[]) {
		currOrder.AddProduct(words);
	}

	public void selectDeliveryMechanism(String mechanism) {
		currOrder.SelectDeliveryMechanism(mechanism);
	}

	public void selectDeliveryTime(String time) {
		currOrder.SelectDeliveryTime(time);
	}

	public void payByCreditCard() {
		currOrder.setConfirmationNum(++currConfirmNumber);
		pw.print(currOrder.getConfirmNumDisplay());
	}

	public void sendConfirmationMail(Account account) {
		pw.print(currOrder.getCongirmEmailDisplay(account.getEmailAddress()));
		account.addFavorPizza(currOrder);
		orders.add(currOrder);
		pendingOrders.remove(currOrder);
//		addAccount(account);
	}
	
	public void customerExit() {
		pendingOrders.remove(currOrder);
		pw.flush();
	}

	public Account findAccount(String name) {
		for (Account acco : accounts) {
			if(acco.hasEqualName(name))
				return acco;
		}
		return null;
	}
	
	public void selectOrder(String customerName) {
		currOrder = pendingOrders.get(customerName);
		if(currOrder == null) {
			currOrder = new Order(customerName);
			pendingOrders.put(customerName, currOrder);
		}
	}

	public void addAccount(Account newAccount) {
		if(!accounts.contains(newAccount))
			accounts.add(newAccount);
	}

	public int GetNextConfirmNumber() {
		return ++currConfirmNumber;
	}

	public void listPaidOrders() {
		for (Order order : orders) {
			pw.print(order.getDisplay());
		}
		pw.flush();
	}

	public void listAccounts() {
		for (Account acco: accounts) {
			pw.print(acco.getDisplay());
		}
		pw.flush();
	}
}
