package gvprojects.chess.model;

public class Queen extends ChessPiece {

	public Queen(Player p) {
		super(p, "Queen");
	}

	@Override
	public boolean isValidMove(Move m, IChessPiece[][] p) {
		if (super.isValidMove(m, p) == false)
			return false;
		else if (checkRandC(m, p) == false && checkDiag(m, p) == false)
			return false;
		else if (m.fromColumn != m.toColumn && m.fromRow != m.toRow
				&& checkDiag(m, p) == false)
			return false;
		return true;
	}
}
