public abstract class Pizza {
	protected String type;

	public void bake(){
		System.out.println("Bake Pizza");
	}
	public void cut(){
		System.out.println("Cut Pizza");
	}
	public void box(){
		System.out.println("Box Pizza");
	}

	public String getType(){
		return type;
	}
	
}