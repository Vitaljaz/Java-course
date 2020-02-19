public class Main {
    public static void main(String args[]){
        Movable[] array = new Movable[5];
        array[0] = new Rectangle(1, 5, 3, 4, Colors.RED);
        array[1] = new Circle(9, 3, 4, Colors.WHITE);
        array[2] = new MyWindow(15, 16);
        array[4] = new Point(12, 13, Colors.BLUE);

        for (Movable i : array) {
            try {
                swapXY(i);
            }
            catch (NullPointerException ex)  {
                System.out.println("Error while swapping coordinates");
                ex.printStackTrace();
            };

        }
    }

    public static void swapXY(Movable object) throws NullPointerException {
        if(object == null) {
            throw new NullPointerException("Object is null!");
        }

        System.out.println("[swapXY]: old X: " + object.getX() + " old Y: " + object.getY());
        object.moveTo(object.getY(), object.getX());
        System.out.println("[swapXY]: new X: " + object.getX() + " new Y: " + object.getY());
    }
}
