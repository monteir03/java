class Rectangle {

  Point p1, p2;
  int x1, y1, x2, y2;

  Rectangle(Point p1, Point p2){

    x1=p1.x;
    y1=p1.y;
    x2=p2.x;
    y2=p2.y;
  }

  Rectangle(int x1, int y1, int x2, int y2){
    this.x1=x1;
    this.y1=y1;
    this.x2=x2;
    this.y2=y2;
  }

  public int area(){
    return (x2-x1)*(y2-y1);
  }

  public int perimeter(){
    return (x2-x1)*2+(y2-y1)*2;
  }

  public boolean pointInside(Point p){
    if(p.x<x1 || p.x>x2 || p.y<y1 || p.y>y2) return false;
    return true;
  }

  public boolean rectangleInside(Rectangle r){

    Point pa = new Point(r.x1,r.y1);
    Point pb = new Point(r.x2,r.y2);

    if (!pointInside(pa) || !pointInside(pb))
        return false;
    return true;
    }
}
