package BaseDeDatos;

import java.util.ArrayList;
import java.util.Vector;

import javax.xml.crypto.Data;

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
import com.mongodb.client.model.Updates;
import com.mongodb.client.result.UpdateResult;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.bson.json.JsonWriterSettings;

import static com.mongodb.client.model.Filters.and;
import static com.mongodb.client.model.Filters.lt;
import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.Updates.*;



public class conexionMongoAtlas {
	static Gson gson = new Gson();
	static MongoClientURI uri = new MongoClientURI("mongodb://MaximoDiNapoli:pelele123@cluster0-shard-00-00.9gizt.gcp.mongodb.net:27017,cluster0-shard-00-01.9gizt.gcp.mongodb.net:27017,cluster0-shard-00-02.9gizt.gcp.mongodb.net:27017/RompePalabras?ssl=true&replicaSet=atlas-117qw1-shard-0&authSource=admin&retryWrites=true&w=majority");
	static MongoClient mongoClient = new MongoClient(uri);
	static MongoDatabase RompePalabras = mongoClient.getDatabase("RompePalabras");
    static MongoCollection<Document> collectionUsuarios = RompePalabras.getCollection("usuarios");
    static MongoCollection<Document> collectionGames = RompePalabras.getCollection("games");

    
    public static void main(String[] args){
    	verUsuarioMasGrande();
    }
    
    
    public static boolean comprobarExistenciaDeUnUsuario(String nombre, String email) {
    	Bson filter = eq("username", nombre);
    	Bson filter2 = eq("email", email);
    	boolean a;
    	if(collectionUsuarios.find(Filters.and(filter, filter2)).first() != null){
    		a = true;
    	}
    	else {
    		a = false;
    	}
		return a;
    }
    
    public static String verUsuarioMasGrande() {
    	int EloMasGrande = 0;
    	for(int i = 0;i < collectionUsuarios.count(); i++){
    		Bson filter = eq("id", i);
        	if(collectionUsuarios.find(filter).first() != null) {
        		System.out.println("dea1");
        		Document usuario = collectionUsuarios.find(filter).first();
        		String usuarioString = usuario.toJson();
        		System.out.println(usuarioString);
                int a = usuarioString.lastIndexOf("elo") + 7;
                String eloString = "";
                for(int j = a;j < 200;j++){
        	        	if(usuarioString.charAt(j) != ' ') {
        	        		eloString = eloString + usuarioString.charAt(j);
        	        	}
        	        	else {
        	        		System.out.println(eloString);
        		        	j = 300;
        	        	}
                }
                int PuntajeUsuario1 = Integer.parseInt(eloString);
                if(PuntajeUsuario1 > EloMasGrande) {
                	EloMasGrande = PuntajeUsuario1;
                }
        		System.out.println(PuntajeUsuario1);
        	}
    		System.out.println(EloMasGrande);
    	}
		Bson filter2 = eq("elo", EloMasGrande);
		Document Mejorusuario = collectionUsuarios.find(filter2).first();
		String MejorusuarioString = Mejorusuario.toJson();
        int a = MejorusuarioString.lastIndexOf("username") + 12;
        String MejorusuarioNombre = "";
        for(int j = a+1;j < 200;j++){
	        	if(MejorusuarioString.charAt(j) != '"') {
	        		MejorusuarioNombre = MejorusuarioNombre + MejorusuarioString.charAt(j);
	        	}
	        	else {
	        		System.out.println(MejorusuarioNombre);
		        	j = 300;
	        	}
        }
		System.out.println(MejorusuarioNombre);
		String resultado  = ("el mejor usuario es: " + MejorusuarioNombre  + " con la increible cantidad de " + EloMasGrande + " de elo!");
    	return resultado;
    }
        	
