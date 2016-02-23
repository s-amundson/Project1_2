import javax.swing.Action;
import javax.swing.Icon;
import javax.swing.JButton;


public class Nodes extends JButton {
	private boolean isMine;
	private int numBorderingMines;
	public Nodes() {
		// TODO Auto-generated constructor stub
	}

	public Nodes(Icon icon) {
		super(icon);
		// TODO Auto-generated constructor stub
	}

	public Nodes(String text) {
		super(text);
		// TODO Auto-generated constructor stub
	}

	public Nodes(Action a) {
		super(a);
		// TODO Auto-generated constructor stub
	}

	public Nodes(String text, Icon icon) {
		super(text, icon);
		// TODO Auto-generated constructor stub
	}

	public int getNumBorderingMines() {
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
