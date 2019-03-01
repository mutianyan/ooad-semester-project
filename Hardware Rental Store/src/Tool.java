// this cannot be instantiated
public abstract class Tool {
	protected double price;
	protected String name;
	protected String category; // necessary?
	
	public Tool(String name){
		this.name = name;
		setPrice();
		setCategory();
	}
	
	public String getName(){
		return this.name;
	}
	
	public double getPrice(){
		return this.price;
	}
	
	public String getCategory(){
		return this.category;
	}
	
	
	public abstract void setPrice();
	public abstract void setCategory();

}
