
public class PlumbingTool extends Tool{

	public PlumbingTool(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void pricePerDay() {
		this.price = 15.0;
		
	}

	@Override
	public void category() {
		this.category = "plumbing";
		
	}

}
