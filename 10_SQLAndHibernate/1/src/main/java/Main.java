import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Main
{
    public static void main(String[] args)
    {
        String url = "jdbc:mysql://localhost:3306/skillbox?allowPublicKeyRetrieval=true&serverTimezone=Europe/Moscow&useSSL=false";
        String user = "root";
        String pas = "test";

        try {
            Connection connection = DriverManager.getConnection(url, user, pas);

            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT c1.name, s1.course_id, s1.monts, AVG(s1.conts) as 'srkolvo' FROM\n" +
                    "(SELECT course_id, MONTH(subscription_date) as monts, COUNT(MONTH(subscription_date)) as conts FROM Subscriptions GROUP BY course_id, monts) as s1 LEFT JOIN Courses as c1 ON c1.id=s1.course_id GROUP BY s1.course_id, s1.monts;");

            while (resultSet.next())
            {
              String parovozik = "";
                String courseName = resultSet.getString("name");
                parovozik = "" + courseName;
                courseName = resultSet.getString("monts");
                parovozik += " месяц = " + courseName;
                courseName = resultSet.getString("srkolvo");
                parovozik += " количество покупок в месяц = " + courseName;
              System.out.println(parovozik);
            }

        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }


    }
}
