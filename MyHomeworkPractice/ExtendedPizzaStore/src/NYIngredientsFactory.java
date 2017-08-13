
public class NYIngredientsFactory implements IngredientsFactory {

	@Override
	public Sauce createSauce() {
		return new MarinaraSauce();
	}

	@Override
	public Dough createDough() {
		return new ThinCrustDough();
	}

}
