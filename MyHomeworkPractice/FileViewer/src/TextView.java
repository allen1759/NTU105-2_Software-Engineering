
public class TextView implements View{

	private String text;
	
	public TextView(String text) {
		this.text = new String(text);
	}
	
	@Override
	public void display() {
		System.out.print(text);
	}

}
