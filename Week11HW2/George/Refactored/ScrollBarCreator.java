public class ScrollBarCreator implements GUICreator {

	@Override
	public Widget createWidget(String name) {
		return (new ScrollBar(name));
	}
}