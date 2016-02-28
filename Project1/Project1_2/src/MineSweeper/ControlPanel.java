package MineSweeper;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

public class ControlPanel extends JPanel{
	private int markedMines = 0;
	private JLabel mineCount, mineText;
	public ControlPanel() {
		mineText = new JLabel("Mines Marked: ");
		mineCount = new JLabel("0");
		setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		add(mineText);
		add(mineCount);
	}
	public int getMarkedMines() {
		return markedMines;
	}
	public void setMarkedMines(int markedMines) {
		this.markedMines = markedMines;
		mineCount.setText(Integer.toString(markedMines));
	}
	
}
