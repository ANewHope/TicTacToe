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

  public void init() {
    currPlayer = Content.EX;
    currState = State.ON;
    board.init();
  }

  public boolean playerMove(int x, int y) {
    if(x >= 0 && y >= 0 && x < 3 && y < 3) {
      if(board.cell[x][y].content == Content.EMPTY) {
        board.cell[x][y].content = currPlayer;
        if(board.checkTie()) currState = State.TIE;
        else if(board.checkWin(Content.EX) && board.checkWin(Content.ZERO)) currState = State.WIN;
        return true;
      }
    }
    return false;
  }

  public void nextPlayer() {
    if(currPlayer == Content.EX) {
      currPlayer = Content.ZERO;
    }
    else {
      currPlayer = Content.EX;
    }
  }

  public String getPlayer() {
    return currPlayer.toString();
  }
  public static void main(String[] args) {

  }
}
