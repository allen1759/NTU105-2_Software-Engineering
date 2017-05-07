public class ButtonCreator implements GUICreator {

	@Override
	public Widget createWidget(String name) {
		return (new Button(name));
	}
}