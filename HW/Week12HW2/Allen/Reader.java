
public class Reader {

	private RTFConverter rtfConverter = null;
	private String result = null;
	
	public Reader() {
		
	}
	
	public void setConverter(RTFConverter rtfConverter) {
		this.rtfConverter = rtfConverter;
	}
	
	public void convertText(String str) {
		result = rtfConverter.convertText(str);
	}
	
	public String getResult() {
		return result;
	}
}
