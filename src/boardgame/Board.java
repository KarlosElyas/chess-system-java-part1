package boardgame;

public class Board {
	private Integer rows, columns;
	private Piece[][] pieces;

	public Board(Integer row, Integer column) {
		if(row < 1 || column < 1 )
			throw new BoardException("Error creating board: There must be at least 1 row and 1 column");
			
		this.rows = row;
		this.columns = column;
		pieces = new Piece[row][column];
	}

	public Integer getRows() {
		return rows;
	}

	public Integer getColumns() {
		return columns;
	}

	public Piece piece(int row, int column) {
		if(!positionExists(row, column))
			throw new BoardException("Position not on the board");
			
		return pieces[row][column];
	}

	public Piece piece(Position position) {
		if(!positionExists(position)) throw new BoardException("Position not on the board");
			
		return pieces[position.getRow()][position.getColumn()];
	}

	public void placePiece(Piece piece, Position position) {
		if(thereIsAPiece(position)) throw new BoardException("There is already a piece on position " + position);
		
		pieces[position.getRow()][position.getColumn()] = piece;
		piece.position = position;
	}
	
	public Piece removePiece(Position position) {
		if(!positionExists(position)) throw new BoardException("Position not on the board");
		// os dois paracem ter a mesma condi��o.
		if(piece(position) == null) return null;
		
		Piece aux = piece(position);
		aux.position = null;
		pieces[position.getRow()][position.getColumn()] = null;
		return aux;
	}

	private boolean positionExists(int row, int column) {
		return row >= 0 && row < rows && column >= 0 && column < columns;
	}

	public boolean positionExists(Position position) {
		return positionExists(position.getRow(), position.getColumn());
	}
	
	public boolean thereIsAPiece(Position position) {
		if(!positionExists(position)) throw new BoardException("Position not on the board");

		return piece(position) != null;
	}
}
