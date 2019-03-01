
// using factory to help the creation of customers and the creation of the tool set
// giving customer certain tools for rent (similar to the process of making pizza)
public class Simulator {
	private static Store newStore;

	public static void main(String args[]){
		
		// create initial state
		// create a store
			newStore = new Store();
		
		// things that need be randomized
		// want to rent? 
		// rent all? rent partial? (how many)
		// rent what tool?		
		
		// run the process for 35 days for loop
		for(int i=1; i<=35; i++){
			System.out.println("day "+i);
			newStore.oneDay();
			System.out.println();
			System.out.println();
		}
		


		
		// generate the report -- simply print the record of the rental transaction
		
		generateRepot();
		
		
	}
	
	public static void generateRepot(){
		System.out.println("The completed rentals: " + newStore.completedRentalToString());
		System.out.println("The active rentals: "+newStore.activeRentalToString() );
		System.out.println("The money earned is: $"+ newStore.getBalance());
	}
	
	

}
