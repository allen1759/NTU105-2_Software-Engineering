
public class ChicagoIngredientsFactory implements IngredientsFactory {

	@Override
	public Sauce createSauce() {
		return new PlumTomatoSauce();
	}

	@Override
	public Dough createDough() {
		return new ThickCrustDough();
	}

}
