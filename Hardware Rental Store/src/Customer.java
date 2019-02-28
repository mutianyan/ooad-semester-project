public abstract class Customer {
	
	protected String type;
	protected String name;
	protected int availableNum;
	
	public Customer(String type){
		this.type = type;
	}
	
	// customer can rent a tool or several at a time
	// check condition
	// pay up front
	
	public Boolean rent(){
		return false;
	}
}
