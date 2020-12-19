import javax.persistence.*;
import java.io.Serializable;


@Embeddable
public class KeyFK implements Serializable
{
    public KeyFK(){}

    public KeyFK(Integer studentId, Integer courseId){
        this.courseId = courseId;
        this.studentId = studentId;
    }

    private Integer studentId;

    private Integer courseId;

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    @Override
    public boolean equals(Object object) {
        if (object instanceof KeyFK) {
            KeyFK pk = (KeyFK)object;
            return studentId.equals(pk.studentId) && courseId.equals(pk.courseId);
        } else {
            return false;
        }
    }
    @Override
    public int hashCode() {
        return studentId.hashCode() + courseId.hashCode();
    }

}
