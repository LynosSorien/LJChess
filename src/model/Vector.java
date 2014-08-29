package model;

public class Vector {
  private int x;
  private int y;
  
  public Vector(int x, int y) {
    this.x = x;
    this.y = y;
  }
  
  public Vector(Vector vector) {
    this(vector.getX(),vector.getY());
  }
  
  public int getX() {
    return x;
  }
  
  public Vector setX(int x) {
    this.x = x;
    return this;
  }
  
  public int getY() {
    return y;
  }
  
  public Vector setY(int y) {
    this.y = y;
    return this;
  }
    @Override
    public String toString() {
        return "<"+x+","+y+">";
    }
}
