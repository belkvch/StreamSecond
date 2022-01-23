package ex10;

import java.io.*;

class WorkWithFile {
    public static void main(String[] args) {
        String userFileName = "";
        System.out.println("\nТестирование работы с файлом\n");
        String fileString = "\n";

        try {
            PrintWriter printWriterConsole = new PrintWriter(new OutputStreamWriter(System.out, "UTF-8"), true);
            printWriterConsole.println("\nВведите имя файла:");
            BufferedReader bufferedReaderConsole = new BufferedReader(new InputStreamReader(System.in, "UTF-8"));
            userFileName = bufferedReaderConsole.readLine();
            printWriterConsole.println("\nИщем файл " + userFileName);
            try {
                BufferedReader bufferedReaderFile = new BufferedReader(new InputStreamReader(new FileInputStream(userFileName), "UTF-8"));
                printWriterConsole.println("\nФайл " + userFileName + " найден.\n");
                BufferedWriter bufferedWriterFile = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("Copy " + userFileName), "UTF-8"));
                printWriterConsole.println("\nСодержимое файла " + userFileName + ":\n");

                do {
                    fileString = bufferedReaderFile.readLine();
                    if (fileString != null) {
                        printWriterConsole.println(fileString);
                        bufferedWriterFile.write(fileString);
                        bufferedWriterFile.newLine();
                    }
                } while (fileString != null);
                printWriterConsole.println("\nДанные успешно записаны в файл " + "Copy " + userFileName + "\n");
                bufferedWriterFile.close();
            } catch (IOException e) {
                System.out.println("error");
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

