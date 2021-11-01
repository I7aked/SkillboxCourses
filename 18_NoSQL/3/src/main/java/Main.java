import com.google.gson.internal.bind.util.ISO8601Utils;
import com.mongodb.BasicDBObject;
import com.mongodb.DBCursor;
import com.mongodb.MongoClient;
import com.mongodb.client.*;
import com.mongodb.client.model.Updates;
import org.bson.BsonDocument;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.bson.json.JsonMode;
import org.bson.json.JsonWriterSettings;

import javax.print.Doc;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;

import static com.mongodb.client.model.Filters.eq;

public class Main {
    public static void main(String[] args) {

        MongoClient mongoClient = new MongoClient("127.0.0.1", 27017);
        MongoDatabase database = mongoClient.getDatabase("local");

        MongoCollection<Document> shopCollection = database.getCollection("shopCollection");
        MongoCollection<Document> productCollection = database.getCollection("productCollection");

        shopCollection.drop();
        productCollection.drop();

        ShopCollection shop = new ShopCollection();
        ProductCollection product = new ProductCollection();

        boolean flag = true;
        while (flag) {
            System.out.println("Введите команду");
            Scanner scanner = new Scanner(System.in);
            String[] token = scanner.nextLine().split(" ");

            try {
                switch (token[0]) {
                    case "1":
                        shopCollection.insertOne(shop.addShop(token[1]));
                        System.out.println("OK");
                        break;
                    case "2":
                        productCollection.insertOne(product.addProduct(token[1], token[2]));
                        System.out.println("OK");
                        break;
                    case "3":
                        shopCollection.updateOne(shop.answerFirst(token[2]), shop.answerSecond(token[1]));
                        System.out.println("OK");
                        break;
                    case "exit":
                        flag = false;
                        break;
                    case "4":
                        List<Document> documentList = querry();

                        MongoCursor<Document> cursor = shopCollection.aggregate(documentList).cursor();
                        while (cursor.hasNext()) {
                            Document document = cursor.next();
                            System.out.println(" минимальная цена товара " + document.getString("minprice"));
                            System.out.println(" максимальная цена товара " + document.getString("maxprice"));
                            System.out.println(" средняя цена товара " + document.getString("avgprice"));
                            System.out.println(" всего различных продуктов  " + document.getInteger("uniproduct"));
                            System.out.println(" Статистика по магазину - " + document.get("_id").toString().replaceAll(".*=", "").replaceAll("}}", ""));
                            System.out.println();
                        }
                        break;
                    default:
                        System.out.println("Таих команд не существует");
                        break;
                }
            } catch (Exception exception) {
                exception.printStackTrace();
                System.out.println("Неправильный формат команды!");
            }

        }

    }

    private static List<Document> querry() {
        List<Document> listBson = new ArrayList<>();

        Document lookup = new Document("$lookup",
                new Document("from", "productCollection")
                        .append("localField", "products")
                        .append("foreignField", "product")
                        .append("as", "productList"));
        listBson.add(lookup);

        Document unwind = new Document("$unwind", new Document("path", "$productList"));
        listBson.add(unwind);

        Document group = new Document("$group",
                new Document("_id",
                        new Document("name", "$name"))
                        .append("minprice",
                                new Document("$min", "$productList.price"))
                        .append("maxprice",
                                new Document("$max", "$productList.price"))
                        .append("avgprice",
                                new Document("$avg", "$productList.price"))
                        .append("uniproduct",
                                new Document("$sum", 1)));
        listBson.add(group);

        return listBson;
    }
}
//db.shopCollection.aggregate([{$lookup: {from: "productCollection" , localField: "products" , foreignField: "product" , as :"product_list"}}, { $unwind:{path:"$product_list" }}, { $group: { _id: {name: "$name"},  minprice:{$min: "$product_list.price" }, maxprice:{$max: "$product_list.price" }, avgprice:{$avg:"$product_list.price"}, uniproduct:{$addToSet: "product_list.product"}   ,uniproduct:{$sum: 1 }     }}   ])
