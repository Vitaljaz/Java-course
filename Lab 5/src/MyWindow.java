public class MyWindow implements Movable {
    private int x;
    private int y;

    public MyWindow(int x, int y){
        this.x = x;
        this.y = y;
    }

    @Override
    public int getX() {
        return x;
    }

    @Override
    public int getY() {
        return y;
    }

    @Override
    public void moveTo(int x, int y) {
        System.out.println("MainWindow: Move from (" + this.x + ";" + this.y + ") to (" + x + ";" + y + ")");
        this.x = x;
        this.y = y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }
}
