import java.util.ArrayList;
import java.util.List;

public class ToolFactory {
	
	private int capacity = 20;
	private List<Tool> toolCollection;
	
	public ToolFactory(){
		toolCollection = new ArrayList<Tool>(capacity);
		this.toolCollection = generateToolCollection();
	}
	

	// generate tool set of 2
	public List<Tool> generateToolCollection(){ // hardcode??
		generateTools("Painting", 4);
		generateTools("Concrete", 4);
		generateTools("Plumbing", 4);
		generateTools("Woodwork", 4);
		generateTools("Yardwork", 4);
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
				this.toolCollection.add(new ConcreteTool("concrete "+ i));
		else if(category.equals("Plumbing"))
			for(int i=1; i<= num; i++)
				this.toolCollection.add(new PlumbingTool("plumbing "+ i));
		else if(category.equals("Woodwork"))
			for(int i=1; i<= num; i++)
				this.toolCollection.add(new WoodworkTool("woodwork "+ i));
		else if(category.equals("Yardwork"))
			for(int i=1; i<= num; i++)
				this.toolCollection.add(new YardworkTool("yardwork "+ i));
		
	}
	
	
	public String toString(){
		String str = "In the tool list : ";
		for(Tool tool: toolCollection){
			str += "( " + tool.getCategory() + ", " + tool.getName() + ", "+ tool.getPrice() + " )";
		}
		
		return str;
	}
	
	
	
	
	
	
	
}
