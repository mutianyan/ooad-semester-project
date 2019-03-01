public abstract class Customer {
	
	protected String type;
	protected String name;
	protected int availableNum;
	
	public Customer(String type, String name){
		this.type = type;
		this.name = name;
		
	}
	
	// customer can rent a tool or several at a time
	// check condition
	// pay up front
	
	public void rent(int num){
		this.availableNum -= num;
	}
	
	
	public int getAvailableNum(){
		return this.availableNum;
	}

	public void returnRental() {
		this.availableNum++;
	}
	
	public String getType(){
		return this.type;
	}
	
	public String getName(){
		return this.name;
	}
}
