import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class Main
{
    public static void main(String[] args) {

        StandardServiceRegistry registry =new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
        Metadata metadata = new MetadataSources(registry).getMetadataBuilder().build();
        SessionFactory sessionfactory = metadata.getSessionFactoryBuilder().build();

        Session session = sessionfactory.openSession();
        Transaction transaction = session.beginTransaction();

        Course course = session.get(Course.class,12);
        System.out.println( course.getName());

        transaction.commit();
        sessionfactory.close();



    }


}
