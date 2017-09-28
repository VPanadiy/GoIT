package Java_Core.I_O_Stream;

import java.io.*;
import java.math.BigDecimal;
import java.util.Calendar;

/**
 * Created by Splayd on 12.12.2016.
 */
public class ObjectsStream {
    static final String dataFile = "invoicedata";

    static final BigDecimal[] prices = {
            new BigDecimal("19.99"),
            new BigDecimal("9.99"),
            new BigDecimal("15.99"),
            new BigDecimal("3.99"),
            new BigDecimal("4.99")};
    static final int[] units = {12, 8, 13, 29, 50};
    static final String[] docs = {"Java T-Shirt", "Java Mug", "Duke Juglling Dolls", "Java Pin", "Java Key Chain"};

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        try (final ObjectOutputStream out = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(dataFile)))) {
            out.writeObject(Calendar.getInstance());

            for (int i = 0; i < prices.length; i++) {
                out.writeObject(prices[i]);
                out.writeInt(units[i]);
                out.writeUTF(docs[i]);
            }
        }

        try (final ObjectInputStream in = new ObjectInputStream(new BufferedInputStream(new FileInputStream(dataFile)))) {

            Calendar date;
            BigDecimal price;
            int unit;
            String docs;
            BigDecimal total = new BigDecimal(0);

            date = (Calendar) in.readObject();
            System.out.format("On %tA, %<tB %<te, %<tY:%n", date);

            try {
                while (true) {
                    price = (BigDecimal) in.readObject();
                    unit = in.readInt();
                    docs = in.readUTF();
                    System.out.format("You ordered %d units of %s at $%.2f%n", unit, docs, price);
                    total = total.add(price.multiply(new BigDecimal(unit)));
                }

            } catch (EOFException e) {
                System.out.println("Reached end of life.");
            }
            System.out.format("For a TOTAL of: $%.2f%n", total);
        }

    }
}
