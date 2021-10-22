import com.mongodb.MongoClient;
import com.mongodb.client.ListDatabasesIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.BsonDocument;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.bson.json.JsonMode;
import org.bson.json.JsonWriterSettings;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.function.Consumer;

public class Main {

    static int countCollections =0;

    public static void main(String[] args) throws IOException {

        String filePath = "src/resources/mongo.csv";
        List<Student> students = ParseCSV.ParseMongoCsv(filePath);

        MongoClient mongoClient = new MongoClient("127.0.0.1", 27017);
        MongoDatabase database = mongoClient.getDatabase("local");

        // Создаем коллекцию
        MongoCollection<Document> collection = database.getCollection("TestSkillDemo");

        // Удалим из нее все документы
        collection.drop();

        // Создадим первый документ
        for (Student student :students)
        {
            Document firstDocument = new Document()
                    .append("name", student.getName())
                    .append("age", student.getAge())
                    .append("Courses", student.getCourses().toString());

            // Вставляем документ в коллекцию
            collection.insertOne(firstDocument);
        }

        // Используем JSON-синтаксис для написания запроса (выбираем документы с Type=2)
        System.out.println("Количество документов в коллекции базы "+ collection.countDocuments());

        BsonDocument query = BsonDocument.parse("{age: {$gt: 40}}");
        collection.find(query).
                forEach((Consumer<Document>) document -> {
            System.out.println("этот студент старше 40:\n" + document);
        });
    }
}