package lrn.interfaces;

import lrn.classes.Point;

public class RectanglePlus implements Relatable {
    public int width = 0;
    public int height = 0;
    public Point origin;

    public RectanglePlus() {
        origin = new Point(0, 0);
    }

    public RectanglePlus(Point p) {
        origin = p;
    }

    public RectanglePlus(int w, int h) {
        this();
        width = w;
        height = h;
    }

    public RectanglePlus(Point p, int w, int h) {
        this(p);
        width = w;
        height = h;
    }

    public void move(int x, int y) {
        origin.x = x;
        origin.y = y;
    }

    public int getArea() {
        return width * height;
    }

    @Override
    public int isLargerThan(Relatable other) {
        RectanglePlus otherRect = (RectanglePlus) other;
        return Integer.compare(this.getArea(), otherRect.getArea());
    }

    public static void main(String[] args) {
        RectanglePlus r1 = new RectanglePlus(10, 4);
        RectanglePlus r2 = new RectanglePlus(8, 7);
        System.out.println("compare r1 and r2: " + r1.isLargerThan(r2));
    }
}
