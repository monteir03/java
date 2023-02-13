public class Pair{
  private int x;
  private int y;

  Pair(int x, int y){
    this.x=x;
    this.y=y;
  }

  public String toString(){
    String s = "(" + x + "," + y + ")";
    return s;
  }

}
