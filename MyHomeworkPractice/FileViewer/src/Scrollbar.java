
public class Scrollbar extends Function {
	
	public Scrollbar(View view) {
		super(view);
	}

	@Override
	public void display() {
		view.display();
		System.out.print(" scrollBar");
	}

}
