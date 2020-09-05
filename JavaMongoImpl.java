import java.util.Iterator;

import org.bson.Document;

import com.mongodb.BasicDBObject;
import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;

public class JavaMongoImpl {
	public static void main(String[] args) {
		
		// Creating a Mongo client 
		MongoClient mongoClient = new MongoClient( "localhost" , 27017 ); 
		System.out.println("Created Mongo Connection successfully");
		
		MongoDatabase db = mongoClient.getDatabase("youtube");
		System.out.println("Get database is successful");
		
		//creating collection or get collection if exists.
		MongoCollection<Document>  collection= db.getCollection("channels");
		System.out.println("collection created ");
		
		//Inserting sample records by creating documents.
		/*
		 * Document doc =new Document("name","SimplifyingTech"); doc.append("id",101);
		 * doc.append("Subscribers",100); doc.append("Genre", "Programming");
		 * collection.insertOne(doc); System.out.println("Insert is completed");
		 * 
		 * Document doc2 =new Document("name","CarryMinati"); doc2.append("id",102);
		 * doc2.append("Subscribers",24000000); doc2.append("Genre", "Comedy");
		 * collection.insertOne(doc2); System.out.println("Insert is completed");
		 */
		
		//Listing All Mongo Documents in Collection
		FindIterable<Document> iterDoc = collection.find();
		int i = 1;
		// Getting the iterator
		System.out.println("Listing All Mongo Documents");
		Iterator it = iterDoc.iterator();
		while (it.hasNext()) {
		    System.out.println(it.next());
		    i++;
		}
		//specific document retrieving in a collection
		BasicDBObject searchQuery = new BasicDBObject();
		searchQuery.put("name", "SimplifyingTech");
		System.out.println("Retrieving specific Mongo Document");
		MongoCursor<Document> cursor = collection.find(searchQuery).iterator();
		while (cursor.hasNext()) {
		    System.out.println(cursor.next());
		}
		
		
		
		/*
		 * collection.updateOne(Filters.eq("name", "SimplifyingTech"),
		 * Updates.set("Genre", "Coding"));
		 * System.out.println("Document updated successfully..."); int j = 1; // Getting
		 * the iterator Iterator<Document> itrNew = iterDoc.iterator();
		 * System.out.println("Document after update..."); while (itrNew.hasNext()) {
		 * System.out.println(itrNew.next()); j++; }
		 */
		
		/*
		 * collection.deleteOne(Filters.eq("name", "SimplifyingTech"));
		 * System.out.println("Document deleted successfully...");
		 * 
		 * int k = 1; // Getting the iterator Iterator<Document> it3 =
		 * iterDoc.iterator(); while (it3.hasNext()) { System.out.println(it3.next());
		 * k++; }
		 */
		
		// Dropping a Collection 
	      collection.drop(); 
	      System.out.println("Collection dropped successfully");


		
		
		
	}

}
