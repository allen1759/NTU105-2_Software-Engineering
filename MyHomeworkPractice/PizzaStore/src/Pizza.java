import java.util.ArrayList;

public class Pizza extends Product {

	private int size;
	private String curst;
	private ArrayList<String> toppings = new ArrayList<String>();
	
	public Pizza(String words[]) {
		size = Integer.parseInt(words[1]);
		curst = new String(words[2]);
		for(int i=3; i<words.length; i+=1)
			toppings.add(new String(words[i]));
	}
	
	@Override
	public boolean equals(Object o) {
		if (o == this) return true;
        if (o instanceof Pizza) {
           Pizza rhs = (Pizza)o;
           return (size == rhs.size)  && curst.equals(rhs.curst) && 
                   toppings.equals(rhs.toppings);
        }
        return false;
	}

	@Override
	public String getDisplay() {
		// TODO Auto-generated method stub
		String ret = new String();
		ret += "pizza " + Integer.toString(size) + " " + curst;
		for(String top : toppings) {
			ret += " " + top;
		}
		ret += "\n";
		
		return ret;
	}

}
