package ex12;

import java.io.*;
import java.math.*;

public class SerializationDemo {
    public static void main(String[] args) {
        try (ObjectOutputStream objOStrm = new ObjectOutputStream(new FileOutputStream("serial"))) {
            Employee employee = new Employee("Петров", 21, new BigDecimal(20.5));
            System.out.println("сотрудник No1:" + employee);
            objOStrm.writeObject(employee);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (ObjectInputStream objIStrm = new ObjectInputStream(new FileInputStream("serial"))) {
            Employee employee = (Employee) objIStrm.readObject();
            System.out.println("сотрудник No1:" + employee);
        } catch (Exception е) {
            System.out.println("Исключение при десериализации:" + е);
        }
        System.exit(0);
    }
}
