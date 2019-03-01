import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CustomerFactory {
	// generate 10 customers
	private int capacity = 10;
	private List<Customer> customerCollection;
	
	public CustomerFactory(){
		customerCollection= new ArrayList<Customer>(capacity);
		this.customerCollection = generateCustomerCollection();
	}
	
	public List<Customer> generateCustomerCollection(){ // hardcode??
		generateCustomers("casual", 4);
		generateCustomers("regular", 3);
		generateCustomers("business", 3);
		return this.customerCollection;
	}
	
	public List<Customer> getCustomerCollection(){
		return this.customerCollection;
	}
	
	
	public void generateCustomers(String category, int num){
		if(category.equals("casual"))
			for(int i=1; i<= num; i++)
				this.customerCollection.add(new CasualCustomer("casual", "casual "+i));
		else if(category.equals("regular"))
			for(int i=1; i<= num; i++)
				this.customerCollection.add(new RegularCustomer("regular", "regualr "+i));
		else if(category.equals("business"))
			for(int i=1; i<= num; i++)
				this.customerCollection.add(new BusinessCustomer("business", "business "+i));
		
	}
	
	
	public String toString(){
		String str = "In the customer list : ";
		for(Customer customer: customerCollection){
			str += "( " + customer.getType() + ", " + customer.getName() + ", "+ customer.getAvailableNum() + " )";
		}
		
		return str;
	}
	
	
	
	
	
	
	
}
