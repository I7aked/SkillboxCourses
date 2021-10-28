import org.bson.Document;

public class ProductCollection
{

//    Document doc = new Document();

    //из кейс вызов добавления товара
    public Document addProduct(String str, String price)
    {
        Document doc = new Document();
        doc.append("product",str);
        return doc.append("price",price);
    }
}
