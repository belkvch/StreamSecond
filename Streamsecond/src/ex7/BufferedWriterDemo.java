package ex7;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class BufferedWriterDemo {
    public static void main(String[] args) {
        long startTime, elapsedTime;
        BufferedWriter bw = null;
        FileWriter fw = null;
        String mycontent = "Константин Бальмонт\r\n" +
                "Снежинка\r\n" +
                "Светло-пушистая, Снежинка белая,\r\n"
                + "Какая чистая, Какая смелая!\r\n" +
                "Дорогой бурною Легко проносится,\r\n" +
                "Не в высь лазурную, На землю просится.\r\n"
                + "Лазурь чудесную Она покинула,\r\n" +
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
                "Буря свищет у ворот.\r\n";

        try {
            File file = new File("myfile.txt");
            if (!file.exists()) {
                file.createNewFile();
            }
            fw = new FileWriter(file);
            startTime = System.nanoTime();
            fw.write(mycontent);
            System.out.println("Время на запись с помощью FileWriter:" + (System.nanoTime() - startTime) + " nanosec");
            System.out.println("Файл записан успешно");

            bw = new BufferedWriter(fw);
            startTime = System.nanoTime();
            bw.write(mycontent);
            System.out.println("Время на запись с помощью BufferedWriter:" + (System.nanoTime() - startTime)+" nanosec");
            System.out.println("Файл записан успешно");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (bw != null)
                    bw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (fw != null)
                    fw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
