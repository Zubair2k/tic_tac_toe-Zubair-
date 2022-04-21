package com.example;

import java.util.Scanner;

/**
 * Takes in and evaluates a string representing a tic tac toe board.
 */
public class TicTacToeBoard {
	String val;
	
  /**
   * This method should load a string into your TicTacToeBoard class.
   * @param board The string representing the board
   */
  public TicTacToeBoard(String board) {
	  this.val=board.toLowerCase();

  }
 public static void main(String[] args) {
	 Scanner sc = new Scanner(System.in);
	 System.out.println("Enter your X-O value : ");
	 String val=sc.nextLine();
	 TicTacToeBoard obj=new TicTacToeBoard(val);
	 System.out.println(obj.evaluate());
 }
  /**
   * Checks the state of the board (unreachable, no winner, X wins, or O wins)
   * @return an enum value corresponding to the board evaluation
   */
  public Evaluation evaluate() {
	  if(val.length()!=9)
		  return Evaluation.UnreachableState;
	  int xcount=0,ocount=0;
	  for(int i=0;i<val.length();i++)
	  {
		  if(val.charAt(i)=='x')
			  xcount++;
		  else if(val.charAt(i)=='o')
			  ocount++;
	  }
	  if(Math.abs(xcount-ocount)>1)
		  return Evaluation.UnreachableState;
	  for(int i=0;i<3;i++)
	  {
		  if(val.charAt(i)==val.charAt(i+3)&&(val.charAt(i+3)==(val.charAt(i+6)))) {
				 if(val.charAt(i)=='x')
					 return Evaluation.Xwins;
				 else if(val.charAt(i)=='o')
					 return Evaluation.Owins;
			  }
	  }
	  for(int i=0;i<val.length();i+=3)
	  {
		  if(val.charAt(i)==val.charAt(i+1)&&(val.charAt(i+1)==(val.charAt(i+2)))) {
				 if(val.charAt(i)=='x')
					 return Evaluation.Xwins;
				 else if(val.charAt(i)=='o')
					 return Evaluation.Owins;
			  }
	  }
	  if(val.charAt(0)==val.charAt(4)&&(val.charAt(4)==(val.charAt(8)))) {
			 if(val.charAt(0)=='x')
				 return Evaluation.Xwins;
			 else if(val.charAt(0)=='o')
				 return Evaluation.Owins;
		  }
	  if(val.charAt(2)==val.charAt(4)&&(val.charAt(4)==(val.charAt(6)))) {
			 if(val.charAt(4)=='x')
				 return Evaluation.Xwins;
			 else if(val.charAt(4)=='o')
				 return Evaluation.Owins;
		  }
	  return Evaluation.NoWinner;
  }
}
