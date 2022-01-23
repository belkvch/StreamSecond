package ex12;

import java.io.*;
import java.math.*;

public class Employee implements Serializable {
    String surname;
    int age;
    BigDecimal salary;

    public Employee(String surname, int age, BigDecimal salary) {
        this.surname = surname;
        this.age = age;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Фамилия=" + surname + ";возраст=" + age + ";зарплата=" + salary;
    }
}
