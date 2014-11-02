import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Game {
  public Board board;
  public Content currPlayer;
  public State currState;

  public Game() {
    board = new Board();
    currPlayer = Content.EX;
    currState = State.ON;
    board.init();
  }
  
 /**
  * This method initializes a new game, 'x' has the first move
  */
  public void init() {
    currPlayer = Content.EX;
    currState = State.ON;
    board.init();
  }

 /**
  * This method checks if a move is legal and places 
  * the current player's mark if so.
  *
  * @param  x  x coordinate of player move
  * @param  y  y coordinate of player move
  * @return    true if player mark is placed on (x,y)
  */
  public boolean playerMove(int x, int y) {
    if(x >= 0 && y >= 0 && x < 3 && y < 3) {
      if(board.cell[x][y].content == Content.EMPTY) {
        board.cell[x][y].content = currPlayer;
        return true;
      }
    }
    if(board.checkTie()) {
      currState = State.TIE;
      return false;
    }
    else if(board.checkWin()) {
      currState = State.WIN;
      return false;
    }

    return false;
  }

  /**
  * This method changes the current player to 'x' if
  * 'o' has finished his turn, and vice versa.
  */
  public void nextPlayer() {
    if(currPlayer == Content.EX) {
      currPlayer = Content.ZERO;
    }
    else {
      currPlayer = Content.EX;
    }
  }

  /**
  * This method return the current player's string
  */
  public String getPlayer() {
    return currPlayer.toString();
  }
  
 /**
  * This method is here for error fixing purposes only
  */
  public static void main(String[] args) {
  }
}
