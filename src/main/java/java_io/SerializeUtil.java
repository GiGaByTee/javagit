package java_io;

import java.io.*;

public class SerializeUtil {

    public static void serializeObj(Object o, String path) {
        try {
            FileOutputStream fileOut = new FileOutputStream(path);
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(o);
            out.close();
            fileOut.close();
            System.out.print(String.format("Data was saved in %s", path));
        } catch (IOException i) {
            i.printStackTrace();
        }
    }

    public static Object deserializeObj(String path) {
        Object o = null;
        try {
            FileInputStream fileIn = new FileInputStream(path);
            ObjectInputStream in = new ObjectInputStream(fileIn);
            o = in.readObject();
            in.close();
            fileIn.close();
        } catch (IOException i) {
            i.printStackTrace();
        } catch (ClassNotFoundException c) {
            System.out.println("java_io.Employee class not found");
            c.printStackTrace();
        }
        return o;
    }
}
