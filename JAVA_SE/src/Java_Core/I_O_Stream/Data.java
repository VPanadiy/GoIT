package Java_Core.I_O_Stream;

import java.io.*;

/**
 * Created by Splayd on 12.12.2016.
 */
public class Data {
    static final String dataFile = "invoicedata";

    static final double[] prices = {19.99, 9.99, 15.99, 3.99, 4.99};
    static final int[] units = {12, 8, 13, 29, 50};
    static final String[] docs = {"Java T-Shirt", "Java Mug", "Duke Juglling Dolls", "Java Pin", "Java Key Chain"};

    public static void main(String[] args) throws IOException {

        DataInputStream in = null;

        try {
            DataOutputStream out = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(dataFile)));

            for (int i = 0; i < prices.length; i++) {
                out.writeDouble(prices[i]);
                out.writeInt(units[i]);
                out.writeUTF(docs[i]);
            }
            out.close();

            in = new DataInputStream(new BufferedInputStream(new FileInputStream(dataFile)));
            while (true) {
                double price = in.readDouble();
                int unit = in.readInt();
                String docs = in.readUTF();
                System.out.format("You ordered %d units of %s at $%.2f%n", unit, docs, price);
                double total = unit * price;
            }

        } catch (EOFException e) {
            System.out.println("Reached end of life.");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (in != null){
                in.close();
            }
        }
    }
}
