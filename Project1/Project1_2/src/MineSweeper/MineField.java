package MineSweeper;

import java.util.Random;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class MineField extends JPanel {
	int gridWidth = 8;
	int gridHeight = 8;
	int mineNum = 10;
	Node [][] nodeArray;
	ControlPanel cpanel;
	public MineField(ControlPanel cp){
		//this.nodeArray = new Node [gridWidth] [gridHeight];
		this.cpanel = cp;
		generateFeild();
	}
	public MineField(int gridWidth, int gridHeight, int mineNum) {
		super();
		this.gridWidth = gridWidth;
		this.gridHeight = gridHeight;
		this.mineNum = mineNum;
		//this.nodeArray = new Node [gridWidth][gridHeight];
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
	public void generateFeild(){
		setLayout(new GridLayout (gridWidth, gridHeight));
		this.nodeArray = new Node [gridWidth][gridHeight];
		Random rand = new Random();
		Integer numMines;
		
		for(int i=0; i < gridHeight; i++){
			for(int j=0; j < gridWidth; j++){
				
				nodeArray[i][j] = new Node();
				nodeArray[i][j].addActionListener(new ButtonListner());
//				nodeArray[i][j].addMouseListener(new MouseListener());
				add(nodeArray[i][j]);
//				System.out.print(nodeArray[i][j]);
				
			}
		}
		
		// create Mines (basically Matt's code)
		for(int i=0; i<mineNum; i++)
		{
			int num1 = rand.nextInt(7);
			int num2 = rand.nextInt(7);
			if(nodeArray[num1][num2].isMine() == false)
			{
				
				nodeArray[num1][num2].setMine(true);
//				// just to see the mines for now.
//				nodeArray[num1][num2].setBackground(Color.red);
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
//				nodeArray[col][row].setText(numMines.toString());
			}
			System.out.println();
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
								nodeArray[col][row].setText("");
								cpanel.setMarkedMines(cpanel.getMarkedMines()-1);
							}
							else if(nodeArray[col][row].getText()==""){
								nodeArray[col][row].setText("X");
								cpanel.setMarkedMines(cpanel.getMarkedMines()+1);
							}
						}
//						System.out.println(event.getModifiers());
						else{
							if(nodeArray[col][row].isMine()){
								System.out.println("End Game");
							}
							else{
								nodeArray[col][row].setText(nodeArray[col][row].getNumBorderingMines().toString());
							}
						}
					}
				}
			}
			
		}
	}
//	private class MouseListner implements 
}
