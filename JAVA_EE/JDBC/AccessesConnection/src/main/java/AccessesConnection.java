import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * Created by Vitaliy on 16.05.2017.
 */
public class AccessesConnection{

    public static void main(String[] args) {

        try {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            Connection conn = DriverManager.getConnection("jdbc:ucanaccess://C:\\\\Statica\\\\Database\\\\main.mdb");
            Statement s = conn.createStatement();

            // Fetch table
            String selTable = "SELECT * FROM Izmer;";
            s.execute(selTable);
            ResultSet rs = s.getResultSet();
            while ((rs != null) && (rs.next())) {
                System.out.println(rs.getString(3) + " : " + rs.getString(28));
            }

            // close and cleanup
            s.close();
            conn.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
