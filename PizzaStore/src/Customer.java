import java.util.ArrayList;

public class Customer {

	private String customerName;
	private Account account;
	
	public Customer(String customerName) {
		this.customerName = new String(customerName);
	}
	
	void bringUp(WebSite webSite) {
		account = webSite.findAccount(customerName);
		if(account != null)
			webSite.greeting(account);
		else
			webSite.setUpAccout();
	}
	
	void setUp(WebSite webSite, String email) {
		account = new Account(customerName, email);
		webSite.addAccount(account);
	}
	
	void order(WebSite webSite, String command[], ArrayList<String> parameters) {
		webSite.selectOrder(customerName);
		
        if(command[1].equals("pay")) {
        	webSite.payByCreditCard();
        	webSite.sendConfirmationMail(account);
        }
        else if(command[1].equals("selectProduct")) {
        	for(String line : parameters)
        		webSite.selectProduct(line.split(" "));
        }	
        else if(command[1].equals("selectDeliveryMechanism")) {
        	webSite.selectDeliveryMechanism(parameters.get(0));
        }
        else if(command[1].equals("selectDeliveryTime")) {
        	webSite.selectDeliveryTime(parameters.get(0));
        }
	}
	
	void exit(WebSite webSite) {
		webSite.selectOrder(customerName);
		webSite.customerExit();
	}
	
}
