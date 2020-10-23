package BaseDeDatos;

import java.util.Vector;

import org.bson.Document;

import com.google.gson.Gson;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.sun.tools.javac.util.List;



public class conexionMongoAtlas {
	static Gson gson = new Gson();
	static MongoClientURI uri = new MongoClientURI("mongodb://MaximoDiNapoli:pelele123@cluster0-shard-00-00.9gizt.gcp.mongodb.net:27017,cluster0-shard-00-01.9gizt.gcp.mongodb.net:27017,cluster0-shard-00-02.9gizt.gcp.mongodb.net:27017/RompePalabras?ssl=true&replicaSet=atlas-117qw1-shard-0&authSource=admin&retryWrites=true&w=majority");
	static MongoClient mongoClient = new MongoClient(uri);
	static MongoDatabase RompePalabras = mongoClient.getDatabase("RompePalabras");
    static MongoCollection<Document> collectionUsuarios = RompePalabras.getCollection("usuarios");
    static MongoCollection<Document> collectionGames = RompePalabras.getCollection("games");


	public static void main(String[] args) {
		getUsuarioEspecifico(1);
	}
	
	public static String insertarUsuario(Usuarios usuario1) {
		Gson gson = new Gson();
	    String nombre = "username";
	    String id = "id";
	    String friends = "friends";
	    String email = "email";
	    String elo = "elo";
	    String JSONuser = gson.toJson(nombre);
	    String JSONid = gson.toJson(id);
	    String JSONfriends =gson.toJson(friends);
	    String JSONemail = gson.toJson(email);
	    String JSONelo = gson.toJson(elo);
	    
	    String SetNombre = usuario1.getUsername();
	    int SetId = usuario1.getId();
	    Vector SetFriends = usuario1.getFriends();
	    String SetEmail = usuario1.getEmail();
	    int SetElo = usuario1.getElo();
	    Document usuarioJson = new Document();
	    usuarioJson.put(JSONuser, SetNombre);
	    usuarioJson.put(JSONid, SetId);
	    usuarioJson.put(JSONfriends, SetFriends);
	    usuarioJson.put(JSONemail, SetEmail);
	    usuarioJson.put(JSONelo, SetElo);
	    collectionUsuarios.insertOne(usuarioJson);
	    return "usuario Agregado";
	}
	
	public static String insertarGame(games game1) {
		Gson gson = new Gson();
	    String game_id = "game_id";
	    String player1_id = "player1_id";
	    String player2_id = "player2_id";
	    String winner = "winner";
	    String puntajePlayer1 = "puntajePlayer1";
	    String puntajePlayer2 = "puntajePlayer2";
	    String JSONgame_id = gson.toJson(game_id);
	    String JSONplayer1_id = gson.toJson(player1_id);
	    String JSONplayer2_id =gson.toJson(player2_id);
	    String JSONpuntajePlayer1 = gson.toJson(puntajePlayer1);
	    String JSONpuntajePlayer2 =gson.toJson(puntajePlayer2);
	    String JSONwinner = gson.toJson(winner);
	    
	    int SetWinner = game1.getWinner();
	    int SetId = game1.getGame_id();
	    int SetPlayer1_id = game1.getPlayer1_id();
	    int SetPlayer2_id = game1.getPlayer2_id();
	    int SetPuntajePlayer1 = game1.getPuntajePlayer1();
	    int SetPuntajePlayer2 = game1.getPuntajePlayer2();
	    Document gameJson = new Document();
	    gameJson.put(JSONwinner, SetWinner);
	    gameJson.put(JSONgame_id, SetId);
	    gameJson.put(JSONplayer1_id, SetPlayer1_id);
	    gameJson.put(JSONplayer2_id, SetPlayer2_id);
	    gameJson.put(JSONpuntajePlayer1, SetPuntajePlayer1);
	    gameJson.put(JSONpuntajePlayer2, SetPuntajePlayer2);
	    collectionGames.insertOne(gameJson);
	    return "game Agregado";
	}
	
	public static String getAllUsuarios(){
		FindIterable<Document> find = collectionUsuarios.find();
		String pepe = "";
        try( MongoCursor<Document> cursor = find.iterator() ) 
        {
            while(cursor.hasNext())
            {
                //System.out.println(gson.toJson(cursor.next()));
                pepe = pepe + "                  " + gson.toJson(cursor.next());
            }
        }
        return pepe;
	}
	
	public static void getAllGames(){
		FindIterable<Document> find = collectionGames.find();
        try( MongoCursor<Document> cursor = find.iterator() ) 
        {
            while(cursor.hasNext())
            {
                System.out.println(gson.toJson(cursor.next()));
            }
        }
	}
	
	public static String getUsuarioEspecifico(int idABuscar){
		FindIterable<Document> find = collectionUsuarios.find(Filters.eq("id", idABuscar));
		String pepe = "";
        try( MongoCursor<Document> cursor = find.iterator() ) 
        {
            while(cursor.hasNext())
            {
                System.out.println(gson.toJson(cursor.next()));
                pepe = pepe + "                  " + gson.toJson(cursor.next());
            }
        }
        return pepe;
		
	}
	
	public static String getGameEspecifico(int idABuscar){
		FindIterable<Document> find = collectionGames.find(Filters.eq("id", idABuscar));
		String pepe = "";
        try( MongoCursor<Document> cursor = find.iterator() ) 
        {
            while(cursor.hasNext())
            {
                System.out.println(gson.toJson(cursor.next()));
                pepe = pepe + "                  " + gson.toJson(cursor.next());
            }
        }
        return pepe;
	}
}
