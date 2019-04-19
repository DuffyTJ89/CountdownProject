//source:
//https://examples.javacodegeeks.com/software-development/mongodb/mongodb-and-jsp-servlet-example/
package ie.gmit.sw;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import com.mongodb.BasicDBList;
import com.mongodb.DBCursor;
import com.mongodb.client.MongoCursor;
import org.bson.Document;
import com.mongodb.BasicDBObject;
import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class MongoDBUtil {

	private static final int PORT_NO = 27017;
	private static final String URL = "localhost";
	private static final String DB_NAME = "user_records";

	private static MongoClient mongoClntObj;
	private static MongoDatabase db;
	
	private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");

	// Method to make a connection to the mongodb server listening on a default port
	private static MongoClient getConnection() throws Throwable {
		if (mongoClntObj == null) {
			mongoClntObj = new MongoClient(URL, PORT_NO);
		}
		return mongoClntObj;
	}

	private static MongoDatabase getDB() throws Throwable {
		if (db == null) {
			db = getConnection().getDatabase(DB_NAME);
		}
		return db;
	}

	// Method to search a user in the mongodb
	public static boolean searchUserInDb(String loginId, String loginPwd) throws Throwable {
		boolean userFound = false;

		// Get the mongodb collection.
		MongoCollection<Document> col = getDB().getCollection("admin");

		// Get the particular record from the mongodb collection
		List<BasicDBObject> obj = new ArrayList<BasicDBObject>();
		obj.add(new BasicDBObject("id", loginId));
		obj.add(new BasicDBObject("pwd", loginPwd));

		// Form a where query
		BasicDBObject whereQuery = new BasicDBObject();
		whereQuery.put("$and", obj);
		System.out.println("Mongo query: " + whereQuery.toString());

		FindIterable<Document> cursor = col.find(whereQuery);
		for (Document doc : cursor) {
			System.out.println("Found?: " + doc);
			userFound = true;
		}
		return userFound;
	}// searchUserInDb

	// Method to save user results to the database
	public static void saveResult(String userName, int gameScore) throws Throwable {
		MongoCollection<Document> col = getDB().getCollection("games");
		String dateNow = DATE_FORMAT.format(new Date());
		// Add Document to Database/Collection

			Document myNewDoc = new Document();// Create a new Mongo Document

			System.out.println("Add Documents to Database/Collection");
			myNewDoc.append("name", userName).append("score", gameScore).append("date", dateNow);

			col.insertOne(myNewDoc);
	}//saveResult
	
	public static List<GameResult> getTopTen() throws Throwable {
		List<GameResult> result = new ArrayList<>();

		MongoCollection<Document> collection = getDB().getCollection("games");

        MongoCursor<Document> cur = collection.find().iterator();

        while (cur.hasNext()) {
			List<Object> values = new ArrayList(cur.next().values());

			GameResult gameResult = new GameResult();
			gameResult.userName = (String) values.get(1); //1 is name
			gameResult.gameScore = (int) values.get(2); //2 is score
			gameResult.date = (String) values.get(3); //3 is date

			result.add(gameResult);
        }
		return result;
	}//getTopTen

}// MongoDBUtil
