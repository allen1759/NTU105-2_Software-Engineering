public class MotifCreator implements LookAndFeelCreator {

	@Override
	public LookAndFeel createStyle() {
		return (new Motif());
	}
}