package java_io;

import java.io.*;

public class SerializeDemo {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Employee e = new Employee();
        e.setName("Nazar");
        e.setAddress("Lviv");
        e.setNumber(123);
        SerializeUtil.serializeObj(e, "employee.ser");
        Employee emp = (Employee) SerializeUtil.deserializeObj("employee.ser");
        System.out.println(emp);

        Emp e1 = new Emp("Oleg", "New York");
        FileOutputStream outputStream = new FileOutputStream("employee1.ser");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
        e1.writeExternal(objectOutputStream);
        objectOutputStream.flush();
        outputStream.close();

        FileInputStream inputStream = new FileInputStream("employee1.ser");
        ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
        Emp newEmp = new Emp();
        newEmp.readExternal(objectInputStream);
        objectInputStream.close();
        inputStream.close();
        System.out.println(newEmp);
    }
}