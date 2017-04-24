import java.util.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PrintWriter;
import java.io.IOException;

public class Website{

	public static Map<String, AccountData> accountsList;
	public static int confirmNum;
	public static Map<String, OrderData> order;
	public static Map<String, ProductData> pro;
	public static List<OrderData> paidOrders;
	public static List<String> accountInsertOrder;
	PrintWriter writer;

	Website(String outputFileName){
		accountsList = new HashMap<String, AccountData>();
		confirmNum = 1;
		order = new HashMap<String, OrderData>();
		pro = new HashMap<String, ProductData>();
		paidOrders = new ArrayList<OrderData>();
		accountInsertOrder = new ArrayList<String>();
		try{
			writer = new PrintWriter(outputFileName);
		}catch(IOException e){
			e.printStackTrace();
		}
	}

	public boolean bringUp(String customer){
		if(accountsList.containsKey(customer))				// A customer who has created an account.
			return true;						
		else												// A customer who hasn't created an account yet.
			return false;
	}

	public void showGreeting(String customer){
		writer.println("Welcome "+customer);
		writer.println("Your favorite pizza");
		for(Pizza p: accountsList.get(customer).favoritePizza){
			writer.print("pizza "+p.size+" "+p.crust);
			for(String s: p.toppings)
				writer.print(" "+s);
			writer.println();
		}
		writer.println("This week new pizza");
		writer.println("pizza 8 normal seafood");
		writer.flush();
	}

	public void setupAccount(String customer, String email){
		writer.println("Welcome new customer");
		writer.println("Please set up your account");
		writer.println("This week new pizza");
		writer.println("pizza 8 normal seafood");
		AccountData account = new AccountData();
		List<OrderData> tempOrder = new ArrayList<OrderData>();		
		accountsList.put(customer, account);
		account.email = email;
		account.order = tempOrder;
		accountInsertOrder.add(customer);
		writer.flush();
	}

	public void makeNewOrder(String customer){
		OrderData tempOrder = new OrderData();
		ProductData tempPro = new ProductData();
		order.put(customer, tempOrder);
		pro.put(customer, tempPro);
		order.get(customer).customer = customer;		
	}

	public void doSelectProduct(String customer, ArrayList<ArrayList<String>> orderProduct){
		for(ArrayList<String> sList: orderProduct){
			pro.get(customer).productList.add(sList);
			if(sList.get(0).equals("pizza")){
				Pizza pi = new Pizza();
				pi.size = Integer.parseInt(sList.get(1));
				pi.crust = sList.get(2);
				for(int i = 3; i < sList.size(); i++)
					pi.toppings.add(sList.get(i));

				boolean flag = false;									// add favorite pizza.
				for(Pizza p: accountsList.get(customer).favoritePizza){
					if(p.equals(pi)){
						flag = true;
						break;
					}
				}
				if(!flag){
					accountsList.get(customer).favoritePizza.add(pi);
				}
			}
		}
	}

	public void doSelectDeliveryMechanism(String customer, String deliveryMechanism){
		order.get(customer).deliveryMechanism = deliveryMechanism;
	}

	public void doSelectDeliveryTime(String customer, String deliveryTime){
		order.get(customer).deliveryTime = deliveryTime;
	}

	public void processPay(String customer){
		order.get(customer).product = pro.get(customer);
		writer.println(customer+" gets Confirmation Number:"+confirmNum);
		order.get(customer).confirmNum = confirmNum;
		confirmNum++;
		writer.println(customer+" gets an email confirmation in "+accountsList.get(customer).email);
		paidOrders.add(order.get(customer));
		writer.flush();
	}

	public void customerExit(String customer){
		accountsList.get(customer).order.add(order.get(customer));
		order.remove(customer);
		pro.remove(customer);
	}

	public void showPaidOrders(){
		for(OrderData order: paidOrders){
			writer.println("Confirmation Number:"+order.confirmNum);
			writer.println("Customer:"+order.customer);
			writer.println("Products:");
			for(ArrayList<String> pro: order.product.productList){
				if(pro.get(0).equals("pizza")){
					writer.print("pizza "+pro.get(1)+" "+pro.get(2));
					for(int i = 3 ; i < pro.size(); i++)
					writer.print(" "+pro.get(i));
					writer.println();
				}
				else if(pro.get(0).equals("salad")){
					writer.print("salad");
					for(int i = 1; i < pro.size(); i++)
						writer.print(" "+pro.get(i));
					writer.println();
				}
				else if(pro.get(0).equals("breadstick")){
					writer.println(pro.get(0));
				}
				else if(pro.get(0).equals("drink")){
					writer.println(pro.get(0));
				}
			}		
			writer.println("DeliveryMechanism:"+order.deliveryMechanism);
			writer.println("DeliveryTime:"+order.deliveryTime);
		}
		writer.flush();
	}

	public void showAccounts(){
		for(String customer : accountInsertOrder){
			writer.println(customer+" "+accountsList.get(customer).email);
		}
		writer.flush();
	}

	private class OrderData{
		private ProductData product;
		String deliveryMechanism;
		String deliveryTime;
		int confirmNum;
		String customer;
	}

	private class ProductData{
		private ArrayList<ArrayList<String>> productList = new ArrayList<ArrayList<String>>();
	}

	public class AccountData{
		private String email;
		private List<OrderData> order = new ArrayList<OrderData>();
		private List<Pizza> favoritePizza = new ArrayList<Pizza>();

	}

	private class Pizza{
		int size;
		String crust;
		List<String> toppings = new ArrayList<String>();

		@Override
		public boolean equals(Object ob){
			Pizza that = (Pizza)ob;
			if(this.size == that.size && this.crust.equals(that.crust)){
				if(this.toppings.size() == that.toppings.size()){
					for(int i = 0 ; i < this.toppings.size(); i++){
						if(!this.toppings.get(i).equals(that.toppings.get(i)))
							return false;
					}
					return true;
				}
			}
			else
				return false;

			return false;
		}
	}

}