import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String args[]) {
        System.out.print("Enter first day in week: ");
        Scanner scanner = new Scanner(System.in);
        int firstDay = scanner.nextInt();

        if (firstDay < 1 || firstDay > 7)
            firstDay = 1;

        System.out.println("Calendar 2020:");

        int startDay;
        int numberOfDays;
        Calendar calendar = new GregorianCalendar();

        for (int i = 0; i < 12; i++) {
            calendar.set(2020, i, 1);
            startDay = calendar.get(Calendar.DAY_OF_WEEK) - 1;
            numberOfDays = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
            System.out.print(calendar.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.US));
            printMonth(startDay, numberOfDays, firstDay);
            System.out.println();
        }
    }

    private static void printMonth(int startDay, int numberOfDays, int firstDay) {
        System.out.println();
        printWeek(firstDay);

        if (startDay == 0)
            startDay = 7;

        int iWeekday = 0;
        for (int i = firstDay; i != startDay; i++) {
            if (i == 7)
                i = 0;
            System.out.print("    ");
            iWeekday++;
        }

        for (int day = 1; day <= numberOfDays; day++) {
            System.out.printf("%1$2d", day);
            iWeekday++;
            if (iWeekday == 7) {
                iWeekday = 0;
                System.out.println();
            } else {
                System.out.print("  ");
            }
        }

        System.out.println();
    }

    private static void printWeek(int firstDay) {
        switch (firstDay) {
            case 1:
                System.out.println("Mo  Tu  We  Th  Fr  Sa Su");
                break;
            case 2:
                System.out.println("Tu  We  Th  Fr  Sa  Su  Mo");
                break;
            case 3:
                System.out.println("We  Th  Fr  Sa  Su  Mo  Tu");
                break;
            case 4:
                System.out.println("Th  Fr  Sa  Su  Mo  Tu  We");
                break;
            case 5:
                System.out.println("Fr  Sa  Su  Mo  Tu  We Th");
                break;
            case 6:
                System.out.println("Sa Su  Mo  Tu  We  Th  Fr");
                break;
            case 7:
                System.out.println("Su  Mo  Tu  We  Th  Fr  Sa");
                break;
        }
    }

}
