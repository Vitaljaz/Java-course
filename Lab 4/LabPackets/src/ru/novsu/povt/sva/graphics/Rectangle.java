package ru.novsu.povt.sva.graphics;

public class Rectangle extends Point {
    protected int width;
    protected int height;

    public Rectangle() {
    }

    public Rectangle(int x, int y, int width, int height, Colors color) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.color = color;
    }

    public Rectangle(Point point, int width, int height) {
        this.x = point.x;
        this.y = point.y;
        this.color = point.color;
        this.width = width;
        this.height = height;
    }

    @Override
    public void draw() {
        System.out.println("Rectangle " + width + "x" + height + " color: " + getColor() + " and position (" + x + ";" + y + ")");
    }

    public Point getPoint() {
        return new Point(super.x, super.y, super.color);
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}
