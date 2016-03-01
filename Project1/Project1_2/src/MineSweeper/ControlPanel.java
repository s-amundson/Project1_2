package MineSweeper;

import javax.swing.*;

//import MineSweeper.MineField.ButtonListner;

import java.awt.event.*;

public class ControlPanel extends JPanel{
	private int markedMines = 0;
	private JLabel mineCount, mineText, timerLabel;
	private JButton startNew;
    private Timer timer;
    private int counter = 0; // the duration
    private int delay = 1000; // every 1 second
	
	MineField parentPanel;
	ActionListener action = new ActionListener() // here is your action listener with the label changed.
    {   
        public void actionPerformed(ActionEvent event)
        {
                timerLabel.setText("Time: " + counter + " sec");
                counter++;
        }
    };
	
	public ControlPanel(MineField parent) {
		this.parentPanel = parent;
		this.mineText = new JLabel("Mines Marked: ");
		this.mineCount = new JLabel("0");
		this.startNew = new JButton("Start New");
		this.timerLabel = new JLabel();
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		JPanel panel1 = new JPanel();
		panel1.add(new JLabel("Press Shift+Click to mark mine"));
		JPanel panel2 = new JPanel();
		panel2.add(this.mineText);
		panel2.add(this.mineCount);
		JPanel panel3 = new JPanel();
		panel3.add(this.timerLabel); // I put this in line with the start button you can move it if you want
		panel3.add(startNew);
		add(panel1);
		add(panel2);
		add(panel3);
		startNew.addActionListener(new MyListner());
		timer = new Timer(delay, action);
        timer.setInitialDelay(0);
        timer.start();
	}
	public int getMarkedMines() {
		return markedMines;
	}
	public void setMarkedMines(int markedMines) {
		this.markedMines = markedMines;
		this.mineCount.setText(Integer.toString(markedMines));
	}

	private class MyListner implements ActionListener{
		public void actionPerformed(ActionEvent event){
			if(event.getSource() == startNew){
				System.out.println("startNew");
				parentPanel.newGame();
				counter = 0;

			}
		}
	}
	
}
