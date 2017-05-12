import java.util.HashMap;

public abstract class RTFConverter {

	protected HashMap<String, String> map = null;

	public String convertText(String str) {
		String newText = new String();
		for(int i=0; i<str.length(); i+=1) {
			newText += map.get(String.valueOf(str.charAt(i)));
		}
		return newText;
	}
}
