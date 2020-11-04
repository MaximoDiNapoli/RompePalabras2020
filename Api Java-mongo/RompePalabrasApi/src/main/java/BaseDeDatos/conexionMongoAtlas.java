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
		//getUsuarioEspecifico(1);
		//getUsuarioEspecifico(2);
		//getUsuarioEspecifico(3);
		getUsuarioEspecifico(4);
		//getGameEspecifico(1);
	}
	
	/*
	public static String ajustarEloPostPartida(int idUsuario1, int idUsuario2, int UsuarioGanador) {
		FindIterable<Document> game1 = collectionGames.find(Filters.eq("id", idABuscar));
	}
	*/
	
	public static String insertarUsuario(Usuarios usuario1) {
	    String SetNombre = usuario1.getUsername();
	    int SetId = usuario1.getId();
	    Vector SetFriends = usuario1.getFriends();
	    String SetEmail = usuario1.getEmail();
	    int SetElo = usuario1.getElo();
	    Document usuarioJson = new Document();
	    usuarioJson.put("username", SetNombre);
	    usuarioJson.put("id", SetId);
	    usuarioJson.put("friends", SetFriends);
	    usuarioJson.put("email", SetEmail);
	    usuarioJson.put("elo", SetElo);
	    collectionUsuarios.insertOne(usuarioJson);
	    return "usuario Agregado";
	}
	
	public static String insertarGame(games game1) {
		Gson gson = new Gson();
	    int SetWinner = game1.getWinner();
	    int SetId = game1.getGame_id();
	    int SetPlayer1_id = game1.getPlayer1_id();
	    int SetPlayer2_id = game1.getPlayer2_id();
	    int SetPuntajePlayer1 = game1.getPuntajePlayer1();
	    int SetPuntajePlayer2 = game1.getPuntajePlayer2();
	    Document gameJson = new Document();
	    gameJson.put("winner", SetWinner);
	    gameJson.put("game_id", SetId);
	    gameJson.put("player1_id", SetPlayer1_id);
	    gameJson.put("player2_id", SetPlayer2_id);
	    gameJson.put("puntajePlayer1", SetPuntajePlayer1);
	    gameJson.put("puntajePlayer2", SetPuntajePlayer2);
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
	
	public static Document getUsuarioEspecifico(int idABuscar){
        Document usuarioBuscado = collectionUsuarios.find(new Document("id", idABuscar)).first();
        System.out.println("Usuario: " + usuarioBuscado.toJson());
        return usuarioBuscado;
    }
		
	public static Document getGameEspecifico(int idAABuscar){
        Document gameBuscado = collectionGames.find(new Document("game_id", idAABuscar)).first();
        System.out.println("Game: " + gameBuscado.toJson());
        return gameBuscado;
	}
}
