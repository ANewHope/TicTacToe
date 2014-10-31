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
    GameWeb.init();
  }
  
  public void init() {
    final Game game = new Game();
    post(new Route("/reset") {
      @Override
      public Object handle(Request request, Response response) {
        game.init();
        response.status(200);
        return response;
      }
    });
    post(new Route("/playerMove") {
      @Override
      public Object handle(Request request, Response response) {
        Integer x = Integer.valueOf(request.queryParams("number1"));
        Integer y = Integer.valueOf(request.queryParams("number2"));
        return response;
      }
    });
  }
}
