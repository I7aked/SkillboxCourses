import javax.persistence.*;
import java.io.Serializable;

@Entity
@IdClass(KeyFK.class)
@Table(name = "LinkedPurchaseList")
public class LinkedPurchaseList implements Serializable
{
    LinkedPurchaseList(){}

    LinkedPurchaseList(KeyFK keyFK){
        studentId = keyFK.getStudentId();
        courseId = keyFK.getCourseId();
    }

    @Id
    @Column(name = "course_id")
    private Integer courseId;

    @Id
    @Column(name = "student_id")
    private Integer studentId;

    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }


}
