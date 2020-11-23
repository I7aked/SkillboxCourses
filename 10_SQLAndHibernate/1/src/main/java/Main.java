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
            ResultSet resultSet = statement.executeQuery("SELECT c.name, COUNT(MONTH(s.subscription_date))/12 AS avgMonts FROM Courses c JOIN Subscriptions s ON s.course_id = c.id WHERE YEAR(s.subscription_date)\n" +
                    " = 2018 GROUP BY c.name;");

            while (resultSet.next())
            {
              String parovozik = "";
                String courseName = resultSet.getString("c.name");
                parovozik = "" + courseName;
                courseName = resultSet.getString("avgMonts");
                parovozik += "!  среднее количество покупок в месяц = " + courseName;
              System.out.println(parovozik);
            }

        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }


    }
}
