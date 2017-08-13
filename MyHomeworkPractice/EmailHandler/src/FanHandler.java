
public class FanHandler extends Handler {

	FanHandler(Handler next) {
		super(next);
	}

	@Override
	void handle(String str) {
		if(str.equals("FAN"))
			System.out.println("Forward to CEO.");
		else
			doNext(str);
	}
}
