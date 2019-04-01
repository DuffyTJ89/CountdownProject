package ie.gmit.sw;

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
	
	// Method to save user results to the database
	public static void saveResult(String userName, int gameScore) throws Throwable {
		MongoCollection<Document> col = getDB().getCollection("games");
		FindIterable<Document> findDocs = col.find();
        System.out.println("find all docs in this collection");

        for (Document d : findDocs) {
            System.out.println(d.toJson());
        }//end for

        System.out.println();
        
      //Add Document to Database/Collection
        try {
            Document myNewDoc = new Document();//Create a new Mongo Document

            System.out.println("Add Documents to Database/Collection");
            myNewDoc.append("name", userName).append("score", gameScore);


            col.insertOne(myNewDoc);

            for (Document d : findDocs) {//iterate over results of find()
                System.out.println(d.toJson());
            }

        } catch (Exception e) {
            System.out.println("User " + (col.countDocuments() - 1) + " already added");
        }

        System.out.println();

        //mongoClntObj.close();
	}//saveResult
	

}// MongoDBUtil
