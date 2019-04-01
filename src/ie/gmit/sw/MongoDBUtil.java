package ie.gmit.sw;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.bson.Document;

import com.mongodb.BasicDBObject;
import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class MongoDBUtil {
	
    private static final int PORT_NO = 27010;
    private static final String URL = "localhost";
    private static final String DB_NAME = "user_records";
    

	private static MongoClient mongoClntObj;
	private static MongoDatabase db;
	
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
		boolean user_found = false;

		// Get the mongodb collection.
		MongoCollection<Document> col = getDB().getCollection("admin");

		// Get the particular record from the mongodb collection
		List<BasicDBObject> obj = new ArrayList<BasicDBObject>();
		obj.add(new BasicDBObject("id", loginId));
		obj.add(new BasicDBObject("pwd", loginPwd));

		// Form a where query
		BasicDBObject whereQuery = new BasicDBObject();
		whereQuery.put("$and", obj);
		System.out.println("Mongo query is?= " + whereQuery.toString());

		FindIterable<Document> cursor = col.find(whereQuery);
		for (Document doc : cursor) {
			System.out.println("Found?= " + doc);
			user_found = true;
		}
		return user_found;
	}// searchUserInDb

}// MongoDBUtil