    public static int verPuntosDeUnUsuario(int[] Arrr) {
    	int idgame = Arrr[0];
    	int idUsuario = Arrr[1];
    	Bson filterG = eq("game_id", idgame);
    	Bson filter1 = eq("player1_id", idUsuario);
    	Bson filter2 = eq("player2_id", idUsuario);
    	if(collectionGames.find(Filters.and(filterG, filter1)).first() != null) {
    		System.out.println("dea1");
    		Document Game = collectionGames.find(Filters.and(filterG, filter1)).first();
    		String GameString = Game.toJson();
            int a = GameString.lastIndexOf("puntajePlayer1") + 18;
            String ganadorString = "";
            for(int i = a;i < 200;i++){
    	        	if(GameString.charAt(i) != ',') {
    	        		ganadorString = ganadorString + GameString.charAt(i);
    	        	}
    	        	else {
    	        		System.out.println(ganadorString);
    		        	i = 300;
    	        	}
            }
            int PuntajeUsuario1 = Integer.parseInt(ganadorString);
    		System.out.println(PuntajeUsuario1);
        	return PuntajeUsuario1;
    	}
    	
    	if(collectionGames.find(Filters.and(filterG, filter2)).first() != null) {
    		Document Game = collectionGames.find(Filters.and(filterG, filter2)).first();
    		String GameString = Game.toJson();
            int a = GameString.lastIndexOf("puntajePlayer2") + 18;
            String ganadorString = "";
            for(int i = a;i < 200;i++){
    	        	if(GameString.charAt(i) != ' ') {
    	        		ganadorString = ganadorString + GameString.charAt(i);
    	        	}
    	        	else {
    	        		System.out.println(ganadorString);
    		        	i = 300;
    	        	}
            }
            int PuntajeUsuario2 = Integer.parseInt(ganadorString);
    		System.out.println(PuntajeUsuario2);
        	return PuntajeUsuario2;
    	}
    	
    	return 0;
    }
    
    public static String agregarPuntosEnPartida(int[] idUsuarioIdgame) {
    	int idgame = idUsuarioIdgame[0];
    	int idUsuario = idUsuarioIdgame[1];
    	Bson filterG = eq("game_id", idgame);
    	Bson filter1 = eq("player1_id", idUsuario);
    	Bson filter2 = eq("player2_id", idUsuario);
    	Bson update1 = inc("puntajePlayer1", 10);
    	Bson update2 = inc("puntajePlayer2", 10);
    	collectionGames.findOneAndUpdate(Filters.and(filterG, filter1), update1);
    	collectionGames.findOneAndUpdate(Filters.and(filterG, filter2), update2);
    	return "puntos agregados";
    }
    
    public static String quitarPuntosEnPartida(int[] idUsuarioIdgame) {
    	int idgame = idUsuarioIdgame[0];
    	int idUsuario = idUsuarioIdgame[1];
    	Bson filterG = eq("game_id", idgame);
    	Bson filter1 = eq("player1_id", idUsuario);
    	Bson filter2 = eq("player2_id", idUsuario);
    	Bson update1 = inc("puntajePlayer1", -10);
    	Bson update2 = inc("puntajePlayer2", -10);
    	collectionGames.findOneAndUpdate(Filters.and(filterG, filter1), update1);
    	collectionGames.findOneAndUpdate(Filters.and(filterG, filter2), update2);
    	return "puntos quitados";
    }
    
    public static int verGanador(int idPartida) {
    	
    	Bson filter = eq("game_id", idPartida);
		Document gameBuscado = collectionGames.find(filter).first();
        System.out.println("Usuario: " + gameBuscado.toJson());
        String sCadena = gameBuscado.toJson();
        System.out.println(sCadena);
        int a = sCadena.lastIndexOf("winner") + 10;
        String ganadorString = "";
        for(int i = a;i < 200;i++){
	        	if(sCadena.charAt(i) != ',') {
	        		ganadorString = ganadorString + sCadena.charAt(i);
	        	}
	        	else {
	        		System.out.println(ganadorString);
		        	i = 300;
	        	}
        }
        int winner = Integer.parseInt(ganadorString);
		System.out.println(winner);
    	return winner;
    	
    }
    
