package ie.gmit.sw;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
	
	private static SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
//TODO Check unhappy path

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
	public static void saveResult(String userName, int gameScore, String dateNow) throws Throwable {
		MongoCollection<Document> col = getDB().getCollection("games");		
		dateNow = dateFormat.format(new Date());
		// Add Document to Database/Collection
		try {
			Document myNewDoc = new Document();// Create a new Mongo Document

			System.out.println("Add Documents to Database/Collection");
			myNewDoc.append("name", userName).append("score", gameScore).append("date", dateNow);

			col.insertOne(myNewDoc);
			
			FindIterable<Document> findDocs = col.find();
			for (Document doc : findDocs) {// iterate over results of find()
				System.out.println(doc.toJson());
			}

		} catch (Exception e) {
			System.out.println("User " + (col.countDocuments() - 1) + " already added");
		}

		// mongoClntObj.close();
	}// saveResult
	
	public static void displayResults(String userName, int gameScore, String dateNow) throws Throwable {
		MongoCollection<Document> col = getDB().getCollection("games");
		
		// Get the particular record from the mongodb collection
		List<BasicDBObject> obj = new ArrayList<BasicDBObject>();
		obj.add(new BasicDBObject("name", userName).append("score", gameScore).append("date", dateNow));
		
		// Form a where query
		BasicDBObject whereQuery = new BasicDBObject();
		whereQuery.put("$and", obj); //Mongo query requires a dollar character
		System.out.println("Mongo query: " + whereQuery.toString());
		
		FindIterable<Document> cursor = col.find(whereQuery);
		for (Document doc : cursor) {
			System.out.println(doc.toJson());
		}
		
	}//displayResults

}// MongoDBUtil
