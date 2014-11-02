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
      return "x";
    }
  },
  ZERO {
    @Override
    public String toString() {
      return "o";
    }
  }
}
