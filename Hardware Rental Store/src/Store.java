import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

// the store only knows... 
// the days to run?
public class Store {
	private CustomerFactory c;
	private ToolFactory t;
	private List<Customer> customerList; // have 10 capacity
	private List<Tool> toolList; 
	private List<Rental> rentalList;  //keep track of the rental history
	private float balance;
	
	public Store(){
		this.balance = 0;
		init();
	}
	
	private void init(){
		//setup
		c = new CustomerFactory();
		t = new ToolFactory();
		customerList = c.getCustomerCollection();	
		toolList = t.getToolCollection();		
		rentalList = new ArrayList<Rental>();
	}
	
	// run one day use case
	public void oneDay(){
		System.out.println("at the begining :");
		System.out.println(toolToString());
		System.out.println(customerToString());
		System.out.println("run the store for one day");
		Random rand = new Random();
		// if the store does not have available tool anymore
		for(Customer customer: customerList){
			int n = rand.nextInt(2);
			if (n == 0)
				System.out.println("the customer never comes");
			else{
				System.out.println("the customer shows up in the store: "+ customer.getType());
				
				// rent however many tools
				
				if(customer.getType().equals("business") && toolList.size() >=3){
					//System.out.println("a BUSINESS customer came in and about to rent 3 tools");
					// pick up three tools
					// get first three things out of the tool list (do the remove option three times)
					rentOneTool(customer);
					rentOneTool(customer);
					rentOneTool(customer);
					
				
					
				}else if(((customer.getAvailableNum()) >0) && (toolList.size()>0)){
					int x = customer.getAvailableNum();
					int z = toolList.size();
					if(customer.getType().equals("casual")){
						int m = rand.nextInt(2)+1;
						int a = Math.min(Math.min(x, m), z);
						//int a = Math.min(x, m); // check if the user can actually use the full function
						//System.out.println("a CASUAL customer came in and about to rent "+a + " tools");
						for(int i=0; i< a; i++){
							rentOneTool(customer);
						}
					}else if (customer.getType().equals("regular")){
						int m = rand.nextInt(3)+1;
						int a = Math.min(Math.min(x, m), z);
						//System.out.println("a REGULAR customer came in and about to rent "+ a +" tools");
						for(int i=0; i< m; i++){
							rentOneTool(customer);
						}
					}
				}
				

				
				
				
			}
		} //  
		
		System.out.println("|||BEFORE||| : "+rentalList.size() +" check any return: " +rentalToString());
		
		// check customer type and customer "available" rental, check available tools, check i
		// rent tools (randomization) 
		// once rent out something, update the customer information, update the tool list
		
		
		
		
		
		
		Iterator<Rental> iter = rentalList.iterator();
		while (iter.hasNext()) {
		    Rental rental = iter.next();

			rental.deductOneDay();
			if(rental.getRemainingDays() == 0){
				rental.getCustomer().returnRental(); // customer does not need to know what tool they have rented or returned
				// get the tool back to the list
				toolList.add(rental.getTool());
				// how to remove the current rental
				iter.remove();
				System.out.println(rental.getToolName() + " is returned by user "+ rental.getCustomerName());
				
				
			}
		}
		
		
		
		
//		for(Rental rental: rentalList){
//			// deduct all the rental days by one
//			rental.deductOneDay();
//			if(rental.getRemainingDays() == 0){
//				rental.getCustomer().returnRental(); // customer does not need to know what tool they have rented or returned
//				// get the tool back to the list
//				toolList.add(rental.getTool());
//				// how to remove the current rental
//				System.out.println(rental.getToolName() + " is returned by user "+ rental.getCustomerName());
//				
//				
//			}
//		} // 
//		
		System.out.println("|||AFTER||| : "+rentalList.size() +" check any return: " +rentalToString());
		

		
	}
	
	
//	// when there is no tool, need to be called and get new tools automatically
//	private void getNewTool(){
//		
//	}
	
	
	
	
	public void rentOneTool(Customer customer){
		if(toolList.size() == 0) // prevent the randomization requires the positive number
			return;
		
		customer.rent(1);
		
		// get a random tool from the available tool list
		Random rand = new Random();
		System.out.println(this.toolList.size());
		int index = rand.nextInt(this.toolList.size());
		Tool aboutRent = toolList.remove(index);
		
		// pick a random rental days
		int days = 0;
		String customerType = customer.getType();
		if (customerType.equals("business"))
			days = 7;
		else if(customerType.equals("regular"))
			days = rand.nextInt(3)+3;
		else if(customerType.equals("casual"))
			days = rand.nextInt(2)+1;
	
		// add to rental record
		this.balance += aboutRent.getPrice();
		Rental newRental = new Rental(customer, aboutRent, days); // choose days to rent
		System.out.println("customer "+ customer.getName() + " rent out "+ aboutRent.getName() + " for " + days + " days");
		rentalList.add(newRental);
		
	}
	

	
	
	
	public float getBalance(){
		return this.balance;
	}
	
	
	
	
	public String toolToString(){
		String str = "In the tool list : ";
		for(Tool tool: toolList){
			str += "( " + tool.getCategory() + ", " + tool.getName() + ", "+ tool.getPrice() + " )";
		}
		
		return str;
	}
	
	public String customerToString(){
		String str = "In the customer list : ";
		for(Customer customer: customerList){
			str += "( " + customer.getType() + ", " + customer.getName() + ", "+ customer.getAvailableNum() + " )";
		}
		
		return str;
	}
	
	public String rentalToString(){
		String str = "In the rental list : ";
		for(Rental rental: rentalList){
			str += "( " + rental.getCustomerName() + ", " + rental.getToolName() + ", "+ rental.getRemainingDays() + " )";
		}
		
		return str;
	}
	
	
	
	
	
	

}
