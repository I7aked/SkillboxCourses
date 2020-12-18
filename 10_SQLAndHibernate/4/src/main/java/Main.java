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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main
{
    public static void main(String[] args) {

//        Map<String,String> mapLinkedPurchaseList = new HashMap<>();

        StandardServiceRegistry registry =new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
        Metadata metadata = new MetadataSources(registry).getMetadataBuilder().build();
        SessionFactory sessionfactory = metadata.getSessionFactoryBuilder().build();

        Session session = sessionfactory.openSession();
        Transaction transaction = session.beginTransaction();

        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<PurchaseList> query = builder.createQuery(PurchaseList.class);
        Root<PurchaseList> root = query.from(PurchaseList.class);
        query.select(root);
        List<PurchaseList> purchaseLists = session.createQuery(query).getResultList();

        for (PurchaseList purchase: purchaseLists)
        {
            KeyFK keyFK = new KeyFK(purchase.getStudentName(),purchase.getCourseName());
            LinkedPurchaseList linkedPurchaseList = new LinkedPurchaseList(keyFK);
            session.update(linkedPurchaseList);
//            mapLinkedPurchaseList.put(purchase.getCourseName(),purchase.getStudentName());
        }

        transaction.commit();
        sessionfactory.close();

    }


}
