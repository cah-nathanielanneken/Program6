
public class Tester {

	public static void main(String [] args) {
		Connect4 board = new Connect4(6,7);
		board.updateSquare(2, 3, 1);
		board.updateSquare(0,0, 2);
		board.updateSquare(1, 6, 1);

	}
}
