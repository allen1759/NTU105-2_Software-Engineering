public abstract class Widget {
	protected LookAndFeel myLook;
	protected LookAndFeel motif, pm;
	protected String type;
	protected String name;

	public Widget() {
		motif = new Motif();
		pm = new PM();
		myLook = motif; // default
	}

	public void changeLook(String look) {
		switch (look) {
			case "Motif":
				myLook = motif;
				break;
			case "PM":
				myLook = pm;
				break;
			default:
				break;
		}
	}

	public String getStyle() {
		return myLook.getStyle();
	}

	public String getType() {
		return type;
	}

	public String getName() {
		return name;
	}

}