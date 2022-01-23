package ex9;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

public class PrintWriterDemo {
    final static String filename = "Фет.txt";

    public static void main(String[] args) {
        PrintWriter printWriter = new PrintWriter(System.out, true);
        printWriter.println("Строка для записи");
        int i = 5;
        double k = 10.0;
        printWriter.printf("i = %d and k = %.5f", i, k);
        printWriter.flush();
        System.out.println("\n---------------------------------");
        Date date = new Date();
        try {
            printWriter = new PrintWriter(filename);
            i++;
            printWriter.println(date);
            printWriter.write("Запись No i = " + i);
            System.out.println("Запись в файл произведена успешно");
        } catch (FileNotFoundException | SecurityException e) {
            e.printStackTrace();
        } finally {
            if (printWriter != null) {
                printWriter.close();
            }
        }
        Object obj = System.getProperty("line.separator") + "новый элемент";
        try {
            printWriter = new PrintWriter(new BufferedWriter(new FileWriter(filename, true)));
            printWriter.println(obj);
            printWriter.write("!!!Новая строка!!!", 0, 10);
            System.out.println("Новая строка успешно добавлена в файл");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException | SecurityException e) {
            e.printStackTrace();
        } finally {
            if (printWriter != null) {
                printWriter.close();
            }
        }
    }
}
