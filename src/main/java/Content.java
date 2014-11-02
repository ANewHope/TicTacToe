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
      return "<img src=\"http:\\/\\/oi58.tinypic.com/2lxv8s1.jpg\">";
    }
  },
  ZERO {
    @Override
    public String toString() {
      return "<img src=\"http:\\/\\/oi60.tinypic.com/iz5hud.jpg\">";
    }
  }
}
