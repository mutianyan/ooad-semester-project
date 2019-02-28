// this cannot be instantiated
public abstract class Tool {
	protected double price;
	protected String name;
	protected String category; // necessary?
	
	public Tool(String name){
		this.name = name;
	}
	
	public String getToolName(){
		return this.name;
	}
	
	public double getToolPrice(){
		return this.price;
	}
	
	public abstract void pricePerDay();
	public abstract void category();

}
