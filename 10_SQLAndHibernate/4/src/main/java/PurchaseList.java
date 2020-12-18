import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@IdClass(KeyFK.class)
@Table(name = "PurchaseList")
public class PurchaseList implements Serializable
{
    PurchaseList(){}

    PurchaseList(KeyFK keyFK){
        studentName = keyFK.getStudentName();
        courseName = keyFK.getCourseName();
    }

    @Id
    @Column(name = "student_name", insertable = false, updatable = false)
    private String studentName;

    @Id
    @Column(name = "course_name", insertable = false, updatable = false)
    private String courseName;

    @Column(name = "subscription_date")
    private Date subscriptionDate;

    private int price;

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
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

    public Date getSubscriptionDate() {
        return subscriptionDate;
    }

    public void setSubscriptionDate(Date subscriptionDate) {
        this.subscriptionDate = subscriptionDate;
    }

}
