package ex2;

import java.io.*;

public class FileWriterDemo {
    public static void main(String[] args) throws IOException {
        String separator = System.getProperty("line.separator");
        String source = "Константин Бальмонт" + separator +
                "Снежинка\r\n" +
                "Светло-пушистая, Снежинка белая,\r\n" +
                "Какая чистая, Какая смелая!\r\n" +
                "Дорогой бурною Легко проносится,\r\n" +
                "Не в высь лазурную, На землю просится.\r\n" +
                "Лазурь чудесную Она покинула,\r\n" +
                "Себя в безвестную Страну низринула.\r\n" + "\r\n" +
                "***\r\n" +
                "Афанасий Фет\r\n" +
                "\r\n" +
                "Кот поёт, глаза прищуря;\r\n" +
                "Мальчик дремлет на ковре.\r\n" +
                "На дворе играет буря,\r\n" +
                "Ветер свищет на дворе.\r\n" +
                "\"Полно тут тебе валяться, -\r\n" +
                "Спрячь игрушки да вставай!\r\n" +
                "Подойди ко мне прощаться,\r\n" +
                "Да и спать себе ступай\".\r\n" +
                "Мальчик встал, а кот глазами\r\n" +
                "Проводил и все поёт;\r\n" +
                "В окна снег валит клоками,\r\n" +
                "Буря свищет у ворот.\r\n" +
                "\r\n";

        try (FileWriter f1 = new FileWriter("Бальмон.txt");
             FileWriter f2 = new FileWriter("Фет.txt")) {
            f1.write(source, 0, source.lastIndexOf("***"));
            f2.write(source, source.lastIndexOf("***"), source.length() - source.lastIndexOf("***"));
        } catch (IOException e) {
            System.out.println("Произошла ошибка ввода-вывода ");
        }
    }
}
