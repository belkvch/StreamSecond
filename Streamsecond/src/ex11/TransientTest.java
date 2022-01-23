package ex11;

import java.io.*;

public class TransientTest {
    public static void main(String[] args) throws Exception {
        DeviceInfo deviceInfo = new DeviceInfo("Iphone 8", "description", "A1644");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("store.txt"));
        objectOutputStream.writeObject(deviceInfo);
        objectOutputStream.close();

        ObjectInputStream OIS = new ObjectInputStream(new FileInputStream("store.txt"));
        deviceInfo = (DeviceInfo) OIS.readObject();
        System.out.println(deviceInfo);
    }
}
