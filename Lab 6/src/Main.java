import java.io.*;

public class Main {
    private static double[] sinArray;
    private static double[] newArray;

    public static void main(String[] args) {
        sinArray = new double[360];
        newArray = new double[360];

        task1();
        task2();
        task3();
        task4();
    }

    public static void task1() {
        try {
            PrintWriter pw = new PrintWriter("sin.txt");
            for (int i = 0; i < 360; i++) {
                pw.println(Math.sin(i));
            }
            pw.flush();
            pw.close();
        } catch (FileNotFoundException e) {
            System.out.println("[TASK 1]: Error with file sin.txt");
            e.printStackTrace();
        }
    }

    public static void task2() {
        try {
            BufferedReader sinReader = new BufferedReader(new FileReader("sin.txt"));
            String str;
            int i = 0;
            while ((str = sinReader.readLine()) != null)   {
                sinArray[i] = Double.parseDouble(str);
                i++;
            }
            sinReader.close();
        } catch (Exception e) {
            System.out.println("[TASK 2]: Error with file sin.txt.");
            e.printStackTrace();
        }

        try {
            BufferedReader iReader = new BufferedReader(new FileReader("input.txt"));
            String str = iReader.readLine();
            iReader.close();
            int k = Integer.parseInt(str);
            System.out.println("[TASK 2]: " + sinArray[k]);
        } catch (Exception e) {
            System.out.println("[TASK 2]: Error with file input.txt");
            e.printStackTrace();
        }
    }

    public static void task3() {
        try {
            FileOutputStream fos = new FileOutputStream("sin2.dat");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(sinArray);
            oos.close();

            double[] newArray;
            FileInputStream fis = new FileInputStream("sin2.dat");
            ObjectInputStream iis = new ObjectInputStream(fis);
            newArray = (double[]) iis.readObject();

            iis.close();
            System.out.println("[TASK 3]: oldArray[223] = " + sinArray[223] + " ; newArray[223] = " + newArray[223]);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("[TASK 3]: Error with sin2.dat");
        }
    }

    public static void task4() {
        try {
            FileOutputStream fos = new FileOutputStream("sin3.dat");
            ObjectOutputStream oos = new ObjectOutputStream(fos);

            for (double i : sinArray) {
                oos.writeDouble(i);
            }

            oos.close();

            FileInputStream fis = new FileInputStream("sin3.dat");
            ObjectInputStream iis = new ObjectInputStream(fis);

            double[] newArray = new double[360];

            for (int i = 0; i < sinArray.length; i++) {
                newArray[i] = iis.readDouble();
            }

            iis.close();
            System.out.println("[TASK 4]: oldArray[333] = " + sinArray[333] + " ; newArray[333] = " + newArray[33]);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("[TASK 4]: Error with sin3.dat");
        }
    }
}
