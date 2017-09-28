package Java_Core.I_O_Stream;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by Splayd on 12.12.2016.
 */
public class CopyCharacters {
    public static void main(String[] args) throws IOException {
        FileReader inputStream = null;
        FileWriter outputStream = null;

        try {
            inputStream = new FileReader("i_test_character.txt");
            outputStream = new FileWriter("o_test_character.txt");
            int c;
            while ((c = inputStream.read()) != -1) {
                outputStream.write(c);
            }
        } finally {
            if (inputStream != null) {
                inputStream.close();
            }
            if (outputStream != null) {
                outputStream.close();
            }

        }
    }
}
