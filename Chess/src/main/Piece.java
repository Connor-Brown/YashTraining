package main;

import java.util.ArrayList;

public class Piece 
{
	String type;
	int color;
	int id;
	boolean hasMovedYet;
	
	//type is the name of the piece, color: 0 is white, 1 is black
	public Piece(String type, int color, int id)
	{
		this.type = type;
		this.color = color;
		this.id = id;
		hasMovedYet = false;
	}
	
	public String getType()
	{
		return type;
	}
	public int getColor()
	{
		return color;
	}
	public int getID()
	{
		return id;
	}
	public boolean hasMovedYet()
	{
		return hasMovedYet;
	}
	public void setMoved()
	{
		hasMovedYet = true;
	}
	
	public ArrayList<Move> legalMoves(Board b)
	{
		ArrayList<Move> returner = new ArrayList<Move>();
		Move location = b.findPiece(this);
		if(location.equals(null))
			return null;
		
		int i = 1;
		switch(type) {
		case "Rook":
			i = 1;
			while(b.checkValidLocation(location.getRow(), location.getCol()+i, color))
			{
				returner.add(new Move(location.getRow(), location.getCol()+i));
				i++;
			}
			if(b.getPieceAtLocation(location.getRow(), location.getCol()+i) != null)
			{
				if(b.getPieceAtLocation(location.getRow(), location.getCol()+i).getColor() != color)
					returner.add(new Move(location.getRow(), location.getCol()+i));
			}
			i = 1;
			while(b.checkValidLocation(location.getRow(), location.getCol()-i, color))
			{
				returner.add(new Move(location.getRow(), location.getCol()-i));
				i++;
			}
			if(b.getPieceAtLocation(location.getRow(), location.getCol()-i) != null)
			{
				if(b.getPieceAtLocation(location.getRow(), location.getCol()-i).getColor() != color)
					returner.add(new Move(location.getRow(), location.getCol()-i));
			}
			i = 1;
			while(b.checkValidLocation(location.getRow()+i, location.getCol(), color))
			{
				returner.add(new Move(location.getRow()+i, location.getCol()));
				i++;
			}
			if(b.getPieceAtLocation(location.getRow()+i, location.getCol()) != null)
			{
				if(b.getPieceAtLocation(location.getRow()+i, location.getCol()).getColor() != color)
					returner.add(new Move(location.getRow()+i, location.getCol()));
			}
			i = 1;
			while(b.checkValidLocation(location.getRow()-i, location.getCol(), color))
			{
				returner.add(new Move(location.getRow()-i, location.getCol()));
				i++;
			}
			if(b.getPieceAtLocation(location.getRow()-i, location.getCol()) != null)
			{
				if(b.getPieceAtLocation(location.getRow()-i, location.getCol()).getColor() != color)
					returner.add(new Move(location.getRow()-i, location.getCol()));
			}
			break;
		case "Knight":
			if(b.checkValidLocation(location.getRow()-2, location.getCol()-1, color))
				returner.add(new Move(location.getRow()-2, location.getCol()-1));
			if(b.checkValidLocation(location.getRow()-2, location.getCol()+1, color))
				returner.add(new Move(location.getRow()-2, location.getCol()+1));
			if(b.checkValidLocation(location.getRow()+2, location.getCol()-1, color))
				returner.add(new Move(location.getRow()+2, location.getCol()-1));
			if(b.checkValidLocation(location.getRow()+2, location.getCol()+1, color))
				returner.add(new Move(location.getRow()+2, location.getCol()+1));
			if(b.checkValidLocation(location.getRow()-1, location.getCol()-2, color))
				returner.add(new Move(location.getRow()-1, location.getCol()-2));
			if(b.checkValidLocation(location.getRow()-1, location.getCol()+2, color))
				returner.add(new Move(location.getRow()-1, location.getCol()+2));
			if(b.checkValidLocation(location.getRow()+1, location.getCol()-2, color))
				returner.add(new Move(location.getRow()+1, location.getCol()-2));
			if(b.checkValidLocation(location.getRow()+1, location.getCol()+2, color))
				returner.add(new Move(location.getRow()+1, location.getCol()+2));
			break;
		case "Bishop":
			i = 1;
			while(b.checkValidLocation(location.getRow()+i, location.getCol()+i, color))
			{
				returner.add(new Move(location.getRow()+i, location.getCol()+i));
				i++;
			}
			if(b.getPieceAtLocation(location.getRow(), location.getCol()+i) != null)
			{
				if(b.getPieceAtLocation(location.getRow(), location.getCol()+i).getColor() != color)
					returner.add(new Move(location.getRow(), location.getCol()+i));
			}
			i = 1;
			while(b.checkValidLocation(location.getRow()-i, location.getCol()+i, color))
			{
				returner.add(new Move(location.getRow()-i, location.getCol()+i));
				i++;
			}
			if(b.getPieceAtLocation(location.getRow()-i, location.getCol()+i) != null)
			{
				if(b.getPieceAtLocation(location.getRow()-i, location.getCol()+i).getColor() != color)
					returner.add(new Move(location.getRow()-i, location.getCol()+i));
			}
			i = 1;
			while(b.checkValidLocation(location.getRow()+i, location.getCol()-i, color))
			{
				returner.add(new Move(location.getRow()+i, location.getCol()-i));
				i++;
			}
			if(b.getPieceAtLocation(location.getRow()+i, location.getCol()-i) != null)
			{
				if(b.getPieceAtLocation(location.getRow()+i, location.getCol()-i).getColor() != color)
					returner.add(new Move(location.getRow()+i, location.getCol()-i));
			}
			i = 1;
			while(b.checkValidLocation(location.getRow()-i, location.getCol()-i, color))
			{
				returner.add(new Move(location.getRow()-i, location.getCol()-i));
				i++;
			}
			if(b.getPieceAtLocation(location.getRow()-i, location.getCol()-i) != null)
			{
				if(b.getPieceAtLocation(location.getRow()-i, location.getCol()-i).getColor() != color)
					returner.add(new Move(location.getRow()-i, location.getCol()-i));
			}
			break;
		case "Queen":
			i = 1;
			while(b.checkValidLocation(location.getRow(), location.getCol()+i, color))
			{
				returner.add(new Move(location.getRow(), location.getCol()+i));
				i++;
			}
			if(b.getPieceAtLocation(location.getRow(), location.getCol()+i) != null)
			{
				if(b.getPieceAtLocation(location.getRow(), location.getCol()+i).getColor() != color)
					returner.add(new Move(location.getRow(), location.getCol()+i));
			}
			i = 1;
			while(b.checkValidLocation(location.getRow(), location.getCol()-i, color))
			{
				returner.add(new Move(location.getRow(), location.getCol()-i));
				i++;
			}
			if(b.getPieceAtLocation(location.getRow(), location.getCol()-i) != null)
			{
				if(b.getPieceAtLocation(location.getRow(), location.getCol()-i).getColor() != color)
					returner.add(new Move(location.getRow(), location.getCol()-i));
			}
			i = 1;
			while(b.checkValidLocation(location.getRow()+i, location.getCol(), color))
			{
				returner.add(new Move(location.getRow()+i, location.getCol()));
				i++;
			}
			if(b.getPieceAtLocation(location.getRow()+i, location.getCol()) != null)
			{
				if(b.getPieceAtLocation(location.getRow()+i, location.getCol()).getColor() != color)
					returner.add(new Move(location.getRow()+i, location.getCol()));
			}
			i = 1;
			while(b.checkValidLocation(location.getRow()-i, location.getCol(), color))
			{
				returner.add(new Move(location.getRow()-i, location.getCol()));
				i++;
			}
			if(b.getPieceAtLocation(location.getRow()-i, location.getCol()) != null)
			{
				if(b.getPieceAtLocation(location.getRow()-i, location.getCol()).getColor() != color)
					returner.add(new Move(location.getRow()-i, location.getCol()));
			}
			i = 1;
			while(b.checkValidLocation(location.getRow()+i, location.getCol()+i, color))
			{
				returner.add(new Move(location.getRow()+i, location.getCol()+i));
				i++;
			}
			if(b.getPieceAtLocation(location.getRow()+i, location.getCol()+i) != null)
			{
				if(b.getPieceAtLocation(location.getRow()+i, location.getCol()+i).getColor() != color)
					returner.add(new Move(location.getRow()+i, location.getCol()+i));
			}
			i = 1;
			while(b.checkValidLocation(location.getRow()-i, location.getCol()+i, color))
			{
				returner.add(new Move(location.getRow()-i, location.getCol()+i));
				i++;
			}
			if(b.getPieceAtLocation(location.getRow()-i, location.getCol()+i) != null)
			{
				if(b.getPieceAtLocation(location.getRow()-i, location.getCol()+i).getColor() != color)
					returner.add(new Move(location.getRow()-i, location.getCol()+i));
			}
			i = 1;
			while(b.checkValidLocation(location.getRow()+i, location.getCol()-i, color))
			{
				returner.add(new Move(location.getRow()+i, location.getCol()-i));
				i++;
			}
			if(b.getPieceAtLocation(location.getRow()+i, location.getCol()-i) != null)
			{
				if(b.getPieceAtLocation(location.getRow()+i, location.getCol()-i).getColor() != color)
					returner.add(new Move(location.getRow()+i, location.getCol()-i));
			}
			i = 1;
			while(b.checkValidLocation(location.getRow()-i, location.getCol()-i, color))
			{
				returner.add(new Move(location.getRow()-i, location.getCol()-i));
				i++;
			}
			if(b.getPieceAtLocation(location.getRow()-i, location.getCol()-i) != null)
			{
				if(b.getPieceAtLocation(location.getRow()-i, location.getCol()-i).getColor() != color)
					returner.add(new Move(location.getRow()-i, location.getCol()-i));
			}
			break;
		case "King":
			for(i = 0; i < 3; i++)
			{
				for(int j = 0; j < 3; j++)
				{
					if(b.checkValidLocation(location.getRow() + i-2, location.getCol() + j-2, color))
					{
						returner.add(new Move(location.getRow() + i-2, location.getCol() + j-2));
					}
				}
			}
			break;
		case "Pawn":
			if(color == 0) //white = heading down the board
			{
				if(location.getRow() == 7)
					return null;
				else
				{
					if(b.getPieceAtLocation(location.getRow()+1, location.getCol()) == null)
						returner.add(new Move(location.getRow()+1, location.getCol()));
					if(!hasMovedYet)
						returner.add(new Move(location.getRow()+2, location.getCol()));
				}
				if(b.getPieceAtLocation(location.getRow()+1, location.getCol()+1) != null && b.getPieceAtLocation(location.getRow()+1, location.getCol()+1).getColor() != color)
					returner.add(new Move(location.getRow()+1, location.getCol()+1));
				if(b.getPieceAtLocation(location.getRow()+1, location.getCol()-1) != null && b.getPieceAtLocation(location.getRow()+1, location.getCol()-1).getColor() != color)
					returner.add(new Move(location.getRow()+1, location.getCol()-1));
			}
			else //black = heading up the board
			{
				if(location.getRow() == 0)
					return null;
				else
				{
					if(b.getPieceAtLocation(location.getRow()-1, location.getCol()) == null)
						returner.add(new Move(location.getRow()-1, location.getCol()));
					if(!hasMovedYet)
						returner.add(new Move(location.getRow()-2, location.getCol()));
				}
				if(b.getPieceAtLocation(location.getRow()-1, location.getCol()+1) != null && b.getPieceAtLocation(location.getRow()-1, location.getCol()+1).getColor() != color)
					returner.add(new Move(location.getRow()-1, location.getCol()+1));
				if(b.getPieceAtLocation(location.getRow()-1, location.getCol()-1) != null && b.getPieceAtLocation(location.getRow()-1, location.getCol()-1).getColor() != color)
					returner.add(new Move(location.getRow()-1, location.getCol()-1));
			}
			break;
		}
		return returner;
	}
	
	public class Move
	{
		int row, col;
		public Move(int row, int col)
		{
			this.row = row;
			this.col = col;
		}
		public int getRow()
		{
			return row;
		}
		public int getCol()
		{
			return col;
		}
	}
}
