import com.mongodb.DBCursor;
import com.mongodb.MongoClient;
import com.mongodb.client.*;
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

    static int countCollections = 0;

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
        for (Student student : students) {
            Document firstDocument = new Document()
                    .append("name", student.getName())
                    .append("age", student.getAge())
                    .append("Courses", student.getCourses().toString());

            // Вставляем документ в коллекцию
            collection.insertOne(firstDocument);
        }

        // Используем JSON-синтаксис для написания запроса (выбираем документы с Type=2)
        System.out.println("Количество документов в коллекции базы " + collection.countDocuments());
        System.out.println(collection.countDocuments(BsonDocument.parse("{age: {$gt: 40}}")));

        FindIterable<Document> fit = collection.find().sort(BsonDocument.parse("{age: 1}")).limit(1);

        MongoCursor<Document> cursor = fit.cursor();
        while (cursor.hasNext()) {
            Document document = cursor.next();
            System.out.println( " Самый молодой студент " + document.getString("name"));
        }

        fit = collection.find().sort(BsonDocument.parse("{age: -1}")).limit(1);
        cursor = fit.cursor();
        while (cursor.hasNext()) {
            Document document = cursor.next();
            System.out.println( " Список курсов самого старого студента " + document.getString("Courses"));
        }


    }
}