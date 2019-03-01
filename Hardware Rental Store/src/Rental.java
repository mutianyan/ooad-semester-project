// keep track of the rental transaction
// each rental

// rental (each transaction) only knows...
public class Rental {
	//private String customerName;
	private Customer customer;
	private Tool tool; // rent 3 tool should be 3 rental order or just one ?
	private int remainingDays;
	private double amount;
	private int initialDays;
	
	public Rental(Customer customer, Tool tool, int initialDays, double amount){
		this.customer = customer;
		this.tool = tool;
		this.initialDays = initialDays;
		this.remainingDays = this.initialDays;
		this.amount = amount;
	}
	
	public void deductOneDay(){
		this.remainingDays -= 1;
	}
	public int getRemainingDays(){
		return this.remainingDays;
	}
	
	public int getInitialDays(){
		return this.initialDays;
	}
	
	
	public Tool getTool(){
		return this.tool;
	}
	
	public String getToolName(){
		return this.tool.getName();
	}
	
	public String getCustomerName(){
		return this.customer.getName();
	}
	
	public Customer getCustomer(){
		return this.customer;
	}
	
	public Double getAmount(){
		return this.amount;
	}

}
