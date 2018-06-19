package main;

import java.util.ArrayList;
import java.util.Scanner;

import main.Piece.Move;

public class StartGame {
	
	public static int colorsTurn = 0; //white starts

	public static void main(String[] args)
	{
		Board b = new Board();
		b.printBoard();
		
		Scanner input = new Scanner(System.in);
		while(!b.isGameFinished)
		{
			String s;
			int first = -1;
			int second = -1;
			boolean checkFrom = true;
			do{
				System.out.println("Please enter what piece you would like to move");
				s = input.nextLine();
				if(checkLegalInput(s))
				{
					char f = s.charAt(0);
					first = inputToRelatedInt(f);
					second = Integer.parseInt(s.substring(1, 2))-1;
					if(checkLocationFrom(b, first, second))
					{
						checkFrom = false;
					}
				}
			} while(checkFrom);
			
			boolean checkTo = true;
			int premier = -1;
			int latter = -1;
			ArrayList<Move> possibleMoves = b.getPieceAtLocation(second, first).legalMoves(b);
			do{
				System.out.println("Please input where you would to move the selected piece to");
				s = input.nextLine();
				if(checkLegalInput(s))
				{
					char f = s.charAt(0);
					premier = inputToRelatedInt(f);
					latter = Integer.parseInt(s.substring(1, 2))-1;
					if(checkLocationTo(b, b.getPieceAtLocation(second, first), premier, latter, possibleMoves))
					{
						checkTo = false;
					}
				}
			} while(checkTo);
			int fromRow = second;
			int fromCol = first;
			int toRow = latter;
			int toCol = premier;
			
			//At this point, you have chosen a legal piece and location to move towards
			
			b.doMove(fromRow, fromCol, toRow, toCol);
			
			b.printBoard();
			nextTurn();
		}
		input.close();
		
		printWinner(b.winner);
	}
	
	private static void nextTurn()
	{
		colorsTurn = 1 - colorsTurn;
	}
	
	private static boolean checkLocationTo(Board b, Piece p, int f, int s, ArrayList<Move> moves)
	{
		//TODO
		if(locationInMoves(moves, f, s))
			return true;
		return false;
	}
	private static boolean locationInMoves(ArrayList<Move> moves, int f, int s)
	{
		for(int i = 0; i < moves.size(); i++)
		{
			if(moves.get(i).getRow() == s && moves.get(i).getCol() == f)
				return true;
		}
		return false;
	}
	private static boolean checkLocationFrom(Board b, int f, int s)
	{
		if(b.getPieceAtLocation(s, f) == null)
			return false;
		if(b.getPieceAtLocation(s, f).getColor() == colorsTurn)
		{
			if(b.getPieceAtLocation(s, f).legalMoves(b).size() > 0)
				return true;
		}
		return false;
	}
	
	private static int inputToRelatedInt(char c)
	{
		switch(c)
		{
		case 'a':
			return 0;
		case 'A':
			return 0;
		case 'b':
			return 1;
		case 'B':
			return 1;
		case 'c':
			return 2;
		case 'C':
			return 2;
		case 'd':
			return 3;
		case 'D':
			return 3;
		case 'e':
			return 4;
		case 'E':
			return 4;
		case 'f':
			return 5;
		case 'F':
			return 5;
		case 'g':
			return 6;
		case 'G':
			return 6;
		case 'h':
			return 7;
		case 'H':
			return 7;
		default:
			return -1;
		}
	}
	
	private static boolean checkLegalInput(String s)
	{
		if(s.length() > 2 || s.length() == 0)
			return false;
		if(s.charAt(0) == 'A' || s.charAt(0) == 'B' || s.charAt(0) == 'C' || s.charAt(0) == 'D' || s.charAt(0) == 'E' || s.charAt(0) == 'F'
				|| s.charAt(0) == 'G' || s.charAt(0) == 'H' || s.charAt(0) == 'a' || s.charAt(0) == 'b' || s.charAt(0) == 'c' || s.charAt(0) == 'd'
				|| s.charAt(0) == 'e' || s.charAt(0) == 'f' || s.charAt(0) == 'g' || s.charAt(0) == 'h')
		{
			if(s.charAt(1) == '1' || s.charAt(1) == '2' || s.charAt(1) == '3' || s.charAt(1) == '4' || s.charAt(1) == '5'
					 || s.charAt(1) == '6' || s.charAt(1) == '7' || s.charAt(1) == '8')
				return true;
		}
		return false;
	}
	
	public static void printWinner(int winner)
	{
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		if(winner == 0)//white
		{
			System.out.println("White player wins!!!");
		}
		else//black
		{
			System.out.println("Black player wins!!!");
		}
	}
}
