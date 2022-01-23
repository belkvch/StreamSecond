package ex4;

import java.io.CharArrayReader;
import java.io.IOException;

public class CharArrayReaderDemo {
    public static void main(String[] args) {
        CharArrayReader car = null;
        char[] ch = {'П', 'р', 'и', 'в', 'е', 'т'};
        try {
            car = new CharArrayReader(ch);
            int value = 0;
            while ((value = car.read()) != -1) {
                char c = (char) value;
                System.out.print(c + " : ");
                System.out.println(value);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (car != null) {
                car.close();
            }
        }
    }
}
