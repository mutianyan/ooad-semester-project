
public class Woodwork extends Tool{

	public Woodwork(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void pricePerDay() {
		this.price = 20;
		
	}

	@Override
	public void category() {
		this.category = "wood";
		
	}

}
