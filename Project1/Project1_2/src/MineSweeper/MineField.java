package MineSweeper;

import java.util.Random;
import javax.swing.*;

import java.awt.*;
import java.awt.event.*;


public class MineField extends JPanel {
	int gridWidth = 8;
	int gridHeight = 8;
	int mineNum = 10;
	int cellsLeft;
	Node [][] nodeArray;
	JPanel gamePanel;
	Color buttonColor;
	ControlPanel controlPanel;
	private static String defaultText = "     ";
	
	public MineField(){
		//this.nodeArray = new Node [gridWidth] [gridHeight];
		createPanels();
		generateFeild();
	}
	public MineField(int gridWidth, int gridHeight, int mineNum) {
		super();
		this.gridWidth = gridWidth;
		this.gridHeight = gridHeight;
		this.mineNum = mineNum;
		createPanels();
		generateFeild();
	}

	public int getGridWidth() {
		return gridWidth;
	}

	public void setGridWidth(int gridWidth) {
		this.gridWidth = gridWidth;
	}

	public int getGridHeight() {
		return gridHeight;
	}

	public void setGridHeight(int gridHeight) {
		this.gridHeight = gridHeight;
	}

	public int getMineNum() {
		return mineNum;
	}

	public void setMineNum(int mineNum) {
		this.mineNum = mineNum;
	}
	public void createPanels(){
		controlPanel = new ControlPanel(this);
		gamePanel = new JPanel();
		setLayout(new BorderLayout());
		add(controlPanel, BorderLayout.NORTH);
		add(gamePanel, BorderLayout.CENTER);
	}
	public void generateFeild(){
		gamePanel.setLayout(new GridLayout (gridWidth, gridHeight));
		this.nodeArray = new Node [gridWidth][gridHeight];
		this.cellsLeft = gridWidth*gridHeight-mineNum;
		
		for(int i=0; i < gridHeight; i++){
			for(int j=0; j < gridWidth; j++){
				
				nodeArray[i][j] = new Node();
				nodeArray[i][j].addActionListener(new ButtonListner());
				gamePanel.add(nodeArray[i][j]);
				
			}
		}
		this.buttonColor = nodeArray[0][0].getBackground();
		newGame();
	}
	public void newGame(){
		Random rand = new Random();
		Integer numMines;
		this.cellsLeft = (gridWidth*gridHeight)-mineNum;
		// loop though the field add the button to the panel and determine how many mines are neighboring each mine.
		for(int col=0; col < gridWidth; col++){
			for(int row=0; row < gridHeight; row++){
				nodeArray[col][row].setMine(false);
				nodeArray[col][row].setBackground(buttonColor);
				nodeArray[col][row].setNumBorderingMines(0);
				nodeArray[col][row].setText(defaultText);
				nodeArray[col][row].setEnabled(true);
			}
		}
		controlPanel.setMarkedMines(0);
		// create Mines (basically Matt's code)
		for(int i=0; i<mineNum; i++)
		{
			int num1 = rand.nextInt(7);
			int num2 = rand.nextInt(7);
			if(nodeArray[num1][num2].isMine() == false)
			{
				
				nodeArray[num1][num2].setMine(true);
			}
			else
			{
				i--;
			}
		}
		
		// loop though the field add the button to the panel and determine how many mines are neighboring each mine.
		for(int col=0; col < gridWidth; col++){
			for(int row=0; row < gridHeight; row++){
				numMines = 0;
				// determine mines code goes here.
				for(int n = -1; n<2; n++){
					for(int m = -1; m<2; m++){
						if(n==0 && m == 0){
							continue;
						}
						try{
							if(nodeArray[col+n][row+m].isMine()){
								numMines++;
							}
						} catch (ArrayIndexOutOfBoundsException e){
						}
					}
				}
				nodeArray[col][row].setNumBorderingMines(numMines);

			}
		}
	}
	public void showNumber(int col, int row){ 
		
		// shows the number in a cell. If the cell has no bordering mines it checks the surrounding cells
		try{
			if(nodeArray[col][row].getText()== defaultText){
				cellsLeft --;
				int numMines = nodeArray[col][row].getNumBorderingMines();
				if(numMines==0){
					nodeArray[col][row].setText("");
					nodeArray[col][row].setBackground(Color.LIGHT_GRAY);
					for(int n = -1; n<2; n++){
						for(int m = -1; m<2; m++){
							if(n==0 && m == 0){
								continue;
							}
							showNumber(col+n, row+m);
							
						}
						
					}
				}
				else{
					nodeArray[col][row].setText(String.valueOf(numMines));
					nodeArray[col][row].setBackground(Color.LIGHT_GRAY);
				}
			}
		} catch (ArrayIndexOutOfBoundsException e){
		}
	}
	
	private class ButtonListner implements ActionListener{
		public void actionPerformed(ActionEvent event){
			for(int col=0; col < gridWidth; col++){
				for(int row=0; row < gridHeight; row++){
					if(event.getSource() == nodeArray[col][row]){
						// check if shift key is pressed.
						if(event.getModifiers()== 17){
							if(nodeArray[col][row].getText()=="X"){
								nodeArray[col][row].setText(defaultText);
								controlPanel.setMarkedMines(controlPanel.getMarkedMines()-1);
							}
							else if(nodeArray[col][row].getText()==defaultText){
								
								nodeArray[col][row].setText("X");
								controlPanel.setMarkedMines(controlPanel.getMarkedMines()+1);
							}
						}
						else{
							if(nodeArray[col][row].isMine()){
								if(nodeArray[col][row].getText()=="X"){
									continue;
								}
								nodeArray[col][row].setBackground(Color.red);
								for(int col2=0; col2 < gridWidth; col2++){
									for(int row2=0; row2 < gridHeight; row2++){
										nodeArray[col2][row2].setEnabled(false);
										controlPanel.stopGame();
									}
								}
								System.out.println("End Game");
							}
							else{
								showNumber(col, row);
								if(cellsLeft == 0){
									System.out.println("You Win");
									controlPanel.stopGame();
								}
								
							}
						}
					}
				}
			}
			
		}
	}
}
