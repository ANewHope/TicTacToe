public enum Content {
  EMPTY {
    @Override
    public String toString() {
      return "";
    }
  },
  EX {
    @Override
    public String toString() {
      return "<img src=\"http:\\/\\/i62.tinypic.com\\/20tgthh.jpg\">";
    }
  },
  ZERO {
    @Override
    public String toString() {
      return "<img src=\"http:\\/\\/oi60.tinypic.com/iz5hud.jpg\">";
    }
  }
}
