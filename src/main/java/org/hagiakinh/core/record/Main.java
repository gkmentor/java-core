package org.hagiakinh.core.record;


record Point(int x, int y) {
    public Point {
        if (x < 0 || y < 0) {
            throw new IllegalArgumentException("Coordinates must be non-negative");
        }
    }

    public String getXAndY() {
        return String.format("(%d,%d)", x, y);
    }
}


public class Main {

    public static void main(String[] args) {
        Point p1 = new Point(3, 4);
        Point p2 = new Point(3, 4);

        System.out.println(p1.equals(p2));  // true
        System.out.println(p1.hashCode() == p2.hashCode());  // true
        System.out.println(p1);  // Point[x=3, y=4]

        System.out.println(p1.x()); // 3
        System.out.println(p1.y()); // 4

        System.out.println(p1.getXAndY()); // (3,4)
        System.out.println(p2.getXAndY()); // (3,4)
    }
}




