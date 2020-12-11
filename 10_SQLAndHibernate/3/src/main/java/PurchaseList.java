import javax.persistence.*;
import java.util.Date;

@Embeddable
@Table(name = "PurchaseList")
public class PurchaseList
{
    @Id
    @JoinColumn(name = "student_name")
    @ManyToOne(cascade = CascadeType.ALL)
    private Students studentName;

    @JoinColumn(name = "course_name")
    @ManyToOne(cascade = CascadeType.ALL)
    private Course courseName;

    @Column(name = "subscription_date")
    @OneToOne(cascade = CascadeType.ALL)
    private Subscriptions subscriptionDate;

    private int price;

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Students getStudentsName() {
        return studentName;
    }

    public void setStudentsName(Students studentName) {
        this.studentName = studentName;
    }

    public Course getCourseName() {
        return courseName;
    }

    public void setCourseName(Course courseName) {
        this.courseName = courseName;
    }

    public Subscriptions getSubscriptionDate() {
        return subscriptionDate;
    }

    public void setSubscriptionDate(Subscriptions subscriptionDate) {
        this.subscriptionDate = subscriptionDate;
    }

}
