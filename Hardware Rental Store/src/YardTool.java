
public class YardTool extends Tool{

	public YardTool(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void pricePerDay() {
		this.price =20.0;
		
	}

	@Override
	public void category() {
		this.category="yard";
		
	}

}
