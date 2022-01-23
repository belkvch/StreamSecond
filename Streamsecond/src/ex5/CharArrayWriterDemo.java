package ex5;

import java.io.*;

public class CharArrayWriterDemo {
    public static void main(String[] args) {
        CharArrayWriter charArrayWriter = new CharArrayWriter();
        String source = "Смех - лучшее лекарство";
        try {
            charArrayWriter.write(source);
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Содержимое буфера в виде символьной строки");
        System.out.println(charArrayWriter.toString());
        System.out.println("------------------------------------");

        System.out.println("Вывод данных в массив ");
        char buf[] = charArrayWriter.toCharArray();
        for (int i = 0; i < buf.length; i++)
            System.out.print(buf[i]);

        System.out.println("\nВывод данных в поток вывода типа FileWriter()");
        try (FileWriter fileWriterDestination = new FileWriter("test.txt")) {
            charArrayWriter.writeTo(fileWriterDestination);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Уcтaнoвкa FileWriter в исходное состояние");
        charArrayWriter.reset();
        for (int i = 0; i < 3; i++) charArrayWriter.write('!');
        System.out.println(charArrayWriter.toString());
    }
}
