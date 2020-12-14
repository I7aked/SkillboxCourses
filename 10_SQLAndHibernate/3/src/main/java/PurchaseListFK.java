import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Embeddable
public class PurchaseListFK implements Serializable
{

    private String studentName;
    private String courseName;

    PurchaseListFK(){}

    public PurchaseListFK(String studentName, String courseName ){
        this.courseName = courseName;
        this.studentName = studentName;
    }

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


}
