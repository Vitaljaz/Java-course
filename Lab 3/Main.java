public class Main {
    public static void main(String args[]){
        System.out.println("Create new point:");
        Point p1 = new Point(1, 1, Colors.BLACK);
        p1.draw();

        System.out.println("Use moveTo(): ");
        p1.moveTo(5, 5);
        p1.draw();

        System.out.println("Use copy constructor for second point:");
        Point p2 = new Point(p1);
        p2.draw();
        p2.move(-1, -3);
        p2.setColor(Colors.YELLOW);
        p2.draw();

        System.out.println("Create background:");
        Background bg = new Background(Colors.RED, "dirt");
        bg.draw();

        System.out.println("Create rectangle:");
        Rectangle rectangle = new Rectangle(7, 8, 3, 4, Colors.WHITE);
        rectangle.draw();

        System.out.println("Create new point with getPoint() method:");
        Point p3 = rectangle.getPoint();
        p3.moveTo(11, 12);
        p3.draw();
    }
}
