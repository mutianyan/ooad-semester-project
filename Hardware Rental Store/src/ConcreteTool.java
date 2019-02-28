
public class ConcreteTool extends Tool {

	public ConcreteTool(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void pricePerDay() {
		this.price = 10.0;
		
	}

	@Override
	public void category() {
		// TODO Auto-generated method stub
		this.category="concrete";
		
	}


}