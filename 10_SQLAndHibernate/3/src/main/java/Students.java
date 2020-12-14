import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "Students")
public class Students
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToMany(cascade = CascadeType.ALL, mappedBy="student")
    public List<Subscriptions> subscriptionsList;

    private String name;

//    @OneToMany(cascade = CascadeType.ALL)
//    public List<PurchaseList> purchaseListsName;

    private int age;

    @Column(name = "registration_date")
    private Date registrationDate;

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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Date getRegistrationDate() {
        return registrationDate;
    }

//    public List<PurchaseList> getPurchaseListsName() {
//        return purchaseListsName;
//    }
//
//    public void setPurchaseListsName(List<PurchaseList> purchaseListsName) {
//        this.purchaseListsName = purchaseListsName;
//    }

    public List<Subscriptions> getSubscriptionsList() {
        return subscriptionsList;
    }

    public void setSubscriptionsList(List<Subscriptions> subscriptionsList) {
        this.subscriptionsList = subscriptionsList;
    }

    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }
}
