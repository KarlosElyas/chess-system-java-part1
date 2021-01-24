package boardgame;

public class Board {
	private Integer rows, columns;
	private Piece[][] pieces;
	
	public Board(Integer row, Integer column) {
		this.rows = row;
		this.columns = column;
		pieces = new Piece[row][column];
	}

	public Integer getRows() {
		return rows;
	}

	public void setRows(Integer rows) {
		this.rows = rows;
	}

	public Integer getColumns() {
		return columns;
	}

	public void setColumns(Integer columns) {
		this.columns = columns;
	}

}