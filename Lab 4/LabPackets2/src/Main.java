import ru.novsu.povt.sva.graphics.Colors;
import ru.novsu.povt.sva.graphics.Point;
import ru.novsu.povt.sva.graphics.Rectangle;

public class Main {
    public static void main(String args[]) {
        Point point = new Point(3, 4, Colors.BLACK);
        point.draw();


        Rectangle rect = new Rectangle(6, 7, 5, 1, Colors.YELLOW);
        rect.draw();
    }
}
