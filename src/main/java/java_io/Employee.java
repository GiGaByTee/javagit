package java_io;

import java.io.Serializable;

public class Employee implements Serializable {
    private String name;
    private String address;
    private transient int SSN = 1;
    private static int number;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getSSN() {
        return SSN;
    }

    public void setSSN(int SSN) {
        this.SSN = SSN;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number1) {
        number = number1;
    }

    public String toString() {
        return String.format("java_io.Employee name = %s, address = %s, number = %s, SSN = %s", name, address, number, SSN);
    }

}
