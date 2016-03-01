package MineSweeper;


import javax.swing.*;

import java.awt.*;

public class MineSweeper {

	public MineSweeper() {
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		JFrame frame = new JFrame("MineSweeper");
		
		frame.setSize(400, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // perhaps create a dialog to ask if different size is desired?

		MineField board = new MineField();
		frame.getContentPane().setLayout(new BorderLayout());
		frame.getContentPane().add(board, BorderLayout.CENTER);

		frame.pack();
        frame.setVisible(true);
	}
	
}

