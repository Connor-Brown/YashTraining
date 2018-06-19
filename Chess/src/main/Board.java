package main;

import main.Piece.Move;

public class Board 
{
	/**
	 * [00][01][02][03][04][05][06][07]
	 * [10][11][12][13][14][15][16][17]
	 * [20][21][22][23][24][25][26][27]
	 * [30][31][32][33][34][35][36][37]
	 * [40][41][42][43][44][45][46][47]
	 * [50][51][52][53][54][55][56][57]
	 * [60][61][62][63][64][65][66][67]
	 * [70][71][72][73][74][75][76][77]
	 */
	Piece[][] board = new Piece[8][8];
	public boolean isGameFinished = false;
	public int winner = -1;
	
	public Board()
	{
		board[0][0] = new Piece("Rook", 0, 0);
		board[0][1] = new Piece("Knight", 0, 1);
		board[0][2] = new Piece("Bishop", 0, 2);
		board[0][3] = new Piece("Queen", 0, 3);
		board[0][4] = new Piece("King", 0, 4);
		board[0][5] = new Piece("Bishop", 0, 5);
		board[0][6] = new Piece("Knight", 0, 6);
		board[0][7] = new Piece("Rook", 0, 7);
		
		board[1][0] = new Piece("Pawn", 0, 8);
		board[1][1] = new Piece("Pawn", 0, 9);
		board[1][2] = new Piece("Pawn", 0, 10);
		board[1][3] = new Piece("Pawn", 0, 11);
		board[1][4] = new Piece("Pawn", 0, 12);
		board[1][5] = new Piece("Pawn", 0, 13);
		board[1][6] = new Piece("Pawn", 0, 14);
		board[1][7] = new Piece("Pawn", 0, 15);
		
		board[6][0] = new Piece("Pawn", 1, 16);
		board[6][1] = new Piece("Pawn", 1, 17);
		board[6][2] = new Piece("Pawn", 1, 18);
		board[6][3] = new Piece("Pawn", 1, 19);
		board[6][4] = new Piece("Pawn", 1, 20);
		board[6][5] = new Piece("Pawn", 1, 21);
		board[6][6] = new Piece("Pawn", 1, 22);
		board[6][7] = new Piece("Pawn", 1, 23);
		
		board[7][0] = new Piece("Rook", 1, 24);
		board[7][1] = new Piece("Knight", 1, 25);
		board[7][2] = new Piece("Bishop", 1, 26);
		board[7][3] = new Piece("Queen", 1, 27);
		board[7][4] = new Piece("King", 1, 28);
		board[7][5] = new Piece("Bishop", 1, 29);
		board[7][6] = new Piece("Knight", 1, 30);
		board[7][7] = new Piece("Rook", 1, 31);
	}
	
	public Piece getPieceAtLocation(int row, int col)
	{
		if(row < 0 || row > 7 || col < 0 || col > 7)
			return null;
		return board[row][col];
	}
	
	//returns false if row or col not on board
	//returns false if there is a piece there
	//else returns true
	public boolean checkValidLocation(int row, int col, int myColor)
	{
		if(row < 0 || row > 7 || col < 0 || col > 7)
			return false;
		if(board[row][col] != null)
			return false;
		return true;
	}
	
	public void doMove(int fromRow, int fromCol, int toRow, int toCol)
	{
		Piece p = getPieceAtLocation(fromRow, fromCol);
		board[fromRow][fromCol] = null;
		
		if(board[toRow][toCol]!= null && board[toRow][toCol].getType() == "King")
		{
			isGameFinished = true;
			winner = 1 - board[toRow][toCol].getColor();
		}
		board[toRow][toCol] = p;
		if(!p.hasMovedYet())
			p.setMoved();
	}
	
	public Move findPiece(Piece p)
	{
		for(int i = 0; i < 8; i++)
		{
			for(int j = 0; j < 8; j++)
			{
				if(board[i][j] != null && p.getID() == board[i][j].getID())
					return p.new Move(i, j);
			}
		}
		return null;
	}
	
	public void printBoard()
	{
		printSpaces();
		System.out.print("    A   B   C   D   E   F   G   H  ");
		System.out.println();
		printLine();
		System.out.print("1 ");
		printRow(0);
		printLine();
		System.out.print("2 ");
		printRow(1);
		printLine();
		System.out.print("3 ");
		printRow(2);
		printLine();
		System.out.print("4 ");
		printRow(3);
		printLine();
		System.out.print("5 ");
		printRow(4);
		printLine();
		System.out.print("6 ");
		printRow(5);
		printLine();
		System.out.print("7 ");
		printRow(6);
		printLine();
		System.out.print("8 ");
		printRow(7);
		printLine();
	}
	public void printRow(int row)
	{
		for(int i = 0; i < 8; i++)
		{
			System.out.print("|");
			System.out.print(" ");
			if(board[row][i] == null)
				System.out.print(" ");
			else 
			{
				switch(board[row][i].getType())
				{
				case "Rook":
					if(board[row][i].getColor() == 0)
						System.out.print("r");
					else
						System.out.print("R");
					break;
				case "Bishop":
					if(board[row][i].getColor() == 0)
						System.out.print("b");
					else
						System.out.print("B");
					break;
				case "Knight":
					if(board[row][i].getColor() == 0)
						System.out.print("h");
					else
						System.out.print("H");
					break;
				case "Queen":
					if(board[row][i].getColor() == 0)
						System.out.print("q");
					else
						System.out.print("Q");
					break;
				case "King":
					if(board[row][i].getColor() == 0)
						System.out.print("k");
					else
						System.out.print("K");
					break;
				case "Pawn":
					if(board[row][i].getColor() == 0)
						System.out.print("p");
					else
						System.out.print("P");
					break;
				}
			}
			System.out.print(" ");
		}
		System.out.print("|");
		System.out.println();
	}
	public void printLine()
	{
		System.out.print("  ");
		for(int i = 0; i < 33; i++)
		{
			System.out.print("-");
		}
		System.out.println();
	}
	public void printSpaces()
	{
		for(int i = 0; i < 20; i++)
			System.out.println();
	}
}
