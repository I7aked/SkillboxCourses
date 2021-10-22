import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class ParseCSV {
    public static List<Student> ParseMongoCsv(String filePath) throws IOException {

        List<Student> students = new ArrayList<>();

        List<String> fileLines = Files.readAllLines(Paths.get(filePath));
        for (String fileLine : fileLines) {
            String[] splitedText = fileLine.split("\"");


                Student student = new Student();
                ArrayList<String> courses = new ArrayList<>();
                String[] studentNameAge = splitedText[0].split(",");
                student.setName(studentNameAge[0]);
                student.setAge(Integer.parseInt(studentNameAge[1]));

                String[] studentCourses = splitedText[1].split(",");
                for (int j = 0; j < studentCourses.length; j++) courses.add(studentCourses[j]);
                student.setCourses(courses);
                students.add(student);
            }

        return students;
    }


}
