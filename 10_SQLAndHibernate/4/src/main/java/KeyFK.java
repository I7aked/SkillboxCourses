import javax.persistence.*;
import java.io.Serializable;


@Embeddable
public class KeyFK implements Serializable
{
    public KeyFK(){}

    public KeyFK(String studentName, String courseName){
        this.courseName = courseName;
        this.studentName = studentName;
    }

    private String studentName;

    private String courseName;

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    @Override
    public boolean equals(Object object) {
        if (object instanceof KeyFK) {
            KeyFK pk = (KeyFK)object;
            return studentName.equals(pk.studentName) && courseName.equals(pk.courseName);
        } else {
            return false;
        }
    }
    @Override
    public int hashCode() {
        return studentName.hashCode() + courseName.hashCode();
    }

}
