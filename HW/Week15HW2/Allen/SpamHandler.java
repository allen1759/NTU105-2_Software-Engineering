
public class SpamHandler extends Handler {

	SpamHandler(Handler next) {
		super(next);
	}

	@Override
	void handle(String str) {
		if(str.equals("SPAM"))
			System.out.println("Put mail to the spam box.");
		else
			doNext(str);
	}
}
