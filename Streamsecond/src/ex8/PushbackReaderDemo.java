package ex8;

import java.io.*;

public class PushbackReaderDemo {
    public static void main(String[] args) {
        String string = " if (а == 4) а = 0 ;\n";
        char[] buf = new char[string.length()];
        string.getChars(0, string.length(), buf, 0);
        CharArrayReader in = new CharArrayReader(buf);
        int c;
        try (PushbackReader pushbackReader = new PushbackReader(in)) {
            while ((c = pushbackReader.read()) != -1) {
                switch (c) {
                    case '=':
                        if ((c = pushbackReader.read()) == '=') {
                            System.out.print(" равно ");
                        } else {
                            System.out.print(" присваивается значение ");
                            pushbackReader.unread(c);
                        }
                        break;
                    default:
                        System.out.print((char) c);
                        break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}