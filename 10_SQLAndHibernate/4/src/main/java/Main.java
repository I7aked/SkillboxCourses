import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.*;

public class Main {
    public static void main(String[] args) {

//        KeyFK keyFK = new KeyFK();
//        List<KeyFK> keyFKList = new ArrayList<>();

        StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
        Metadata metadata = new MetadataSources(registry).getMetadataBuilder().build();
        SessionFactory sessionfactory = metadata.getSessionFactoryBuilder().build();

        Session session = sessionfactory.openSession();
        Transaction transaction = session.beginTransaction();

        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<PurchaseList> query = builder.createQuery(PurchaseList.class);
        Root<PurchaseList> root = query.from(PurchaseList.class);
        query.select(root);
        List<PurchaseList> purchaseLists = session.createQuery(query).getResultList();

        for (PurchaseList purchase : purchaseLists) {

            String student = "From " + Students.class.getSimpleName() + " s " + " Where s.name = '" + purchase.getStudentName() + "'";
            String course = "From " + Course.class.getSimpleName() + " c " + " Where c.name = '" + purchase.getCourseName() + "'";

            List<Students> students = session.createQuery(student).getResultList();
            List<Course> courses = session.createQuery(course).getResultList();

//            keyFKList.add(new KeyFK(students.get(0).getId(),courses.get(0).getId()));
            LinkedPurchaseList linkedPurchaseList = new LinkedPurchaseList(new KeyFK(students.get(0).getId(), courses.get(0).getId()));
            session.saveOrUpdate(linkedPurchaseList);
        }
//        System.out.println(keyFKList.size());

//        for (int i = 0; i < keyFKList.size()-1; i++){
//        LinkedPurchaseList linkedPurchaseList = new LinkedPurchaseList(keyFKList.get(i));
//        session.saveOrUpdate(linkedPurchaseList);
//      }

        //получил имя и курс студента с пурчейза. Теперь надо сделать запрос в базу по hql, для получения id
        // потом тоже для студента и в конце записать всё в linkedPurchaselist

        transaction.commit();
        sessionfactory.close();

    }


}
