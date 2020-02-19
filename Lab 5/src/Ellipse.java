public class Ellipse extends Point {
    protected int a;
    protected int b;
    protected int c;

    public Ellipse() {
    }

    public Ellipse(int x, int y, int a, int b, int c) {
        this.x = x;
        this.y = y;
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public int getA() {
        return a;
    }

    public int getC() {
        return c;
    }

    public int getB() {
        return b;
    }

    public void setA(int a) {
        this.a = a;
    }

    public void setB(int b) {
        this.b = b;
    }

    public void setC(int c) {
        this.c = c;
    }

    @Override
    public void draw() {
        System.out.println("Ellipse with center in: (" + x  + ";" + y + ") and params a = " + a + " b = " + b + " c = " + c);
    }
}
