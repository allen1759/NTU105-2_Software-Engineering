import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;

public class Week13HW1 {

	public static void main(String[] args) throws IOException{
		FileReader fr = new FileReader(args[0]);
    	BufferedReader br = new BufferedReader(fr);
    	
    	LinkedList<Component> components = new LinkedList<Component>();
    	
    	String input;
    	while((input = br.readLine()) != null){
    		
    		if(input.contains("<Text/>")){
    			components.add(new Text());
    		}
    		else if(input.contains("<Line/>")){
    			components.add(new Line());
    		}
    		else if(input.contains("<Rectangle/>")){
    			components.add(new Rectangle());
    		}
    		else if(input.contains("<Group/>")){
    			components.add(new Group());
    		}
    		else if(input.contains("<Group>")){
    			components.add(group(br));
    		}
    		    		
    	}
    	
    	for(Component c:components){
    		c.print();
    		System.out.println();
    	}
	}
	
	public static Group group(BufferedReader br) throws IOException{
		Group g = new Group();
		String input;
		while((input = br.readLine()) != null){
			if(input.contains("<Text/>")){
    			g.add(new Text());
    		}
    		else if(input.contains("<Line/>")){
    			g.add(new Line());
    		}
    		else if(input.contains("<Rectangle/>")){
    			g.add(new Rectangle());
    		}
    		else if(input.contains("<Group/>")){
    			g.add(new Group());
    		}
    		else if(input.contains("<Group>")){
    			g.add(group(br));
    		}
    		else if(input.contains("</Group>")){
    			return g;
    		}			
		}
		System.out.println("error occurs");
		return null;
	}
}
