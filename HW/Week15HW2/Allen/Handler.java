
public abstract class Handler {

	protected Handler next = null;
	
	Handler(Handler next) {
		this.next = next;
	}
	
	protected void doNext(String str) {
		if(next != null)
			next.handle(str);
	}

	abstract void handle(String str);
}
