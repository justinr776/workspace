package gvprojects.chess.model;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class BishopTest extends ChessPieceTest {

	@Override
	protected IChessPiece make(Player p) {
		return new Bishop(p);
	}

	@Override
	protected Move getValidMove(int row, int col){
		return new Move (row, col, row+1, col+1);
	}
	
	private IChessPiece bishop = make(Player.WHITE);

	@Test
	public void canMoveDiagonal() throws Throwable {
		board[1][1] = bishop;
		assertTrue("bishop Test 1",
				bishop.isValidMove(new Move(1, 1, 2, 0), board));
		
		assertTrue("bishop Test 1-3",
				bishop.isValidMove(new Move(1, 1, 0, 0), board));
		assertTrue("bishop Test 1-4",
				bishop.isValidMove(new Move(1, 1, 0, 2), board));
	}
	
	@Test
	public void moveLongDiag() throws Throwable{
		board[1][1] = bishop;
		assertTrue("Bishop Test",
				bishop.isValidMove(new Move(1, 1, 2, 0), board));
		
	}

	@Test
	public void moveDiagBack() throws Throwable{
		board[7][7] = bishop;
		board[4][4] = make(Player.BLACK);
		assertTrue("bishop Test",
				bishop.isValidMove(new Move(7, 7, 4, 4), board));
	}
	@Test
	public void cannotMoveNoneDiagonal() throws Throwable {
		board[1][1] = bishop;
		assertFalse("bishop Test 2",
				bishop.isValidMove(new Move(1, 1, 3, 0), board));
		assertFalse("bishop Test 2-2",
				bishop.isValidMove(new Move(1, 1, 6, 7), board));
		assertFalse("bishop Test 2-3",
				bishop.isValidMove(new Move(1, 1, 4, 0), board));
		assertFalse("bishop Test 2-4",
				bishop.isValidMove(new Move(1, 1, 0, 4), board));
	}

	@Test
	public void cannotMoveOverPieceDiagonal() throws Throwable {
		board[1][1] = bishop;
		board[2][2] = make();
		assertFalse("Bishop Test 3",
				bishop.isValidMove(new Move(1, 1, 3, 3), board));
	}
	
	@Test
	public void canMoveBackDownDiagonal() throws Throwable {
		board[4][4] = bishop;
		assertTrue("Bishop Test",
				bishop.isValidMove(new Move(4, 4, 1, 7), board));
	}
	
	@Test
	public void canTakeDiagonal() throws Throwable {
		board[4][4] = bishop;
		board[1][7] = make(Player.BLACK);
		assertTrue("Bishop Test 4",
				bishop.isValidMove(new Move(4, 4, 1, 7), board));
	}
}
