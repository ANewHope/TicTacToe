import spark.*;
import static spark.Spark.*;
import spark.servlet.SparkApplication;

public class GameWeb implements SparkApplication {
  public static void main(String[] args) {
    staticFileLocation("/public");
    SparkApplication GameWeb = new GameWeb();
    String portNumber = System.getenv("PORT");
    if(portNumber != null) {
      setPort(Integer.parseInt(portNumber));
    }
    GameWeb.init();
  }

 /**
  * This method initializes the web application (using Spark)
  * It creates an instance of the Game Class, and sends 
  * information about the board and all player moves 
  * to the site - 
  * Doing this enables the user to edit information 
  * that is displayed instantly on the application.
  */
  public void init() {
    final Game game = new Game();

    // This route resets the game board when the user clicks the button
    post(new Route ("/init") {
         @Override
            public Object handle(Request request, Response response) {
                response.status(200);
                game.init();
                return buildTable(game);
            }
         });
    // This route takes in input from the user, x and y coordinates
    // It then evaluates the input, and the game's state
    // If the input is legal, a new board with the recent
    // user input is created and displayed.
    // If there is a tie, or either player has won, a message
    // is displayed below the board.
    // If the game is still going, the method changes
    // the player and can run again.
    post(new Route("/playerMove") {
      @Override
      public Object handle(Request request, Response response) {
        Integer x = Integer.valueOf(request.queryParams("first"));
        Integer y = Integer.valueOf(request.queryParams("second"));
             if (game.playerMove(x, y) && game.currState == State.ON) {
                    StringBuilder table = buildTable(game);
                    response.status(200);
                    if(game.board.checkTie()) {
                      table.append("<div id=\"Results\">" + "It's a tie! " + "Reset the board to play again" + "</div>");
                    }
                    if(game.board.checkWin()) {
                      table.append("<div id=\"Results\">" + game.board.winner.toString() + " has obliterated his opponent. " + "Reset the board to play again" + "</div>");
                    }
                    game.nextPlayer();
                    return table;
                }
            response.status(500);
            return response;
      }
    });
  }
 /**
  * This method creates the game board and all it's cells along with content
  * and returns a StringBuilder containing the board in HTML format
  *
  * @param  game  the current game instance
  * @return StringBuilder HTML-formatted board
  */ 
  public StringBuilder buildTable(Game game) {

    StringBuilder tableBoard = new StringBuilder();
        tableBoard.append("<table class=\"table board\" >\n" +
            "                <tbody>\n" +
            "                <tr>\n" +
            "                    <td id=\"00\" class=\"cell\">"+ game.board.cell[0][0].content.toString() +"</td>\n" +
            "                    <td id=\"01\"class=\"cell\">"+ game.board.cell[0][1].content.toString() +"</td>\n" +
            "                    <td id=\"02\"class=\"cell\">"+ game.board.cell[0][2].content.toString() +"</td>\n" +
            "                </tr>\n" +
            "                <tr>\n" +
            "                    <td id=\"10\"class=\"cell\">"+ game.board.cell[1][0].content.toString() +"</td>\n" +
            "                    <td id=\"11\"class=\"cell\">"+ game.board.cell[1][1].content.toString() +"</td>\n" +
            "                    <td id=\"12\"class=\"cell\">"+ game.board.cell[1][2].content.toString() +"</td>\n" +
            "                </tr>\n" +
            "                <tr>\n" +
            "                    <td id=\"20\"class=\"cell\">"+ game.board.cell[2][0].content.toString() +"</td>\n" +
            "                    <td id=\"21\"class=\"cell\">"+ game.board.cell[2][1].content.toString() +"</td>\n" +
            "                    <td id=\"22\"class=\"cell\">"+ game.board.cell[2][2].content.toString() +"</td>\n" +
            "                </tr>\n" +
            "                </tbody>\n" +
            "            </table>");
        return tableBoard;

  }
}


