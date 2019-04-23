//source: https://examples.javacodegeeks.com/software-development/mongodb/mongodb-and-jsp-servlet-example/
package ie.gmit.sw;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.mongodb.client.*;
import org.bson.Document;
import com.mongodb.BasicDBObject;
import com.mongodb.MongoClient;

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

	// search a user in the mongodb by name and password
	public static boolean searchUserInDb(String loginId, String loginPwd) throws Throwable {
		boolean userFound = false;
		// Get the mongodb collection.
		MongoCollection<Document> col = getDB().getCollection("user");

		// Get the particular record from the mongodb collection
		List<BasicDBObject> obj = new ArrayList<BasicDBObject>();
		obj.add(new BasicDBObject("id", loginId));
		obj.add(new BasicDBObject("pwd", loginPwd));
		// Form a where query
		BasicDBObject whereQuery = new BasicDBObject();
		whereQuery.put("$and", obj);
		System.out.println("Mongo login query: " + whereQuery.toString());

		FindIterable<Document> cursor = col.find(whereQuery);
		for (Document doc : cursor) {
			System.out.println("User Login Found: " + doc);
			userFound = true;
		}
		return userFound;
	}

	// search a user in the mongodb by name
	public static boolean searchUserByName(String loginId) throws Throwable {
		boolean userFound = false;

		MongoCollection<Document> col = getDB().getCollection("user");

		List<BasicDBObject> obj = new ArrayList<BasicDBObject>();
		obj.add(new BasicDBObject("id", loginId));

		BasicDBObject whereQuery = new BasicDBObject();
		whereQuery.put("$and", obj);
		System.out.println("Mongo signup query: " + whereQuery.toString());

		FindIterable<Document> cursor = col.find(whereQuery);
		for (Document doc : cursor) {
			System.out.println("User SignUp Found: " + doc);
			userFound = true;
		}
		return userFound;
	}// searchUserByName

	//save new user to database
	public static void userSignedUp(String UserName, String UserPassword) throws Throwable {
		MongoCollection<Document> col = getDB().getCollection("user");
		Document myNewDoc = new Document();
		myNewDoc.append("id", UserName).append("pwd", UserPassword);
		col.insertOne(myNewDoc);
	}

	// save user results to the database
	public static void saveResult(String userName, int gameScore) throws Throwable {
		MongoCollection<Document> col = getDB().getCollection("games");
		String dateNow = DATE_FORMAT.format(new Date());
		// Add Document to Database/Collection

			Document myNewDoc = new Document();// Create a new Mongo Document

			System.out.println("Add Documents to Database/Collection");
			myNewDoc.append("name", userName).append("score", gameScore).append("date", dateNow);

			col.insertOne(myNewDoc);
	}

	//http://zetcode.com/db/mongodbjava/
	public static List<GameToDatabase> getTopTen() throws Throwable {
		List<GameToDatabase> result = new ArrayList<>();

		MongoCollection<Document> collection = getDB().getCollection("games");

        MongoCursor<Document> cur = collection.find().sort( new BasicDBObject( "score" , -1 ) ).limit(10).iterator();

        while (cur.hasNext()) {
			List<Object> values = new ArrayList(cur.next().values());

			GameToDatabase gameResult = new GameToDatabase();
			gameResult.userName = (String) values.get(1); //1 is name
			gameResult.gameScore = (int) values.get(2); //2 is score
			gameResult.date = (String) values.get(3); //3 is date

			result.add(gameResult);
        }
		return result;
	}//getTopTen

}// MongoDBUtil
