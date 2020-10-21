package BaseDeDatos;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;

import com.google.gson.Gson;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.MongoException;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;



public class conexionMongoAtlas {
	static Gson gson = new Gson();
	static MongoClientURI uri = new MongoClientURI("mongodb://MaximoDiNapoli:pelele123@cluster0-shard-00-00.9gizt.gcp.mongodb.net:27017,cluster0-shard-00-01.9gizt.gcp.mongodb.net:27017,cluster0-shard-00-02.9gizt.gcp.mongodb.net:27017/RompePalabras?ssl=true&replicaSet=atlas-117qw1-shard-0&authSource=admin&retryWrites=true&w=majority");
	static MongoClient mongoClient = new MongoClient(uri);
	static MongoDatabase RompePalabras = mongoClient.getDatabase("RompePalabras");
    static MongoCollection<Document> collectionUsuarios = RompePalabras.getCollection("usuarios");
    static MongoCollection<Document> collectionGames = RompePalabras.getCollection("games");


	public static void main(String[] args) {
	    Usuarios usuario1 = new Usuarios();
		collectionUsuarios.insertOne(insertarUsuario(usuario1));
		getAllUsuarios();
		getAllGames();
	}
	
	public static Document insertarUsuario(Usuarios usuario1) {
		Gson gson = new Gson();
	    String nombre = "username";
	    String id = "id";
	    String email = "email";
	    String elo = "elo";
	    String JSONuser = gson.toJson(nombre);
	    String JSONid = gson.toJson(id);
	    String JSONemail = gson.toJson(email);
	    String JSONelo = gson.toJson(elo);
	    
	    String SetNombre = usuario1.getUsername();
	    int SetId = usuario1.getId();
	    String SetEmail = usuario1.getEmail();
	    int SetElo = usuario1.getElo();
	    Document usuarioJson = new Document();
	    usuarioJson.put(JSONuser, SetNombre);
	    usuarioJson.put(JSONid, SetId);
	    usuarioJson.put(JSONemail, SetEmail);
	    usuarioJson.put(JSONelo, SetElo);
	    return usuarioJson;
	}
	
	public static void getAllUsuarios(){
		Gson gson = new Gson();
		FindIterable<Document> find = collectionUsuarios.find();
        try( MongoCursor<Document> cursor = find.iterator() ) 
        {
            while(cursor.hasNext())
            {
                System.out.println(gson.toJson(cursor.next()));
            }
        }
	}
	
	public static void getAllGames(){
		Gson gson = new Gson();
		FindIterable<Document> find = collectionGames.find();
        try( MongoCursor<Document> cursor = find.iterator() ) 
        {
            while(cursor.hasNext())
            {
                System.out.println(gson.toJson(cursor.next()));
            }
        }
	}
}
