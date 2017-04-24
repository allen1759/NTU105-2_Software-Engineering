import java.util.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Week8HW{

	public static Website web;
	public static FileReader fr;
	public static BufferedReader br;

	public static void main(String args[]){
		String inputFileName = args[0];
		String outputFileName = args[1];
		web = new Website(outputFileName);

		try{
			fr = new FileReader(inputFileName);
			br = new BufferedReader(fr);
			String currentLine = new String();

			while((currentLine = br.readLine()) != null){
				String[] command = currentLine.split("\\s");
				if(command.length == 2){									// User command.
					String customer = command[0];
					if(command[1].equals("selectProduct")){					// select the products.
						String[] temp = selectProduct(customer).split("\\s");
						customer = temp[0];
						command[1] = temp[1];				

					}
					if(command[1].equals("bringUp")){					// A customer brings up.
						if(web.bringUp(customer))							// A customer who has created an account.
							web.showGreeting(customer);
						else{
							String setupCommand = br.readLine();
							String email = br.readLine();
							web.setupAccount(customer, email);				// A new customer starts setting up a new account.
						}
						web.makeNewOrder(customer);
					}
					else if(command[1].equals("selectDeliveryMechanism")){		// select the delivery mechanism.
						selectDeliveryMechanism(customer);						
					}
					else if(command[1].equals("selectDeliveryTime")){		// select the delivery time.
						selectDeliveryTime(customer);						
					}
					else if(command[1].equals("pay")){						// pay for the order.
						web.processPay(customer);
					}
					else if(command[1].equals("exit")){						// end the order process.
						web.customerExit(customer);	
					}
				}
				else{														// Extra command.
					if(command[0].equals("listPaidOrders")){
						web.showPaidOrders();
					}
					else if(command[0].equals("listAccounts")){
						web.showAccounts();
					}
				}
			}
		
		}catch(IOException e){
			e.printStackTrace();
		}finally{
			web.writer.close();
		}

	}

	public static String selectProduct(String customer){				// select the products.
		ArrayList<ArrayList<String>> product = new ArrayList<ArrayList<String>>();
		String temp = new String();
		try{
			while((temp = br.readLine()) != null){
				ArrayList<String> items = new ArrayList<String>(Arrays.asList(temp.split("\\s")));
				if(items.size() > 1 && !(items.get(0).equals("pizza") || items.get(0).equals("salad")
				   || items.get(0).equals("breadstick") || items.get(0).equals("drink"))){
					break;
				}
				product.add(items);
			}
		}catch(IOException e){e.printStackTrace();}
		web.doSelectProduct(customer, product);
		return temp;
	}

	public static void selectDeliveryMechanism(String customer){
		String deliveryMechanism = new String();			// select the delivery mechanism.
		try{
			deliveryMechanism = br.readLine();
		}catch(IOException e){e.printStackTrace();}
		web.doSelectDeliveryMechanism(customer, deliveryMechanism);
	}

	public static void selectDeliveryTime(String customer){		// select the delivery time.
		String deliveryTime = new String();
		try{
			deliveryTime = br.readLine();
		}catch(IOException e){e.printStackTrace();}
		web.doSelectDeliveryTime(customer, deliveryTime);
	}
}