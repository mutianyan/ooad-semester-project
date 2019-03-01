
// using factory to help the creation of customers and the creation of the tool set
// giving customer certain tools for rent (similar to the process of making pizza)
public class Simulator {

	public static void main(String args[]){
		
		// create initial state
		// create a store
			Store newStore = new Store();
		
		// things that need be randomized
		// want to rent? 
		// rent all? rent partial? (how many)
		// rent what tool?		
		
		// run the process for 34 days for loop
		for(int i=0; i<34; i++){
			newStore.oneDay();

		}
		
		System.out.println("the final money earned is: "+ newStore.getBalance());
		
		
		// generate the report -- simply print the record of the rental transaction
		
		//generateRepot();
		
		
	}
	
	public String generateRepot(){
		return "here is the report";
	}
	
	

}
