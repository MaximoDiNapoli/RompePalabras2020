package BaseDeDatos;

import java.util.Vector;

import org.bson.Document;
import org.bson.conversions.Bson;

import com.google.gson.Gson;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.result.UpdateResult;
import com.sun.tools.javac.util.List;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.FindOneAndUpdateOptions;
import com.mongodb.client.model.ReturnDocument;
import com.mongodb.client.model.UpdateOptions;
import com.mongodb.client.result.UpdateResult;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.bson.json.JsonWriterSettings;

import static com.mongodb.client.model.Filters.and;
import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.Updates.*;



public class conexionMongoAtlas {
	static Gson gson = new Gson();
	static MongoClientURI uri = new MongoClientURI("mongodb://MaximoDiNapoli:pelele123@cluster0-shard-00-00.9gizt.gcp.mongodb.net:27017,cluster0-shard-00-01.9gizt.gcp.mongodb.net:27017,cluster0-shard-00-02.9gizt.gcp.mongodb.net:27017/RompePalabras?ssl=true&replicaSet=atlas-117qw1-shard-0&authSource=admin&retryWrites=true&w=majority");
	static MongoClient mongoClient = new MongoClient(uri);
	static MongoDatabase RompePalabras = mongoClient.getDatabase("RompePalabras");
    static MongoCollection<Document> collectionUsuarios = RompePalabras.getCollection("usuarios");
    static MongoCollection<Document> collectionGames = RompePalabras.getCollection("games");


	public static void main(String[] args) {
	}
	
	
	public static String setearGanador(int[] idPartida) {
		int idPart = idPartida[0];
		int ganador = idPartida[1];
		Bson filter = eq("game_id", idPart);
		Bson update = set("winner", ganador);
		collectionGames.findOneAndUpdate(filter, update);
        return "Ganador seteado";
		
	}
	
	public static String actualizarElo(int[] actualizarINT) {
		int id = actualizarINT[0];
		int x = actualizarINT[1];
		Bson filter = eq("id", id);
		Bson update = inc("elo", x);
		collectionUsuarios.findOneAndUpdate(filter, update);
	    return "usuario Actualizado";
	}
	
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
