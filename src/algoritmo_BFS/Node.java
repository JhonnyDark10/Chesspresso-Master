package algoritmo_BFS;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;




public class Node {
	
	    private Integer state;
	    private ArrayList<Node> children;
	    private Node parent;
  
	    public Node(Integer state) {
	        this.state = state;
	        children = new ArrayList<Node>();
	    }
	    
	    public Integer getState() {
	        return state;
	    }

	    public ArrayList<Node> getChildren() {
	        return children;
	    }
	  
	    public void addChild(Node child) {
	        children.add(child);
	    } 
	    
	    public Node getParent() {
	        return parent;
	    }

	    public void setParent(Node parent) {
	        this.parent = parent;
	    } 
}
