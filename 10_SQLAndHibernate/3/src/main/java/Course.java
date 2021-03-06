import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Courses")
public class Course
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

//    @OneToMany(cascade = CascadeType.ALL)
//    public List <Subscriptions> subscriptionsList;

    private String name;

//    @OneToMany(cascade = CascadeType.ALL)
//    public List <PurchaseList> purchaseLists;

    private int duration;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "enum")
    private CourseType type;

    private String description;

    @ManyToOne(cascade = CascadeType.ALL)
    private Teachers teacher;

    @Column(name = "students_count")
    private int studentsCount;

    private int price;

    @Column(name = "price_per_hour")
    private float pricePerHour;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "Subscriptions",
        joinColumns = {@JoinColumn(name = "course_id")},
        inverseJoinColumns = {@JoinColumn(name = "student_id")})
    public  List<Students> studentsList;

    public List<Subscriptions> getSubscription() {
        return subscription;
    }

    public void setSubscription(List<Subscriptions> subscription) {
        this.subscription = subscription;
    }

    @OneToMany(cascade = CascadeType.ALL, mappedBy="course")
    private List <Subscriptions> subscription;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public CourseType getType() {
        return type;
    }

    public void setType(CourseType type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Teachers getTeacher() {
        return teacher;
    }

    public void setTeacher(Teachers teacher) {
        this.teacher = teacher;
    }

    public int getStudentsCount() {
        return studentsCount;
    }

    public void setStudentsCount(int studentsCount) {
        this.studentsCount = studentsCount;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public float getPricePerHour() {
        return pricePerHour;
    }

    public void setPricePerHour(float pricePerHour) {
        this.pricePerHour = pricePerHour;
    }

    public List<Students> getStudentsList() {
        return studentsList;
    }

    public void setStudentsList(List<Students> studentsList) {
        this.studentsList = studentsList;
    }

//    public List<Subscriptions> getSubscriptionsList() {
//        return subscriptionsList;
//    }
//
//    public void setSubscriptionsList(List<Subscriptions> subscriptionsList) {
//        this.subscriptionsList = subscriptionsList;
//    }
//
//    public List<PurchaseList> getPurchaseLists() {
//        return purchaseLists;
//    }
//
//    public void setPurchaseLists(List<PurchaseList> purchaseLists) {
//        this.purchaseLists = purchaseLists;
//    }
}
