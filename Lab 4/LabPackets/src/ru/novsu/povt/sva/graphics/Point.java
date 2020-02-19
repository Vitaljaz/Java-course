package ru.novsu.povt.sva.graphics;

public class Point extends Graph {
    protected int x;
    protected int y;
    protected Colors color;

    public Point() {
    }

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Point(int x, int y, Colors color) {
        this.x = y;
        this.y = y;
        this.color = color;
    }

    public Point (Point p) {
        this.x = p.x;
        this.y = p.y;
        this.color = p.color;
    }

    @Override
    public void draw() {
        System.out.println("Point with color: " + getColor() + " and position (" + x + ";" + y + ")");
    }

    public void moveTo(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void move(int dx, int dy) {
        this.x += dx;
        this.y += dy;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public String getColor() {
        switch(color) {
            case WHITE:
                return "WHITE";
            case BLACK:
                return "BLACK";
            case YELLOW:
                return "YELLOW";
            case GREEN:
                return "GREEN";
            case RED:
                return "RED";
            case BLUE:
                return "BLUE";
            default:
                return "NONE";
        }
    }

    public void setColor(Colors color) {
        this.color = color;
    }
}
