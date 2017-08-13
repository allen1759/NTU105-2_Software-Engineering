import java.util.HashMap;

public class RTF2TexConverter extends RTFConverter {

	public RTF2TexConverter() {
		map = new HashMap<String, String>();
		map.put("C", "c");
		map.put("F", "_");
		map.put("P", "|");
	}
}
