import java.awt.Color;
import java.awt.Graphics;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.border.Border;

/**
 * Creates a square with a border and fills a circle centered in
 * the center of the square with either gray if there is
 * no occupant there, playerColor1 if player one is there,
 * or playerColor2 is player two is there.  If occupant is 0,
 * neither player is at that spot, if occupant is 1, player
 * one is at that spot, and if occupant is 2, player two is at 
 * that spot.
 * @author Nathan Anneken
 * @version 1.0
 *
 */
public class Square extends JPanel {

	private Color playerColor1;
	private Color playerColor2;
	private int occupant;
	
	/**
	 * Constructs this square, assigns colors to both players, and
	 * creates a border for this square
	 * @param playerColor1 The color of the circle for player one
	 * @param playerColor2 The color of the circle for player two
	 */
	public Square(Color playerColor1, Color playerColor2) {
		super();
		this.playerColor1 = playerColor1;
		this.playerColor2 = playerColor2;
		this.occupant = 0;
		this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
	}
	
	/**
	 * Determines if parameter occupantNumber is between 0 and 2,
	 * then sets the occupant number equal to the parameter.  
	 * @param occupantNumber A number between 0 and 2 representing who 
	 */
	public void setOccupant(int occupantNumber) {
		if(occupantNumber<0 || occupantNumber>2) 
			throw new IllegalArgumentException("Occupant number out of bounds:" + occupantNumber);
		else
			this.occupant = occupantNumber;
	}
	
	public int getOccupant() {
		return this.occupant;
	}
	
	public void paintComponent(Graphics g) {
		if(this.occupant == 0) 
			g.setColor(Color.GRAY);
		else if(this.occupant == 1)
			g.setColor(this.playerColor1);
		else
			g.setColor(this.playerColor2);
		g.fillOval(5,5, this.getWidth()-10, this.getHeight()-10);
		
	}
}
