package temp;

import lombok.Cleanup;
import lombok.SneakyThrows;

import java.io.*;

/**
 * @author Xander Wu
 * @date 2022/11/4 16:48
 */
public class Main {

    @SneakyThrows({FileNotFoundException.class, IOException.class})
    public static void main(String[] args) {

        @Cleanup InputStream in = new FileInputStream("in.txt");
        @Cleanup OutputStream out = new FileOutputStream("out.txt");

        byte[] b = new byte[10000];
        while (true) {
            int r = in.read(b);
            if (r == -1) {
                break;
            }
            out.write(b, 0, r);
        }
    }

}
