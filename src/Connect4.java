import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class Connect4 extends JFrame {

	private int rows;
	private int columns;
	private JPanel squarePanel;
	private JPanel buttonPanel;
	private JLabel status;
	private Square[][] squares;
	private JButton[] columnButtons;
	
	public Connect4(int rows, int columns) {
		if(rows < 4 || columns < 4)
			throw new IllegalArgumentException("Row/Column out of Bounds: Must be greater than 4");
		this.rows = rows;
		this.columns = columns;
		this.squares = new Square[this.columns][this.rows];
		this.columnButtons = new JButton[this.columns];
		squarePanelSetup();
		buttonPanelSetup();
		statusSetup();
		frameSetup();
	}
	
	private void frameSetup() {
		JFrame frame = new JFrame("Let's Play Connect4!");
		frame.setSize(500, 500);
		frame.setLayout(new BorderLayout());
		JPanel bottom = new JPanel();
		bottom.add(status);
		frame.add(buttonPanel, BorderLayout.NORTH);
		frame.add(squarePanel, BorderLayout.CENTER);
		frame.add(bottom, BorderLayout.SOUTH);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setVisible(true);
	}
	
	private void squarePanelSetup() {
		squarePanel = new JPanel();
		squarePanel.setLayout(new GridLayout(rows, 0));
		squarePanel.setBackground(Color.YELLOW);
		for(int a=0; a<squares[0].length; a++) {
			for(int b=0; b<squares.length; b++) {
				squares[b][a] = new Square(Color.RED, Color.BLACK);
				squarePanel.add(squares[b][a]);
			}
		}
	}
	
	private void buttonPanelSetup() {
		buttonPanel = new JPanel();
		buttonPanel.setLayout(new GridLayout(1,0));
		for(int a=0; a<columnButtons.length; a++) {
			columnButtons[a] = new JButton();
			columnButtons[a].setText(""+a);
			buttonPanel.add(columnButtons[a]);
		}
	}
	
	private void statusSetup() {
		status = new JLabel("Player 1's turn...");
		status.setLayout(new FlowLayout());
	}
	
	public void updateSquare(int row, int column, int status) {
		squares[column][row].setOccupant(status);
		repaint();
	}
	
	public static void main(String[] args) {
		Connect4 board = new Connect4(6,7);
		board.updateSquare(2, 3, 1);
		board.updateSquare(0,0, 2);
		board.updateSquare(1, 6, 1);
		board.updateSquare(3, 3, 2);
	}
}
