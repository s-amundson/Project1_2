package MineSweeper;

import javax.swing.*;

//import MineSweeper.MineField.ButtonListner;

import java.awt.*;
import java.awt.event.*;

public class ControlPanel extends JPanel{
	private int markedMines = 0;
	private JLabel mineCount, mineText;
	private JButton startNew;
	MineField parentPanel;
	public ControlPanel(MineField parent) {
		this.parentPanel = parent;
		this.mineText = new JLabel("Mines Marked: ");
		this.mineCount = new JLabel("0");
		this.startNew = new JButton("Start New");
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		JPanel panel1 = new JPanel();
		panel1.add(new JLabel("Press Shift+Click to mark mine"));
		JPanel panel2 = new JPanel();
		panel2.add(this.mineText);
		panel2.add(this.mineCount);
		JPanel panel3 = new JPanel();
		panel3.add(startNew);
		add(panel1);
		add(panel2);
		add(panel3);
		startNew.addActionListener(new ButtonListner());
	}
	public int getMarkedMines() {
		return markedMines;
	}
	public void setMarkedMines(int markedMines) {
		this.markedMines = markedMines;
		this.mineCount.setText(Integer.toString(markedMines));
	}
	private class ButtonListner implements ActionListener{
		public void actionPerformed(ActionEvent event){
			if(event.getSource() == startNew){
				System.out.println("startNew");
				parentPanel.newGame();
			}
		}
	}
}
