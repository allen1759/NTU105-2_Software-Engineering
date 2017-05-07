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

	public void createWidget(String widgetType, String widgetName) {
		Widget tmpWidget;
		switch(widgetType) {
			case ("Window"):
				tmpWidget = new Window(widgetName);
				break;
			case ("ScrollBar"):
				tmpWidget = new ScrollBar(widgetName);
				break;
			case ("Button"):
				tmpWidget = new Button(widgetName);
				break;
			default:
				tmpWidget = null;
				break;
		}
		allWidgets.get(widgetType).add(tmpWidget);
	}

	public void switchStyle(String styleType) {
		for (String wType : order) {
			for (Widget w : allWidgets.get(wType)) {
				w.changeLook(styleType);
			}
		}
	}

	public void present() {
		for (String wType : order) {
			for (Widget w : allWidgets.get(wType)) {
				System.out.println(w.getStyle()+w.getType()+" "+w.getName());
			}
		}
	}
}