    public static String agregarFriend(int idUsuario1, int idUsuario2) {
    	Bson filter1 = eq("id", idUsuario1);
    	Bson filter2 = eq("id", idUsuario2);
    	collectionUsuarios.findOneAndUpdate(filter1, Updates.push("friends", idUsuario2));
    	collectionUsuarios.findOneAndUpdate(filter2, Updates.push("friends", idUsuario1));
    	return "Nuevos amigos!";
    }
 
	public static int ultimoIDUsuario(){
		int maxId = 1;
        for(int i = 1;i < collectionUsuarios.count();i++){
    		Bson filter = eq("id", i);
    		if(collectionUsuarios.find(filter) != null) {
    			maxId = maxId + 1;
    		}
        }
        System.out.println(maxId);
        return maxId;
	}
	
	public static int ultimoIDGames(){
		int maxId = 2;
        for(int i = 1;i < collectionGames.count();i++){
    		Bson filter = eq("game_id", i);
    		if(collectionGames.find(filter) != null) {
    			maxId = maxId + 1;
    		}
        }
        System.out.println(maxId);
        return maxId;
	}
	
	public static int[] obtenerIdsUsuariosGame(int partidaID) {
		Bson filterIdPartida = eq("game_id", partidaID);
		Document gameBuscado = collectionGames.find(filterIdPartida).first();
        System.out.println("Usuario: " + gameBuscado.toJson());
        String sCadena = gameBuscado.toJson();
        int a = sCadena.lastIndexOf("player1_id") + 14;
        int a2 = sCadena.lastIndexOf("player2_id") + 14;
        String idUsuario1 = "";
        String idUsuario2 = "";
        for(int i = a;i < 200;i++){
	        	if(sCadena.charAt(i) != ',') {
	        		idUsuario1 = idUsuario1 + sCadena.charAt(i);
	        	}
	        	else {
		        	i = 300;
	        	}
        }
        for(int i = a2;i < 200;i++){
        	if(sCadena.charAt(i) != ',') {
        		idUsuario2 = idUsuario2 + sCadena.charAt(i);
        	}
        	else {
	        	i = 300;
        	}
        }
        int idUsuario1INT = Integer.parseInt(idUsuario1);
        int idUsuario2INT = Integer.parseInt(idUsuario2);
        System.out.println("a :  " + idUsuario1INT + "   b  :   " + idUsuario2INT);
        int [] idsUsuarios = new int[] {idUsuario1INT,idUsuario2INT};
        return idsUsuarios;
        //No puedo creer que esta pirateria funcione
	}

	public static String cerrarPartida(int partidaID){
		Bson filterIdPartida = eq("game_id", partidaID);
		int [] idsUsuarios = obtenerIdsUsuariosGame(partidaID);
		Bson filterPuntajePlayer1 = eq("puntajePlayer1", 100);
		Bson filterPuntajePlayer2 = eq("puntajePlayer2", 100);
		if(collectionGames.find(Filters.and(filterPuntajePlayer1, filterIdPartida)) != null) {
			int [] actualizarINT = new int[] {partidaID, idsUsuarios[0]};
			setearGanador(actualizarINT);	//le pasa el id del ganador a setearGanador
		}else if(collectionGames.find(Filters.and(filterPuntajePlayer2, filterIdPartida)) != null) {
			int [] actualizarINT = new int[] {partidaID, idsUsuarios[1]}; //basicamente es el id de la partida y el usuario que gano
			setearGanador(actualizarINT);	//le pasa el id del ganador a setearGanador
		}
		return "Done";
	}
	
	public static String setearGanador(int[] idPartida) {
		int idPart = idPartida[0];	//id de la partida
		int ganador = idPartida[1];		//id del ganador
		int[] usuarioGanadorConElo = new int[] {idPartida[1],100};
		actualizarElo(usuarioGanadorConElo);
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
