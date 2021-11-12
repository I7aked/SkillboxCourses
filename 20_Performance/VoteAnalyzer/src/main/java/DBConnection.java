import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DBConnection {

    private static Connection connection;

    private static String dbName = "my_connection";
    private static String dbUser = "bestuser";
    private static String dbPass = "bestuser";

    //    private static  StringBuilder insertQuery = new StringBuilder();
    private static long counts;
    private static List<StringBuilder> insertQuery = new ArrayList<>();
    private static StringBuilder query = new StringBuilder();

    public static Connection getConnection() {
        if (connection == null) {
            try {

                connection = DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/my_db?useSSL=false",
                        dbUser, dbPass);
                connection.createStatement().execute("DROP TABLE IF EXISTS voter_count");
                connection.createStatement().execute("CREATE TABLE voter_count(" +
                        "id INT NOT NULL AUTO_INCREMENT, " +
                        "name TINYTEXT NOT NULL, " +
                        "birthDate DATE NOT NULL, " +
                        "`count` INT NOT NULL, " +
                        "PRIMARY KEY(id))");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return connection;
    }

    public static void executeMultiInsert() throws SQLException {

        insertQuery.add(query);
        for (StringBuilder builder : insertQuery) {
            String sql = "INSERT INTO voter_count(name, birthDate, `count`)" +
                    "VALUES" + builder.toString() +
                    "ON DUPLICATE KEY UPDATE `count` = `count` + 1";
            DBConnection.getConnection().createStatement().execute(sql);
        }
        System.out.println(counts);

    }

    public static void countVoter(String name, String birthDay) throws SQLException {
        birthDay = birthDay.replace('.', '-');
        counts++;

        if (counts % 50000 == 1) {
            query = new StringBuilder();
        }

        query.append((query.length() == 0 ? "" : ",") + "('" + name + "', '" + birthDay + "', 1)");

        if (counts % 50000 == 0) {
            insertQuery.add(query);
        }
    }

    public static void printVoterCounts() throws SQLException {
        String sql = "SELECT name, birthDate, `count` FROM voter_count WHERE `count` > 1";
        ResultSet rs = DBConnection.getConnection().createStatement().executeQuery(sql);
        while (rs.next()) {
            System.out.println("\t" + rs.getString("name") + " (" +
                    rs.getString("birthDate") + ") - " + rs.getInt("count"));
        }
    }
}
