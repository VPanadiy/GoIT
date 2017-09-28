package Java_Core.Crypt;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by Splayd on 18.12.2016.
 */
public class Crypt_Decrypt_FromFile {

    public static void main(String[] args) throws IOException{
        FileReader inputStream = null;
        FileWriter outputStream = null;

        try {
            inputStream = new FileReader("D:\\MyProjects(JAVA)\\GoIT\\src\\Java_Core\\Crypt\\Default.txt");
            outputStream = new FileWriter("D:\\MyProjects(JAVA)\\GoIT\\src\\Java_Core\\Crypt\\CryptText.txt");
            int c;
            while ((c = inputStream.read()) != -1) {
                outputStream.write(c-1);
            }
        } finally {
            if (inputStream != null) {
                inputStream.close();
            }
            if (outputStream != null) {
                outputStream.close();
            }
        }

        try {
            inputStream = new FileReader("D:\\MyProjects(JAVA)\\GoIT\\src\\Java_Core\\Crypt\\CryptText.txt");
            outputStream = new FileWriter("D:\\MyProjects(JAVA)\\GoIT\\src\\Java_Core\\Crypt\\EnCryptText.txt");
            int c;
            while ((c = inputStream.read()) != -1) {
                outputStream.write(c+1);
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
