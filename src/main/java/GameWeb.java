import spark.*;
import static spark.Spark.*;
import spark.servlet.SparkApplication;

public class GameWeb implements SparkApplication {
  public static void main(String[] args) {
    staticFileLocation("/public");
    SparkApplication GameWeb = new GameWeb();
    String portNumber = System.getenv("PORT");
    if(portNumber != null) {
      setPort(Integer.valueOf(portNumber));
    }
    //setPort(4566);
    GameWeb.init();
  }

  public void init() {
    final Game game = new Game();
    post(new Route("/playerMove") {
      @Override
      public Object handle(Request request, Response response) {
        Integer x = Integer.valueOf(request.queryParams("first"));
        Integer y = Integer.valueOf(request.queryParams("second"));
             if (game.playerMove(x, y)) {
                    response.status(200);

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

                    game.nextPlayer();
                    return tableBoard.toString();
                }
            response.status(500);
            return response;
      }
    });
  }
}

