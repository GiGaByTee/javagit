package java_io;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

public class Emp implements Externalizable {

    private String key;
    private String value;

    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeUTF(key);
        out.writeUTF(value);

    }

    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        this.key = in.readUTF();
        this.value = in.readUTF();
    }

    public Emp(String key, String value) {
        this.key = key;
        this.value = value;
    }

    public Emp(){}

    public String toString(){
        return "Key = " + key + ", Value = " + value;
    }

}
