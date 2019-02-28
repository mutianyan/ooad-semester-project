import java.util.List;

// the store only knows... 
// the days to run?
public class Store {
	private CustomerFactory c;
	private ToolFactory t;
	private List<Customer> customerList; // have 10 capacity
	private List<Tool> toolList; 
	private float balance;
	
	
	public Store(){
		this.balance = 0;
		init();
	}
	
	private void init(){
		c = new CustomerFactory();
		t = new ToolFactory();
		customerList = c.getCustomerCollection();
		toolList = t.getToolCollection();
	}
	
	
	// when there is no tool, need to be called and get new tools automatically
	private void getNewTool(){
		
	}
	
	public float getBalance(){
		return this.balance;
	}
	
	
	
	
	

}
