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

public class ShopCollection {
    public Document addShop(String name) {
        return Document.parse(String.format("{ name: \"%s\"}", name));
    }

    public Bson answerSecond(String newProduct) {
        return Updates.addToSet("products", newProduct);
    }

    public Bson answerFirst(String shopName) {
        return BsonDocument.parse(String.format("{name:\"%s\"}", shopName));
    }
}
