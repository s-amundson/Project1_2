package MineSweeper;
import javax.swing.Action;
import javax.swing.Icon;
import javax.swing.JButton;
import java.awt.*;


public class Node extends JButton {
	private boolean isMine = false;
	private int numBorderingMines;
	public Node() {
		// TODO Auto-generated constructor stub
		super("     ");
//		super.setMinimumSize(new Dimension(50, 50));
	}

	public Node(Icon icon) {
		super(icon);
		// TODO Auto-generated constructor stub
	}

	public Node(String text) {
		super(text);
		// TODO Auto-generated constructor stub
	}

	public Node(Action a) {
		super(a);
		// TODO Auto-generated constructor stub
	}

	public Node(String text, Icon icon) {
		super(text, icon);
		// TODO Auto-generated constructor stub
	}

	public Integer getNumBorderingMines() {
		return numBorderingMines;
	}

	public void setNumBorderingMines(int numBorderingMines) {
		this.numBorderingMines = numBorderingMines;
	}

	public boolean isMine() {
		return isMine;
	}

	public void setMine(boolean isMine) {
		this.isMine = isMine;
	}

}
