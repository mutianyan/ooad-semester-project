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
	private List<Rental> activeRentalList;  //keep track of all the active rentals
	private List<Rental> completedRentalList; //kepp all the rentals
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
		activeRentalList = new ArrayList<Rental>();
		completedRentalList = new ArrayList<Rental>();
	}
	
	// run one day use case
	public void oneDay(){
		System.out.println("# of available tools in the store "+ toolList.size());
		System.out.println(toolToString());
		Random rand = new Random();
		// customer randomization
		for(Customer customer: customerList){
			int n = rand.nextInt(2);
			if(n != 0){
				System.out.println("["+customer.getName()+"] shows up in the store");
				
				// rent however many tools
				int days = 0;
				if(customer.getType().equals("business") && toolList.size() >=3){
					//System.out.println("a BUSINESS customer came in and about to rent 3 tools");
					// pick up three tools
					// get first three things out of the tool list (do the remove option three times)
					rentOneTool(customer, 7);
					rentOneTool(customer, 7);
					rentOneTool(customer, 7);
					
				}else if(((customer.getAvailableNum()) >0) && (toolList.size()>0)){
					int x = customer.getAvailableNum();
					int z = toolList.size();
					if(customer.getType().equals("casual")){
						// randomize days
						days = rand.nextInt(2)+1;
						// randomize the number of tools wanted to rent
						int m = rand.nextInt(2)+1;
						int a = Math.min(Math.min(x, m), z);
						for(int i=0; i< a; i++){
							rentOneTool(customer, days);
						}
					}else if (customer.getType().equals("regular")){
						// randomize days
						days = rand.nextInt(3)+3;
						// randomize the number of tools wanted to rent
						int m = rand.nextInt(3)+1;
						int a = Math.min(Math.min(x, m), z);;
						for(int i=0; i< m; i++){
							rentOneTool(customer, days);
						}
					}
				}
				

				
				
				
			}
		} 
		
		
		// check customer type and customer "available" rental, check available tools, check i
		// rent tools (randomization) 
		// once rent out something, update the customer information, update the tool list
		
		
		
		// iterate the rental list to check the tools that need to be returned
		Iterator<Rental> iter = activeRentalList.iterator();
		while (iter.hasNext()) {
		    Rental rental = iter.next();
		    if(rental.getRemainingDays() == 0){
				rental.getCustomer().returnRental(); // customer does not need to know what tool they have rented or returned
				// get the tool back to the list
				toolList.add(rental.getTool());
				// how to remove the current rental
				iter.remove();
				System.out.println(rental.getToolName() + " is returned by ["+ rental.getCustomerName()+"]");
			}else{
				rental.deductOneDay();
			}
		}
		
		

		
	}
	
	
//	// when there is no tool, need to be called and get new tools automatically
//	private void getNewTool(){
//		
//	}
	
	
	
	
	public void rentOneTool(Customer customer, int days){
		if(toolList.size() == 0) // prevent the randomization requires the positive number
			return;
		
		customer.rent(1);
		
		// get a random tool from the available tool list
		Random rand = new Random();
		int index = rand.nextInt(this.toolList.size());
		Tool tool = toolList.remove(index);
	
		// add to rental record
		double amount = tool.getPrice()*days;
		this.balance += amount;
		Rental newRental = new Rental(customer, tool, days, amount); // choose days to rent
		System.out.println("customer "+ customer.getName() + " rent out "+ tool.getName() + " for " + days + " days with $" + amount + " amount");
		activeRentalList.add(newRental);
		completedRentalList.add(newRental);
		
	}
	

	
	
	
	public float getBalance(){
		return this.balance;
	}
	
	
	
	
	
	// generate the active rental list
	
	
	// generate the completed rental list == all the purchases
	
	
	
	
	
	
	
	
	
	
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
	
	public String activeRentalToString(){
		String str = "Active rental list :\n";
		for(Rental rental: activeRentalList){
			str += "( " + rental.getCustomerName() + " rented " + rental.getToolName() + " for "+ rental.getRemainingDays() + " days with amount $"+rental.getAmount()+" )\n";
		}
		
		return str;
	}
	
	public String completedRentalToString(){
		String str = "Completed rental list :\n";
		for(Rental rental: completedRentalList){
			str += "( " + rental.getCustomerName() + " rented " + rental.getToolName() + " for "+ rental.getInitialDays() + " days with amount $"+rental.getAmount()+" )\n";
		}
		
		return str;
	}
	
	
	
	
	

}
