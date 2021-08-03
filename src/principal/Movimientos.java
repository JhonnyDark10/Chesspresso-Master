package principal;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import java.util.Scanner;
import java.util.Stack;

import javax.swing.JFrame;


import algoritmo_BFS.BreadthFirstSearch;
import algoritmo_BFS.Node;
import chesspresso.Chess;
import chesspresso.game.Game;
import chesspresso.game.GameMoveModel;
import chesspresso.game.view.GameBrowser;
import chesspresso.move.IllegalMoveException;
import chesspresso.move.Move;
import chesspresso.position.Position;



public class Movimientos extends JFrame {


	ArrayList<Short> movimientocombiandos = new ArrayList<Short>(); 
	
	/***** CREO EL JUEGO  ********/
	
	Game mijuegoadam = new Game();
	
	public Movimientos(){		
		
		/******** CABECERA DEL JUEGO **************/
		mijuegoadam.setTag("Event", "JUEGO AJEDREZ");
		mijuegoadam.setTag("Site", "UPSE");
		mijuegoadam.setTag("Date", "26-06-2017");
		mijuegoadam.setTag("Round", "1");
		mijuegoadam.setTag("White", "JHONNY");
		mijuegoadam.setTag("Black", "SERPA");
	   
	
		
		/************* ASIGNO PARA Q LO DIBUJE ******************/
		
		GameBrowser mijuegodibujado = new GameBrowser(mijuegoadam);
		
		setTitle("CLASE INTELIGENCIA ARTIFICIAL");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		add(mijuegodibujado);
		pack();		
	}	
	
	/****************** FUNCION PARA DAR VALIDACIONES Y REALIZAR EL MOVIMIENTO ***************/

	public void agregarmovimiento(int inicio, int final_m,int jug) throws IllegalMoveException {
        
		Position position = mijuegoadam.getPosition();
        short [] movlegal = position.getAllMoves();//todos las posiciones
        for (int i = 0; i < movlegal.length; i++)//recorrer
        {
           short asig = movlegal[i];//almaceno
           if (Move.getFromSqi(asig) == inicio && Move.getToSqi(asig) == final_m)//comparo
           {
               try {
            	   position.doMove(asig);//realizo el movimiento         
               } catch (IllegalMoveException e) {
                   e.printStackTrace();//si es una posicion ilegal
               }
             return;
            }
        }
        throw new IllegalMoveException("");
	}
	
	
	
	/*********************************** FUNCION AUTOMATICA AGENTE ***************************** */
	/****** implementacion del metodo de busqueda jaque en 3 movimiento 
	 * @throws Exception *********/

	 static Position position;
     //static String[] game;
     //static final int x = 9;    
	
	public void automatica() throws Exception  {
        	           		 
           //position = Position.createInitialPosition();
           Position position = mijuegoadam.getPosition();  
           
           // short movimiento = Move.getRegularMove(Chess.A2, Chess.A3, false);
             evalua();
           //  search(position,9);
        
        }
        
	          
          public void evalua() throws IllegalMoveException {
        	  
           //game = new String[x + 1]; 
            //int c = mijuegoadam.getPosition().getPlyNumber();
            
            //Move lastMove = mijuegoadam.getPosition().getLastMove();
          /*  
            if(c > x){  
                if(mijuegoadam.getPosition().isMate() && lastMove.isCapturing()
                    && lastMove.getMovingPiece() == Chess.WHITE_BISHOP
                    && mijuegoadam.getPosition().getPiece(lastMove.getToSqi()) == Chess.WHITE_QUEEN){         
                    for(int i=0; i<c; i++)
                        System.out.println(game[i]);
                    System.out.println();
                }
                return;    
                short[] movimientosAgente = mijuego.getPosition().getAllMoves();
		       int movpos = mijuego.getPosition().getAllMoves().length;
		       Random r1 = new Random();
		       int movRan=r1.nextInt(movpos);
		       short movAgente = movimientosAgente[movRan];
		    mijuego.getPosition().doMove(movAgente);	       	
            }*/
                       
            short[] nextMoves = mijuegoadam.getPosition().getAllMoves();   
            for(short thisMove : nextMoves){    	
            	//if(mijuegoadam.getPosition().getAllMoves() == mijuegoadam.getPosition().getAllNonCapturingMoves()){
 	            //evalua();
            	//Move lastMove = mijuegoadam.getPosition().getLastMove(); 	
            	if (Move.isCapturing(thisMove)){
            	    mijuegoadam.getPosition().doMove(thisMove);
                 	
                	mijuegoadam.getPosition().undoMove();
                return;	
            		
            	}
            }
        }
          /*
     
  	  private int search(Position pos, int depth) throws Exception
  	    {
  	        if (depth < 0) return 1;
  	        
  	        short[] moves = pos.getAllMoves();
  	        int sum = 0;
  	        for (int i=0; i<moves.length; i++) {
  	            if ( moves[i] == Move.getFromSqi(moves[i])){
  	            	pos.doMove(moves[i]);
  	            }
              return sum ;     
  	        }
            return sum;  	
    }  
          */
}










