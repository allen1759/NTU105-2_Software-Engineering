import java.util.ArrayList;

public class Salad extends Product {

	private ArrayList<String> dressings = new ArrayList<String>();
	
	public Salad(String words[]) {
		for(int i=1; i<words.length; i+=1)
			dressings.add(new String(words[i]));
	}

	@Override
	public String getDisplay() {
		// TODO Auto-generated method stub
		String ret = new String();
		ret += "salad";
		for(String dress: dressings) {
			ret += " " + dress;
		}
		ret += "\n";
		
		return ret;
	}
}
