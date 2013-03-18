/**
 * 
 */
package gvprojects.chess.model;

/**
 * @author rohrj
 *
 */
public class King extends ChessPiece{

	public King(Player p) {
		super(p, "King");
	}
	
	@Override
	public boolean isValidMove(Move m, IChessPiece[][] p) {
		return super.isValidMove(m, p) && checkDistance(m, 1);		
	}

}
