import java.util.HashMap;

public class RTF2WidgetConverter extends RTFConverter {

	public RTF2WidgetConverter() {
		map = new HashMap<String, String>();
		map.put("C", "<Char>");
		map.put("F", "<Font>");
		map.put("P", "<Paragraph>");
	}
}
