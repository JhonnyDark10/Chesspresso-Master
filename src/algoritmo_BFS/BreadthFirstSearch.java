package algoritmo_BFS;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

import chesspresso.Chess;
import chesspresso.game.Game;
import chesspresso.move.IllegalMoveException;
import chesspresso.move.Move;
import chesspresso.position.Position;
import principal.Movimientos;

public class BreadthFirstSearch {

	private Node root;
    private Integer goalSate;
 
    
    public Node getRoot() {
        return root;
    }

    public void setRoot(Node root) {
        this.root = root;
    }

    public Integer getGoalSate() {
        return goalSate;
    }

    public void setGoalSate(Integer goalSate) {
        this.goalSate = goalSate;
    }

    public BreadthFirstSearch(Node root,Integer goalSate) {
        this.root = root;
        this.goalSate = goalSate;
    }


    public void breadthFirstSearch() throws IllegalMoveException {
    
       
    ArrayList<Integer> stateSets = new ArrayList<Integer>();
    
    Node nod = new Node(root.getState());
    
    Queue<Node> queue = new LinkedList<Node>();
    
    Node currentNode = nod;
    
    while (!currentNode.getState().equals(goalSate)) {
       
    	stateSets.add(currentNode.getState());    	
    	   	
    	ArrayList<Integer> numeros = new ArrayList<Integer>();
    	numeros = getSuccessors(currentNode.getState());
        
    	for (int n : numeros) {
        
        	if (stateSets.contains(n))
                continue;
        	
            stateSets.add(n);
            
            Node child = new Node(n);
            
            currentNode.addChild(child);
            child.setParent(currentNode);
            queue.add(child);

        }
        
        currentNode = queue.poll();
      
    }

 }
    
    
    public static ArrayList<Integer> getSuccessors(Integer state) throws IllegalMoveException {
    	
    	Game mijuegoadam = new Game();
    	Position position = mijuegoadam.getPosition();	
        short [] movlegal = position.getAllMoves();   
        ArrayList<Integer> successors = new ArrayList<Integer>();
    	
        for (int i = 0; i < movlegal.length; i++)//recorrer
        {
           int asig = movlegal[i];//almaceno
           successors.add(asig);
        }    
    	return successors;
    }
    	
}
