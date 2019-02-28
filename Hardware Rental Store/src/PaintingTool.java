
public class PaintingTool extends Tool {

	public PaintingTool(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void pricePerDay() {
		this.price = 5.0;
		
	}

	@Override
	public void category() {
		this.category = "painting";
		
	}


}
