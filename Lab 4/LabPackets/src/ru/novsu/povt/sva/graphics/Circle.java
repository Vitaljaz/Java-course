package ru.novsu.povt.sva.graphics;

public class Circle extends Point {
    protected int r;

    public Circle() {
    }

    public Circle(int x, int y, int r) {
        this.x = x;
        this.y = y;
        this.r = r;
    }

    public Circle(int x, int y, int r, Colors color) {
        this.x = x;
        this.y = y;
        this.r = r;
        this.color = color;
    }

    public Point getPoint() {
        return new Point(super.x, super.y);
    }

    public int getR() {
        return r;
    }

    public void setR(int r) {
        this.r = r;
    }

    @Override
    public void draw() {
        System.out.println("Circle with R: " + r + " color: " + getColor() + " and center (" + x + ";" + y + ")");
    }
}
