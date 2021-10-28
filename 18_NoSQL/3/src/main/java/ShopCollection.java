import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.mongodb.Cursor;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.internal.MongoDatabaseImpl;
import com.mongodb.client.model.Updates;
import com.mongodb.util.JSON;
import org.bson.BsonDocument;
import org.bson.Document;
import org.bson.conversions.Bson;

import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ShopCollection
{
//    Document doc = new Document();

    //из кейс вызов добавления магазина
    public Document addShop(String str, List<String> listShops)
    {
       return new Document(str,listToJson(listShops));
    }

    public Bson answerSecond (String newProduct, List<String> listProduct, String shopName)
    {
        listProduct.add(newProduct);
        String newListProducts = listToJson(listProduct);
        System.out.println("second " + listProduct);
        return Updates.combine(
                Updates.set(shopName,newListProducts));
    }

    public Bson answerFirst(String shopName, List<String> list)
    {
        return new Document().append(shopName, listToJson(list));
    }

    private String listToJson(List<String> list)
    {
        Gson prettyGson = new GsonBuilder().setPrettyPrinting().create();
        return prettyGson.toJson(list);

    }

}
