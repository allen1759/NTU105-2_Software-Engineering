public abstract class Widget {
	protected LookAndFeel myStyle;
	protected String type;
	protected String name;

	public Widget() {
		myStyle = new Motif(); // default
	}

	public void changeLook(LookAndFeelCreator creator) {
		myStyle = creator.createStyle();
	}

	public String getStyle() {
		return myStyle.getStyle();
	}

	public String getType() {
		return type;
	}

	public String getName() {
		return name;
	}

}