package boardgame;

public class Board {
	private int rows;
	private int columns;
	private Piece[][] pieces;
	public Board(int rows, int column) {
		if(rows < 1 || column < 1) {
			throw new BoardException("Erro creating board: there must be at least 1 row and 1 column");
		}
		this.rows = rows;
		this.columns = column;
		pieces = new Piece[rows][column];
	}
	public int getRows() {
		return rows;
	}


	public int getColumn() {
		return columns;
	}

	
	public Piece piece(int row, int columns) {
		if(!positionExists(row, columns)) {
			throw new BoardException("Position not on the board");
		}
		return pieces[row][columns];
	}
	
	public Piece piece(Position position) {
		if(!positionExists(position)) {
			throw new BoardException("Position not on the board");
		}
		return pieces[position.getRow()][position.getColumn()];
	}
	
	public void placePiece(Piece piece, Position position) {
		if(thereIsAPiece(position)) {
			throw new BoardException("There is already a piece on position " + position);
		}
		pieces[position.getRow()][position.getColumn()] = piece;
		piece.position = position;
	}
	
	private boolean positionExists(int row, int column) {
		return row >= 0 && row < rows && column >= 0 && column < columns ;
	}
	
	public boolean positionExists(Position position) {
		return positionExists(position.getRow(), position.getColumn());
	}
	
	public boolean thereIsAPiece(Position position) {
		if(!positionExists(position)) {
			throw new BoardException("Position not on the board");
		}
		return piece(position) != null;
		
	}

}
