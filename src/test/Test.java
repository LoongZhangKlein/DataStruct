package test;

import java.util.ArrayList;
import java.util.Scanner;

class Point {
    int x, y;
    String name = "a point";
    Point(){
        x=0;
        y=0;
    }
    Point(int x, int y, String name) {
        this.x = x;
        this.y = y;
        this.name = name;
    }

    int getX() {

        return x;
    }

    int getY() {
        return y;
    }

    void move(int newX, int newY) {
        x = newX;
        y = newY;
    }

    Point newPoint(String name) {
        Point newP = new Point(-x, -y, name);
        return newP;
    }

    boolean equal(int x, int y) {
        if (this.x == x && this.y == y) {
            return true;
        } else {
            return false;
        }
    }
    void print(){
        System.out.println(name+":x="+x+"y="+y);
    }
}

public class Test {
    public static void main(String[] args) {
        Point point = new Point();
        point.print();
        point.move(50,50);
        System.out.println(point.x+"   "+point.y);
        System.out.println("  "+point.getX()+" "+point.getY());
        if (point.equal(50,50)){
            System.out.println("this point is my favourite");

        }else{
            System.out.println("is hate");
        }
        point.newPoint(" new").print();
        new Point(10,15,"另一个新的点");
    }

}
