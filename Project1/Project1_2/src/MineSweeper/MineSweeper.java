package MineSweeper;


import javax.swing.*;

import java.awt.*;

public class MineSweeper {
	private int markedMines = 0;
	private static ControlPanel cpanel;
	public MineSweeper() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		JFrame frame = new JFrame("MineSweeper");
		
		frame.setSize(400, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // perhaps create a dialog to ask if different size is desired?

		cpanel = new ControlPanel();
		MineField board = new MineField(cpanel);
        
		frame.getContentPane().setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));
		frame.getContentPane().add(board);
		frame.getContentPane().add(cpanel);
//		frame.pack();
        frame.setVisible(true);
	}

	public int getMarkedMines() {
		return markedMines;
	}

	public void setMarkedMines(int markedMines) {
		this.markedMines = markedMines;
		cpanel.setMarkedMines(markedMines);
	}
	
}

