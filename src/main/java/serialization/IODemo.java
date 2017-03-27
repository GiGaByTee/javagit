package serialization;

/*
Stream classes are byte-oriented classes, that mean all InputStream classes (Buffered and non-buffered)
read data byte by byte from stream and all OutputStream(Buffered and non-buffered) classes writes data byte by byte to the stream.
Stream classes are useful when you have small data or if you are dealing with binary files like images.

On the other hand Reader/Writer are character based classes.
These classes read or write one character at time from or into stream.
These classes extends either java.io.Reader (all character input classes) or java.io.Writer (all character output classes).
These classes are useful if you are dealing with text file or other textual stream. These classes are also Buffered and Non-Buffered
*/

public class IODemo {

    public static void main(String[] args) {
        // Reader
        String rs = RWHelper.read("nazar.txt");
        System.out.println(rs);

        RWHelper.write("Good Job!", "nazar.txt");
        rs = RWHelper.read("nazar.txt");
        System.out.println(rs);

        RWHelper.append("See you soon!", "nazar.txt");
        rs = RWHelper.read("nazar.txt");
        System.out.println(rs);

        // Stream
        String str = StreamHelper.read("nazar1.txt");
        System.out.println(str);

        StreamHelper.write("New string", "nazar1.txt");
        str = StreamHelper.read("nazar1.txt");
        System.out.println(str);

        StreamHelper.append("Append string", "nazar1.txt");
        str = StreamHelper.read("nazar1.txt");
        System.out.println(str);
    }
}
