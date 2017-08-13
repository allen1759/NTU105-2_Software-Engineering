
public abstract class Function implements View {

	protected View view;
	
	public Function(View view) {
		this.view = view;
	}
	
	abstract public void display();
}
