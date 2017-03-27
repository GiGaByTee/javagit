package serialization;

import java.io.*;

public class StreamHelper {

    public static String read(String path) {
        String result = "";
        try (InputStream is = new FileInputStream(path)) {
            int temp;
            while ((temp = is.read()) != -1) {
                result += (char) temp;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    public static void write(String data, String path) {
        try (OutputStream os = new FileOutputStream(path)) {
            os.write(data.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void append(String data, String path) {
        try (OutputStream os = new FileOutputStream(path, true)) {
            os.write(data.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
