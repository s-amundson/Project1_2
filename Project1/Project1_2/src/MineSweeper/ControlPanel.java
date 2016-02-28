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
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		JPanel panel1 = new JPanel();
		panel1.add(new JLabel("Press Shift+Click to mark mine"));
		JPanel panel2 = new JPanel();
		panel2.add(mineText);
		panel2.add(mineCount);
		add(panel1);
		add(panel2);
	}
	public int getMarkedMines() {
		return markedMines;
	}
	public void setMarkedMines(int markedMines) {
		this.markedMines = markedMines;
		mineCount.setText(Integer.toString(markedMines));
	}
	
}
