package assignment06Memento;
  
import assignment06MEM.Board;
import assignment06MEM.Piece;

public class Originator {
	public Memento getMemento(Board board, int iccf) {
		return new MoveMemento(board, iccf);
	}	
	
	public void reset (Board board, Memento mem) {
		MoveMemento mmem = (MoveMemento)mem;
		int iccf = mmem.getIccf();
		int from = iccf / 100;
		int to = iccf % 100;
		Piece fromPiece = mmem.getFromPiece();
		Piece toPiece = mmem.getToPiece();
		//board.setPiece(GET THE FROM LOCATION* from mmem, GET THE FROM PIECE from mmem);
		board.setPiece(from, fromPiece);
		//board.setPiece(GET THE TO LOCATION* from mmem, GET THE TO PIECE from mmem);
		board.setPiece(to, toPiece);
		//*NOTE the LOCATION will be 2 digits using the ICCF notation--the LOCATIONS
		//are split from the iccf in mmem using from = iccf/100 and to = iccf%100
	}
	
	public Memento saveStateToMemento(Board board, int iccf) {
		return new MoveMemento(board, iccf);
	}
	
	public void getStateFromMemento(Board board, Memento mem) {
		MoveMemento mmem = (MoveMemento) mem;
		int iccf = mmem.getIccf();
		int from = iccf / 100;
		int to = iccf % 100;
		board.setPiece(from, mmem.getFromPiece());
		board.setPiece(to, mmem.getToPiece());
	}
}
