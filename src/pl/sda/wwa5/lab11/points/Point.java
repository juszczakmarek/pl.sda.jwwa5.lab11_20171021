package pl.sda.wwa5.lab11.points;

public class Point {

    private int x,y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public double distance(Point otherPoint) {
        return Math.sqrt(Math.pow(otherPoint.x-this.x,2)+Math.pow(otherPoint.y-this.y,2));
    }

    @Override
    public String toString() {
        return "[" +  x + ", " + y + ']';
    }
}
