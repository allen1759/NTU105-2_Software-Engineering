public class WindowCreator implements GUICreator {

	@Override
	public Widget createWidget(String name) {
		return (new Window(name));
	}
}