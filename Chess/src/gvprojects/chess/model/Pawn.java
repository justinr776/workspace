/**
 * 
 */
package gvprojects.chess.model;

/**
 * @author Justin Rohr
 * 
 */
public class Pawn extends ChessPiece {

	private boolean firstMove = true;

	/**
	 * 
	 */
	public Pawn(Player p) {
		super(p, "Pawn");
	}

	@Override
	public boolean isValidMove(Move m, IChessPiece[][] p) {
		// Old Tests
		if (super.isValidMove(m, p) == false)
			return false;
		// Checks to make sure move distance is ok
		else if (firstMove == true && checkDistance(m, 2) == false
				|| firstMove == false && checkDistance(m, 1) == false)
			return false;
		else if (m.fromColumn != m.toColumn && m.fromRow != m.toRow) {
			// If moving diagonal check that the spot is another player
			if (p[m.toRow][m.toColumn] != null
					&& p[m.toRow][m.toColumn].player() == this.player()
					|| p[m.toRow][m.toColumn] == null)
				return false;
		} else if (m.fromColumn != m.toColumn)
			return false;
		else if (firstMove == true && checkRandC(m, p) == false)
			return false;
		else if (this.player() == Player.WHITE && this.name() == "Pawn") {
			if (m.toRow > m.fromRow)
				return false;
		} else if (this.player() == Player.BLACK && this.name() == "Pawn")
			if (m.toRow < m.fromRow)
				return false;
		firstMove = false;
		return true;
	}

}
