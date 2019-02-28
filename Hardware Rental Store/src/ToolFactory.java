import java.util.ArrayList;
import java.util.List;

public class ToolFactory {
	
	private int capacity = 20;
	private List<Tool> toolCollection;
	
	public ToolFactory(){
		toolCollection = new ArrayList<Tool>(capacity);
	}
	

	// generate tool set of 2
	public List<Tool> generateToolsCollection(){ // hardcode??
		generateTools("Painting", 4);
		generateTools("Concrete", 4);
		generateTools("Plumbing", 4);
		generateTools("Woodwork", 4);
		generateTools("Yardwork", 4);
		
		System.out.println("20 tools have been added to your store");
		return this.toolCollection;
	}
	
	public List<Tool> getToolCollection(){
		return this.toolCollection;
	}
	

	
	public void generateTools(String category, int num){
		if(category.equals("Painting"))
			for(int i=1; i<= num; i++)
				this.toolCollection.add(new PaintingTool("painting "+ i));
		else if(category.equals("Concrete"))
			for(int i=1; i<= num; i++)
				this.toolCollection.add(new PaintingTool("concrete "+ i));
		else if(category.equals("Plumbing"))
			for(int i=1; i<= num; i++)
				this.toolCollection.add(new PaintingTool("plumbing "+ i));
		else if(category.equals("Woodwork"))
			for(int i=1; i<= num; i++)
				this.toolCollection.add(new PaintingTool("woodwork "+ i));
		else if(category.equals("Yardwork"))
			for(int i=1; i<= num; i++)
				this.toolCollection.add(new PaintingTool("yardwork "+ i));
		
	}
}
