import javax.persistence.*;
import java.io.Serializable;

@Entity
@IdClass(KeyFK.class)
@Table(name = "LinkedPurchaseList")
public class LinkedPurchaseList implements Serializable
{
    LinkedPurchaseList(){}

    LinkedPurchaseList(KeyFK keyFK){
        studentName = keyFK.getStudentName();
        courseName = keyFK.getCourseName();
    }

    @Id
    @Column(name = "course_name")
    private String courseName;

    @Id
    @Column(name = "student_name")
    private String studentName;

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }


}
