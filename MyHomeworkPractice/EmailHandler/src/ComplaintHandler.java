
public class ComplaintHandler extends Handler {

	ComplaintHandler(Handler next) {
		super(next);
	}

	@Override
	void handle(String str) {
		if(str.equals("COMPLAINT"))
			System.out.println("Forward to legal department.");
		else
			doNext(str);
	}
}
