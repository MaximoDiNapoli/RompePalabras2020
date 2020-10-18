package BaseDeDatos;

import org.bson.Document;

import com.google.gson.Gson;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.MongoException;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Projections;



public class conexionMongoAtlas {

	public static void main(String[] args) {
		Gson gson = new Gson();
		MongoClientURI uri = new MongoClientURI("mongodb://MaximoDiNapoli:pelele123@cluster0-shard-00-00.9gizt.gcp.mongodb.net:27017,cluster0-shard-00-01.9gizt.gcp.mongodb.net:27017,cluster0-shard-00-02.9gizt.gcp.mongodb.net:27017/RompePalabras?ssl=true&replicaSet=atlas-117qw1-shard-0&authSource=admin&retryWrites=true&w=majority");
		MongoClient mongoClient = new MongoClient(uri);
		MongoDatabase RompePalabras = mongoClient.getDatabase("RompePalabras");
	    MongoCollection<Document> collectionUsuarios = RompePalabras.getCollection("usuarios");
	    FindIterable<Document> find = collectionUsuarios.find();
        try( MongoCursor<Document> cursor = find.iterator() ) 
        {
            while(cursor.hasNext())
            {
                System.out.println(gson.toJson(cursor.next()));
            }
        }
        catch(MongoException e)
        {
            System.out.println(e.getMessage());
        }
	}
}
