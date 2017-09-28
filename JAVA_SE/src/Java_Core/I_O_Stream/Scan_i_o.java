package Java_Core.I_O_Stream;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/**
 * Created by Splayd on 12.12.2016.
 */
public class Scan_i_o {
    public static void main(String[] args) throws IOException {
        Scanner scanner = null;

        try {
            scanner = new Scanner(new BufferedReader(new FileReader("i_Scan_test.txt")));

            while (scanner.hasNext()) {
                System.out.println(scanner.next());
            }
        } finally {
            if (scanner != null) {
                scanner.close();
            }
        }
    }
}
