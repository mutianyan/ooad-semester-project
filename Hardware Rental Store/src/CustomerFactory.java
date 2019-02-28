import java.util.ArrayList;
import java.util.List;

public class CustomerFactory {
	// generate 10 customers
	private int capacity = 10;
	private List<Customer> customerCollection;
	
	public CustomerFactory(){
		customerCollection= new ArrayList<Customer>(capacity);
	}
	
	public List<Customer> generateToolsCollection(){ // hardcode??
		generateCustomers("Casual", 4);
		generateCustomers("Regular", 3);
		generateCustomers("Business", 3);
		
		System.out.println("10 customers have been added to your store");
		return this.customerCollection;
	}
	
	public List<Customer> getCustomerCollection(){
		return this.customerCollection;
	}
	
	
	public void generateCustomers(String category, int num){
		if(category.equals("Painting"))
			for(int i=1; i<= num; i++)
				this.customerCollection.add(new CasualCustomer("casual "+ i));
		else if(category.equals("Concrete"))
			for(int i=1; i<= num; i++)
				this.customerCollection.add(new RegularCustomer("regular "+ i));
		else if(category.equals("Plumbing"))
			for(int i=1; i<= num; i++)
				this.customerCollection.add(new BusinessCustomer("business "+ i));
		
	}
	
}
