package principal;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Random;
import java.util.Scanner;

import chesspresso.Chess;
import chesspresso.game.Game;
import chesspresso.game.GameMoveModel;
import chesspresso.move.IllegalMoveException;
import chesspresso.move.Move;
import chesspresso.pgn.PGNReader;
import chesspresso.position.Position;


public class Principal {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		Movimientos dibujo = new Movimientos();
		dibujo.setVisible(true);       
        dibujo.agregarmovimiento(Chess.B2, Chess.B4, 1);
        dibujo.agregarmovimiento(Chess.A7, Chess.A6, 1);
        dibujo.agregarmovimiento(Chess.C1, Chess.B2,1);
        dibujo.agregarmovimiento(Chess.B8, Chess.C6,1);
        dibujo.agregarmovimiento(Chess.B4, Chess.B5, 1);
        dibujo.agregarmovimiento(Chess.C6, Chess.A5, 1);
        dibujo.agregarmovimiento(Chess.E2, Chess.E4, 1);
        dibujo.agregarmovimiento(Chess.E7, Chess.E6, 1);      
        dibujo.agregarmovimiento(Chess.G1, Chess.F3, 1);
        dibujo.agregarmovimiento(Chess.G8, Chess.F6, 1);
        dibujo.agregarmovimiento(Chess.C2, Chess.C4, 1);
        dibujo.agregarmovimiento(Chess.F8, Chess.D6, 1);
        dibujo.agregarmovimiento(Chess.C4, Chess.C5, 1);
        dibujo.agregarmovimiento(Chess.D6, Chess.C5, 1);
        dibujo.agregarmovimiento(Chess.D2, Chess.D4, 1);
        dibujo.agregarmovimiento(Chess.D7, Chess.D6, 1);
        dibujo.agregarmovimiento(Chess.D4, Chess.D5, 1);
        dibujo.agregarmovimiento(Chess.D8, Chess.D7, 1);
        dibujo.agregarmovimiento(Chess.H1, Chess.G1, 1);
        dibujo.agregarmovimiento(Chess.D7, Chess.B5, 1);
        dibujo.agregarmovimiento(Chess.D1, Chess.D2, 1);
        dibujo.agregarmovimiento(Chess.B5, Chess.D7, 1);
        dibujo.agregarmovimiento(Chess.F1, Chess.C4, 1);
        dibujo.agregarmovimiento(Chess.C5, Chess.B6, 1);
        dibujo.agregarmovimiento(Chess.C4, Chess.B3, 1);
        dibujo.agregarmovimiento(Chess.E6, Chess.E5, 1);
        dibujo.agregarmovimiento(Chess.B3, Chess.A4, 1);
        dibujo.agregarmovimiento(Chess.E8, Chess.D8, 1);
        dibujo.agregarmovimiento(Chess.E1, Chess.F1, 1);
        dibujo.agregarmovimiento(Chess.D7, Chess.E6, 1);     
        dibujo.agregarmovimiento(Chess.D2, Chess.C3, 1);
        dibujo.agregarmovimiento(Chess.E6, Chess.F5, 1);
        dibujo.agregarmovimiento(Chess.C3, Chess.E5, 1);
        dibujo.agregarmovimiento(Chess.F5, Chess.G4, 1);
        
        //piezas blancas agente 
        //piezas negras jugador
        dibujo.agregarmovimiento(Chess.E5, Chess.C3, 1);
       
		int i = 0;
		while (true)
		   {    
            i++;
   
     	   System.out.println ("");
	       System.out.println (" JUGADOR");
	    	try {			   	   

	               System.out.println ("");
			       System.out.println ("  INGRESE POSICION ACTUAL DE LA FICHA:");
			       String inicial = "";
			       Scanner inicial_escaner = new Scanner (System.in); 
			       inicial = inicial_escaner.nextLine();
		        
			       int posicion_inicial =  Chess.strToSqi(inicial);
			
			       System.out.println ("");
			       System.out.println ("  INGRESE LA POSICION DE MOVIMIENTO:");
			       String inicial1 = "";
			       Scanner inicial_escaner1 = new Scanner (System.in); 
			       inicial1 = inicial_escaner1.nextLine();
			       
			       int posicion_final =  Chess.strToSqi(inicial1);		     
			       
			       dibujo.agregarmovimiento(posicion_inicial, posicion_final,1);
		            
			       //************** AGENTE ********************
			      
			       dibujo.automatica();
			       
			       //******************************************
			       
	    			} catch (IllegalMoveException e) {
	 				
	    				System.out.println ("");
	    				System.out.println ("");
	    				System.out.println ("");
	    				System.out.println (" ********* A REALIZADO UN MOVIMIENTO ILEGAL **************");
	    				System.out.println ("");
	    				System.out.println ("");
	    		   }   
	    	   
	        
            if (i==1000)
            { 
            	break;}
            }   

		
 }
}
