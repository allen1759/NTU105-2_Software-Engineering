import java.util.*;

public class GUIApplication {
	private HashMap<String, ArrayList<Widget>> allWidgets;
	private ArrayList<String> order;

	public GUIApplication(ArrayList<String> setOrder) {
		allWidgets = new HashMap<String, ArrayList<Widget>>();
		for (String str : setOrder) {
			allWidgets.put(str, new ArrayList<Widget>());
		}
		this.order = setOrder;
	}

	public void createWidget(GUICreator creator, String widgetName) {
		Widget tmpWidget = creator.createWidget(widgetName);
		allWidgets.get(tmpWidget.getType()).add(tmpWidget);
	}

	public void switchStyle(LookAndFeelCreator creator) {
		for (String wType : order) {
			for (Widget w : allWidgets.get(wType)) {
				w.changeLook(creator);
			}
		}
	}

	public void present() {
		for (String wType : order) {
			for (Widget w : allWidgets.get(wType)) {
				w.print();
			//	System.out.println(w.getStyle()+w.getType()+" "+w.getName());
			}
		}
	}
}