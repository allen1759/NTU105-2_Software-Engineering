import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class Week13HW2 {

	public static void main(String[] args) throws IOException{
		FileReader fr = new FileReader(args[0]);
    	BufferedReader br = new BufferedReader(fr);
    	
    	HashMap<String, List> list_map = new HashMap<String, List>();
    	HashMap<String, SkipList> skiplist_map = new HashMap<String, SkipList>();
    	
    	String[] input;
    	String temp;
    	while((temp = br.readLine()) != null){
    		input = temp.split("\\s");
    		
    		switch(input[0]){
    		case "Create":
    			switch(input[2]){
    			case "List":
    				list_map.put(input[1],  new List());
    				break;
    			case "SkipList":
    				skiplist_map.put(input[1],  new SkipList());
    				break;
    			}
    			break;
    		case "Add":
    			if(list_map.containsKey(input[1])){
    				list_map.get(input[1]).add(input[2]);
    			}
    			else if(skiplist_map.containsKey(input[1])){
    				skiplist_map.get(input[1]).add(input[2]);
    			}
    			break;
    		case "Length":
    			if(list_map.containsKey(input[1])){
    				System.out.println(list_map.get(input[1]).length());
    			}
    			else if(skiplist_map.containsKey(input[1])){
    				System.out.println("SkipList can not access length");
    			}
    			break;
    		case "Size":
    			if(list_map.containsKey(input[1])){
    				System.out.println("List do not have method size");
    			}
    			else if(skiplist_map.containsKey(input[1])){
    				System.out.println(skiplist_map.get(input[1]).length());
    			}
    			break;
    		case "Get":
    			if(list_map.containsKey(input[1])){
    				System.out.println(list_map.get(input[1]).getNode(Integer.valueOf(input[2])));
    			}
    			else if(skiplist_map.containsKey(input[1])){
    				System.out.println("SkipList do not have method get");
    			}
    			break;
    		case "GetNode":
    			if(list_map.containsKey(input[1])){
    				System.out.println("List do not have method getNode");
    			}
    			else if(skiplist_map.containsKey(input[1])){
    				System.out.print("SkipNode:");
    				System.out.println(skiplist_map.get(input[1]).getNode(Integer.valueOf(input[2])));
    			}
    			break;
    		case "PrintOutList":
    			if(list_map.containsKey(input[1])){
    				Iterator it = list_map.get(input[1]).iterator();
    				while(it.hasNext()){
    					System.out.println(it.next());
    				}
    			}
    			else if(skiplist_map.containsKey(input[1])){
    				Iterator it = skiplist_map.get(input[1]).iterator();
    				while(it.hasNext()){
    					System.out.print("SkipNode:");
    					System.out.println(it.next());
    				}
    			}
    			break;
    		}
    	}
    	br.close();
	}
}
