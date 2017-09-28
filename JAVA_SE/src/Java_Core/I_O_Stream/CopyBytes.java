package Java_Core.I_O_Stream;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Used only for main directory of project (/src)
 * Created by Splayd on 12.12.2016.
 */
public class CopyBytes {
    public static void main(String[] args) throws IOException {
        try (final FileInputStream in = new FileInputStream("i_test.txt");
             FileOutputStream out = new FileOutputStream("o_test.txt");) {
            int c;
            while ((c = in.read()) != -1) {
                out.write(c);
            }
        }

    }
}
