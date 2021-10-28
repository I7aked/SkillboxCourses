import com.mongodb.DBCursor;
import com.mongodb.MongoClient;
import com.mongodb.client.*;
import com.mongodb.client.model.Updates;
import org.bson.BsonDocument;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.bson.json.JsonMode;
import org.bson.json.JsonWriterSettings;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;

public class Main
{
    public static void main(String[] args) {

        MongoClient mongoClient = new MongoClient("127.0.0.1", 27017);
        MongoDatabase database = mongoClient.getDatabase("local");

        MongoCollection<Document> shopCollection = database.getCollection("shopCollection");
        MongoCollection<Document> productCollection = database.getCollection("productCollection");

        shopCollection.drop();
        productCollection.drop();

        ShopCollection shop = new ShopCollection();
        ProductCollection product = new ProductCollection();

        List<String> listProducts = new ArrayList<>();
        boolean flag = true;
        while (flag)
        {
            System.out.println("Введите команду");
            Scanner scanner = new Scanner(System.in);
            String[] scannerText =  scanner.nextLine().split(" ");

            try{
            switch (scannerText[0]){
                case "1" : shopCollection.insertOne(shop.addShop(scannerText[1], listProducts) );
                    System.out.println("OK");
                  break;
                case "2" : productCollection.insertOne(product.addProduct(scannerText[1],scannerText[2]));
                    System.out.println("OK");
                    break;
                case "3":
                    shopCollection.updateOne(shop.answerFirst(scannerText[2],listProducts ),shop.answerSecond(scannerText[1],listProducts, scannerText[2] ) );
//                    listProducts.add(scannerText[1]);
                    System.out.println("OK");
                    break;
                case "exit": flag = false;
                    break;
                default:
                    System.out.println("Таих команд не существует");
                    break;
            }
            }catch (Exception exception)
            {
                exception.printStackTrace();
                System.out.println("Неправильный формат команды!");
            }

        }

    }

}
