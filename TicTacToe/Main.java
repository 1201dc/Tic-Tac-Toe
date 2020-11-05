import javax.swing.JFrame;
import java.awt.FlowLayout;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.imageio.*;

class Main{

  private static boolean isPlayer1 = true; // true = p1 false = p2
	// p1 = x
	private static int[][] board = {{0, 0, 0}, {0, 0, 0}, {0, 0, 0}};
	private static boolean gameIsRunning = true; // true if game is running
  private static int turnCount = 0;

  public Main (){
    board = getBoard();
    gameIsRunning = true;
    isPlayer1 = getIsPlayer1();
    turnCount = getTurnCount();
  }
  public static void setBoard(int[][] newBoard){
    newBoard = board;
  }
  public static int[][] getBoard(){
    return board;
  }

  public static boolean getIsPlayer1(){
    return isPlayer1;
  }
  public static void switchPlayer() {
      isPlayer1 = !isPlayer1;
  }
      
  public static int getTurnCount() {
    return turnCount;
  }
  public static void incTurnCount(){
    turnCount++;
  }

  
  public static void printBoard() {
    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 3; j++) {
        System.out.print(board[i][j]);
      }
      System.out.println();
    }
  }

  public static boolean isWinner() {
		for (int row = 0; row < 3; row++) {
			if (board[row][0] == board[row][1] && board[row][1] == board[row][2] && board[row][0] != 0) {
				return true;
			}
		}
		for (int col = 0; col < 3; col++) {
			if (board[0][col] == board[1][col] && board[1][col] == board[2][col] && board[0][col] != 0) {
				return true;
			}
		}
		if ((board[0][0] == board[1][1] && board[1][1] == board[2][2] && board[0][0] != 0)
				|| (board[0][2] == board[1][1] && board[1][1] == board[2][0] && board[0][2] != 0)) {
			return true;
		}
		return false;
	}


  public static void main (String[] args){
    Success Succ = new Success();
    Succ.setVisible(true);
  }


  public static void displayWinner(String str) {
    Button[][] g = Success.getGrid();
      g[1][1].setIcon(new ImageIcon(g[1][1].getClass().getResource(str)));
      for (int i = 0; i < 3; i++) {
        for (int j = 0; j < 3; j++) {
          g[i][j].setIsClicked(true);
        }
      }
  }
}




class Success extends JFrame{

private static Button[][] Grid = new Button[3][3];
private static JPanel panel = new JPanel();
private static boolean clicked = true;

    public Success() {
        getContentPane().add(panel);
        setSize(625,650);
        panel.setBackground(Color.red);
        setResizable(false);
        
        for (int i = 0; i < 9; i++) {
          Button button = new Button(i/3, i%3);
          button.setPreferredSize(new Dimension(200, 200));
          button.setBackground(Color.WHITE);
       
          panel.add(button);
          Grid[i/3][i%3] = button;
        }
        
      }
    public static void setBackground(String str) {
    	if (str.equals("red")) {
    		panel.setBackground(Color.RED);
    	} else if (str.equals("blue")){
        	panel.setBackground(Color.blue);
    	} else {
    		panel.setBackground(Color.black);
    	}
    }

      public static Button[][] getGrid() {
        return Grid;
      }
} 

  class Button extends JButton implements ActionListener {
    ImageIcon X;
    ImageIcon O;
    boolean isClicked = false;
    int row;
    int column;
    static boolean isEndOfGame = false;
    
    
    public Button(int row, int column) {
    X = new ImageIcon(this.getClass().getResource("TicX.jpeg"));
		O = new ImageIcon(this.getClass().getResource("TicO.jpeg"));
		this.addActionListener(this);
    this.row = row;
    this.column = column;
    }
    public void setIsClicked(boolean b){
      this.isClicked = b;
    }
    public void actionPerformed (ActionEvent evt) {
      boolean isPlayer1 = Main.getIsPlayer1();
      try{

        if(isEndOfGame) {

        } else {
          if(isPlayer1 && !isClicked){
          setIcon(X);
          int[][] placeholder = Main.getBoard();
          placeholder[row][column] = 1;
          Main.setBoard(placeholder);
          isClicked = true;
          Main.switchPlayer();
          Success.setBackground("blue");
          Main.incTurnCount();
        } else if (!isPlayer1 && !isClicked) {
          setIcon(O);
          int[][] placeholder = Main.getBoard();
          placeholder[row][column] = 2;
          Main.setBoard(placeholder);
          isClicked = true;
          Main.switchPlayer();
          Success.setBackground("red");
          Main.incTurnCount();
        } else {
          //do nothing
        }
        //Main.printBoard();
        if (Main.isWinner() || Main.getTurnCount() >= 9){
          isEndOfGame = true;
          Success.setBackground("black");
          if (isPlayer1 && Main.isWinner()) {
			      Main.displayWinner("1.png");
		      } else if (Main.getTurnCount() >= 9) {
			        Main.displayWinner("3.png");
		      } else {
		        	Main.displayWinner("2.png");
		      }
        }
      }
      }
         catch(Exception e){
            System.out.println("EXCEPTION OCCURRED");
          }
    }





  

    

    
  }

