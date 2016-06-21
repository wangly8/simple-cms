package test.mongodb;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;

public class MongoTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			MongoClient mongo = new MongoClient("localhost" , 27017);
			MongoDatabase mongoDatabase = mongo.getDatabase("test");
			MongoCollection<Document> collection = mongoDatabase.getCollection("user");
			
			FindIterable<Document> findIterable = collection.find();  
	        MongoCursor<Document> mongoCursor = findIterable.iterator();  
	        while(mongoCursor.hasNext()){  
	            System.out.println(mongoCursor.next());  
	        }  
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
