package ex3;

import java.io.*;

public class CharArrayReaderDemo {
    public static void main(String[] args) {
        String source = "Афанасий Фет\n" +
                "Кот поёт, глаза прищуря;\n" +
                "Мальчик дремлет на ковре.\n" +
                "На дворе играет буря,\n" +
                "Ветер свищет на дворе.\n" +
                "\"Полно тут тебе валяться, -\n" +
                "Спрячь игрушки да вставай!\n" +
                "Подойди ко мне прощаться,\n" +
                "Да и спать себе ступай\".\n" +
                "Мальчик встал, а кот глазами\n" +
                "Проводил и все поёт;\n" +
                "В окна снег валит клоками,\n" +
                "Буря свищет у ворот.\n" +
                "\n" + "***";

        int length = source.length();
        char[] arr = new char[length];
        source.getChars(0, length, arr, 0);
        int i;
        try (CharArrayReader input = new CharArrayReader(arr)) {
            System.out.println("input:");
            while ((i = input.read()) != -1)
                System.out.print((char) i);
            System.out.println();
        } catch (IOException e) {
            System.out.println("Ошибка ввода-вывода:" + e);
        }
        try (CharArrayReader input = new CharArrayReader(arr, 0, arr.length / 2)) {
            System.out.println("input:");
            while ((i = input.read()) != -1)
                System.out.print((char) i);
            System.out.println();
        } catch (IOException e) {
            System.out.println("Ошибка ввода-вывода:" + e);
        }
    }
}
