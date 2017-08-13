
public abstract class Pizza {

	protected String name;
	private Dough dough;
	private Sauce sauce;
	private IngredientsFactory ingFact;
	
	public Pizza(IngredientsFactory ingFact) {
		this.ingFact = ingFact;
	}
	
	public void prepare() {
		dough = ingFact.createDough();
		sauce = ingFact.createSauce();
		System.out.println("Prepare " + name + " Pizza with " + dough.getDough() + " and " + sauce.getSauce());
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
 
}
