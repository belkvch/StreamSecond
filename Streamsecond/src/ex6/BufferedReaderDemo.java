package ex6;

import java.io.*;
//import java.util.logging.Level;
//import java.util.logging.Logger;

public class BufferedReaderDemo {
    public static void main(String[] args) {
        BufferedReader brFirst = null;
        BufferedReader brSecond = null;

        try {
            brFirst = new BufferedReader(new FileReader("тест.txt"));
            System.out.println("Reading the file using readLine() method:");
            String contentLine = brFirst.readLine();
            while (contentLine != null) {
                System.out.println(contentLine);
                contentLine = brFirst.readLine();
            }

            brSecond = new BufferedReader(new FileReader("Фет.txt"));
            System.out.println("Reading the file using read() method:");
            int num;
            char ch;
            while ((num = brSecond.read()) != -1) {
                ch = (char) num;
                System.out.print(ch);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (brFirst != null) brFirst.close();
                if (brSecond != null) brSecond.close();
            } catch (IOException e) {
                System.out.println("Error in closing the BufferedReader");
            }
        }
    }
}
