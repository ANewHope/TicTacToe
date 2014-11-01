import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Game {

    public static String[][] board;
    public String currPlayer;

  public Game() {

      board = new String[3][3];
		currPlayer = "<img src=\"http:\\/\\/oi60.tinypic.com/iz5hud.jpg\">";
		resetBoard();
  }
  public boolean playerMove(int x, int y ){
        if(x >=  0 && y >=  0 && x < 3 && y < 3){
		    if(board[x][y] == " "){
		        board[x][y] = currPlayer;
		            return true;
		    }
		}
		return false;
	}

	public void resetBoard(){
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                board[i][j] = " ";
                }
        }
    }

    public void nextPlayer(){
    if (currPlayer == "<img src=\"http:\\/\\/oi60.tinypic.com/iz5hud.jpg\">") {currPlayer = "<img src=\"http:\\/\\/oi58.tinypic.com/2lxv8s1.jpg\">";}
    else {currPlayer = "<img src=\"http:\\/\\/oi60.tinypic.com/iz5hud.jpg\">";}
    }
}

