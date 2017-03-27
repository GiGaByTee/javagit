package serialization;

import java.io.*;

public class RWHelper {

    public static String read(String path){
        String result = "";
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String temp;
            while ((temp = br.readLine()) !=null){
                result +=temp + "\n";
            }
        }catch (IOException e){
            e.printStackTrace();
        }
        return result;
    }

    public static void write(String data, String path){
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(path))) {
            bw.write(data);
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public static void append(String data, String path){
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(path, true))) {
            bw.write(data);
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
