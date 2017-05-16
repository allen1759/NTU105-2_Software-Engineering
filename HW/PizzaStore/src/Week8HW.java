import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Week8HW {

	public static void main(String args[]) throws IOException {
		
//		File file = new File("TestCase/testCase9.in");
		File file = new File(args[0]);
		BufferedReader reader = new BufferedReader(new FileReader(file));

//		WebSite momoWebsite = new WebSite("TestCase/output.txt");
		WebSite momoWebsite = new WebSite(args[1]);
		HashMap<String, Customer> customers = new HashMap<String, Customer>();
		
		String line = reader.readLine();
		while( line != null ) {
			String words[] = line.split(" ");

			if(words.length == 2 && words[1].equals("bringUp")) {
				Customer customer = customers.get(words[0]);;
				if(customer == null) {
					customer = new Customer(words[0]);
					customers.put(words[0], customer);
				}
				customer.bringUp(momoWebsite);
				line = reader.readLine();
			}
			else if(words.length == 2 && words[1].equals("setUp")) {
				line = reader.readLine();
				customers.get(words[0]).setUp(momoWebsite, line); 
				line = reader.readLine();
			}
			else if(words.length == 2 && words[1].equals("exit")) {
				customers.get(words[0]).exit(momoWebsite);
				customers.remove(words[0]);
				line = reader.readLine();
			}
			else if(words.length == 2 ) {
				ArrayList<String> parameters = new ArrayList<String>();
				while( (line = reader.readLine()) != null && !isCommand(line)) {
					parameters.add(line);
				}
				customers.get(words[0]).order(momoWebsite, words, parameters);
			}
			else if(words.length == 1) {
                if(words[0].equals("listPaidOrders"))
                	momoWebsite.listPaidOrders();
                else if(words[0].equals("listAccounts"))
                	momoWebsite.listAccounts();
                line = reader.readLine();
            }
			else {
				System.out.println("sdfsafsdf");
			}
		}
		reader.close();
	}
	
	public static boolean isCommand(String line) {
		String words[] = line.split(" ");
		ArrayList<String> commandList = new ArrayList<String>(Arrays.asList("bringUp", "setUp", "pay", "exit", "selectProduct", "selectDeliveryMechanism", "selectDeliveryTime"));
		if(words.length == 2)
			return commandList.contains(words[1]);
		if(words.length == 1)
			return commandList.contains(words[0]);
		return false;
	}
}
