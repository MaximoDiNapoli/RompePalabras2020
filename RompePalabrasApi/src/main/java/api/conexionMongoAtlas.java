package api;

import java.util.ArrayList;
import java.util.Vector;


import org.bson.Document;
import org.bson.conversions.Bson;
import com.google.gson.Gson;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import static com.mongodb.client.model.Filters.eq;


import static com.mongodb.client.model.Filters.and;
import static com.mongodb.client.model.Filters.lt;
import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.Updates.*;



public class ConexionMongoAtlas {
	
	//Basicamente en esta parte conecto la base de datos con la api 
	//guardo la base de datos como RompePalabras
	//la coleccion usuarios como collectionUsuarios
	//la coleccion Games como collectionGames
	
	static Gson gson = new Gson();
	static MongoClientURI uri = new MongoClientURI("mongodb://MaximoDiNapoli:pelele123@cluster0-shard-00-00.9gizt.gcp.mongodb.net:27017,cluster0-shard-00-01.9gizt.gcp.mongodb.net:27017,cluster0-shard-00-02.9gizt.gcp.mongodb.net:27017/RompePalabras?ssl=true&replicaSet=atlas-117qw1-shard-0&authSource=admin&retryWrites=true&w=majority");
	static MongoClient mongoClient = new MongoClient(uri);
	static MongoDatabase RompePalabras = mongoClient.getDatabase("RompePalabras");
    static MongoCollection<Document> collectionUsuarios = RompePalabras.getCollection("usuarios");
    static MongoCollection<Document> collectionGames = RompePalabras.getCollection("games");

    public static void main(String[] args) {
        //no le presten mucha atencion al main es solo para hacer pruebas despues nunca se lo llama realmente en api.java
    	ArrayList<Integer> intIDPartidasIncluidos = new ArrayList<Integer>();
 		Bson filter = eq("player1_id", 1);        		
 		Bson filter2 = eq("player2_id", 1);
     	for(int i = 1;i <= collectionGames.count()+1; i++){
     		Bson filterGame = eq("game_id", i);
     		Bson filterQueNoEsteTerminada = eq("winner", 0);
         	if(collectionGames.find(Filters.and(filter,filterGame,filterQueNoEsteTerminada)).first() != null || collectionGames.find(Filters.and(filter2,filterGame,filterQueNoEsteTerminada)).first() != null) {
         		intIDPartidasIncluidos.add(i);
         	}
     	}
     	System.out.println("Arraylist contains: " + intIDPartidasIncluidos.toString());
    } 
    
    public ArrayList<Integer> partidasDeUnUsuarioSinTerminar(int idUsuario) {
        //esta es simple pero a la vez compleja, lo que hace basicamente es establecer unos filtros(
        //filter: se asegura que player1_id sea igual al que recibio
        //filter2: se asegura que player2_id sea igual al que recibio
        //filterGame: se asegura que el game_id sea igual a i
        //filterQueNoEsteTerminada: basicamente ve si hay un ganador
        //Bueno con todos estos filtros hace 1 if que basicamente dice "si el ganador es 0, el id de la partida i y el player1_id es igual al que me pasaron agrega esa id al array" or lo mismo pero con player2_id
        ArrayList<Integer> intIDPartidasIncluidos = new ArrayList<Integer>();
		Bson filter = eq("player1_id", idUsuario);        		
		Bson filter2 = eq("player2_id", idUsuario);
    	for(int i = 1;i <= collectionGames.count()+1; i++){
    		Bson filterGame = eq("game_id", i);
    		Bson filterQueNoEsteTerminada = eq("winner", 0);
        	if(collectionGames.find(Filters.and(filter,filterGame,filterQueNoEsteTerminada)).first() != null || collectionGames.find(Filters.and(filter2,filterGame,filterQueNoEsteTerminada)).first() != null) {
        		intIDPartidasIncluidos.add(i);
        	}
    	}
    	System.out.println("Arraylist contains: " + intIDPartidasIncluidos.toString());
    	return intIDPartidasIncluidos;
    } 
    
    public boolean comprobarExistenciaDeUnUsuario(String nombre, String email) {
    	//filter: se fija que el nombre sea igual al que recibio
    	//filter: se fija que el email sea igual al que recibio
    	//el if comprueba si encuentra algo que cumpla los 2 filtros si no es null significa que ya hay uno con ese nombre y email
    	//(nota: pudimos haberlo hecho solo con el nombre y hubiera quedado mejor segun yo)
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
    
    public String verUsuarioMasGrande() {
    	//se la ve grande pero no es tan complicada basicamente crea una variable llamada EloMasGrande y la iguala a 0 luego recorre todos los usuarios y si 
    	//encuentra un usuario con mas elo que EloMasGrande lo setea como el elo mas grande, una vez que recorre todo los usuarios y tiene el elo mas grande busca el nombre
    	//del usuario con el elo mas grande quiza se pudo haber optimizado un poco pero me da miedo tocar algo fue bastante complicada hacerla xD
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
        	
    public int verPuntosDeUnUsuario(int[] Arrr) {
    	
    	//Basicamente te tira los puntos de un usuario dentro de una partida vos le tiras que usuario y que partida
    	//setea los filtros y despues ve si existe esa partida con ese usuario si existe hace un for para poder guardar el puntaje dentro de la variable PuntajeUsuarioN
    	//si tenes alguna duda con los fors criminales que yo entiendo que son feos preguntame
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
    
    public String agregarPuntosEnPartida(int[] idUsuarioIdgame) {	
    	//basicamente vos le decis que partida y que usuario, desp hace un findOneAndUpdate
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
    
    public String quitarPuntosEnPartida(int[] idUsuarioIdgame) {     
    	//Lo mismo que el anterior pero ahora resta creo que este no lo usamos tipo no te resta puntos equivocarte xD
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
    
    public int verGanador(int idPartida) {
    	
    	// le tiras que partida y te tira quien es el ganador si es 0 significa que nadie gano
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
    	return winner;
    	
    }
    
    public String agregarFriend(int idUsuario1, int idUsuario2) {
    	//le pasas 2 usuarios y los agrega de amigos (a la fuerza no puede rechazarte xD)
    	//pd que bueno que existe Updates.push sino iba a ser dificil
    	Bson filter1 = eq("id", idUsuario1);
    	Bson filter2 = eq("id", idUsuario2);
    	collectionUsuarios.findOneAndUpdate(filter1, Updates.push("friends", idUsuario2));
    	collectionUsuarios.findOneAndUpdate(filter2, Updates.push("friends", idUsuario1));
    	return "Nuevos amigos!";
    }
 
	public int ultimoIDUsuario(){
		//cuenta cuantos usuarios hay basicamente esto funciona gracias a que no hay ninguna manera de borrar usuarios
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
	
	public int ultimoIDGames(){
		//cuenta cuantos games hay basicamente esto funciona gracias a que no hay ninguna manera de borrar games
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
	
	public int[] obtenerIdsUsuariosGame(int partidaID) {
		//recibe un game y te tira los participantes es muy util 
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
        System.out.println("usuario1 :  " + idUsuario1INT + "   usuario2  :   " + idUsuario2INT);
        int [] idsUsuarios = new int[] {idUsuario1INT,idUsuario2INT};
        return idsUsuarios;
	}

	public int cerrarPartida(int partidaID){
		//basicamente mira si alguno de los 2 jugadores llego a 100 puntos y llama a setearGanador
		//tambien se fija que ids son tipo quien es el jugador 1 y quien el 2 para poder llamar a setear ganador
		Bson filterIdPartida = eq("game_id", partidaID);
		int [] idsUsuarios = obtenerIdsUsuariosGame(partidaID);
		Bson filterPuntajePlayer1 = eq("puntajePlayer1", 100);
		Bson filterPuntajePlayer2 = eq("puntajePlayer2", 100);
		if(collectionGames.find(Filters.and(filterPuntajePlayer1, filterIdPartida)).first() != null) {
			int [] actualizarINT = new int[] {partidaID, idsUsuarios[0]};
			setearGanador(actualizarINT);	//le pasa el id del ganador a setearGanador
			return 1;
		}else if(collectionGames.find(Filters.and(filterPuntajePlayer2, filterIdPartida)).first() != null) {
			int [] actualizarINT = new int[] {partidaID, idsUsuarios[1]}; //basicamente es el id de la partida y el usuario que gano
			setearGanador(actualizarINT);	//le pasa el id del ganador a setearGanador
			return 2;
		}
		return 0;
	}
	
	public String setearGanador(int[] idPartida) {
		//recibe un id de partida y de un jugador y lo setea como ganador
		//desp llama a actualizarElo para que le sume 100 de elo al que gano
		int idPart = idPartida[0];	//id de la partida
		int ganador = idPartida[1];		//id del ganador
		int[] usuarioGanadorConElo = new int[] {ganador,100};
		actualizarElo(usuarioGanadorConElo);
		Bson filter = eq("game_id", idPart);
		Bson update = set("winner", ganador);
		collectionGames.findOneAndUpdate(filter, update);
        return "Ganador seteado";
		
	}
	
	public String actualizarElo(int[] actualizarINT) {
		//le suma x cantiidad de elo a el id que recibio
		int id = actualizarINT[0];
		int x = actualizarINT[1];
		Bson filter = eq("id", id);
		Bson update = inc("elo", x);
		collectionUsuarios.findOneAndUpdate(filter, update);
	    return "usuario Actualizado";
	}
	
	public String insertarUsuario(Usuario usuario1) {
		//vos le mandas un usuario y despues creas un document y le metes adentro todo y despues mete ese document a la base de datos 
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
	
	public int insertarGame(Game game1) {
		//vos le mandas un game y despues creas un document y le metes adentro todo y despues mete ese document a la base de datos 
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
	    return ultimoIDGames();
	}
	
    public int buscarIdPorNombre(String nombreABuscar){
    	// vos le tiras el nombre y te tira el id
        Document usuarioBuscado = collectionUsuarios.find(new Document("username", nombreABuscar)).first();
        System.out.println("Usuario: " + usuarioBuscado.toJson());
        String sCadena = usuarioBuscado.toJson();
        int a = sCadena.lastIndexOf("id") + 6;
        String idUsuario = "";
        for(int i = a;i < 200;i++){
	        	if(sCadena.charAt(i) != ',') {
	        		idUsuario = idUsuario + sCadena.charAt(i);
	        	}
	        	else {
		        	i = 300;
	        	}
        }
        System.out.println(idUsuario );
        int idUsuarioINT = Integer.parseInt(idUsuario);
        System.out.println("a :  " + idUsuario );
        return idUsuarioINT;
    }
    
    public String buscarNombrePorId(int id){
    	//vos le tiras el id y te busca el nombre
        Document usuarioBuscado = collectionUsuarios.find(new Document("id", id)).first();
        System.out.println("Usuario: " + usuarioBuscado.toJson());
        String sCadena = usuarioBuscado.toJson();
        int a = sCadena.lastIndexOf("username") + 13;
        String userName = "";
        for(int i = a;i < 200;i++){
	        	if(sCadena.charAt(i) != '"') {
	        		userName = userName + sCadena.charAt(i);
	        	}
	        	else {
		        	i = 300;
	        	}
        }
        System.out.println(userName );
        System.out.println("a :  " + userName );
        return userName;
    }		

    public ArrayList<Integer> buscarAmigosPorNombre(String username){
    	//vos le tiras el nombre de un usuario y te busca los ids de sus amigos 
    	//la parte de amigos es algo asi como [1, 2, 3] todos los fors es para recorrer esa parte y guardar los numeros dentro de un arrayList 
    	//pd el codigo esta hecho para que funcione aunque tenga que leer un id de 199 digitos y podes tener hasta 300 amigos hasta que se rompa 
    	Document usuarioBuscado = collectionUsuarios.find(new Document("username", username)).first();
        System.out.println("Usuario: " + usuarioBuscado.toJson());
        String sCadena = usuarioBuscado.toJson();
        int a = sCadena.lastIndexOf("friend") + 12;
        int k = 0;
        String idAmigo = "";
        ArrayList<Integer> intAmigos = new ArrayList<Integer>();
        for(int j = a;j  < 300; j++) {
            idAmigo = "";
            a = a + k;
            boolean p = true;
            for(int i = a;i < 200 && p == true;i++){
    	        	if(sCadena.charAt(i) != ',') {
    	        		idAmigo = idAmigo + sCadena.charAt(i);
    	        	}
    	        	if(sCadena.charAt(i+1) == ']') {
    	        		p = false;
    	        		j = 301;
    	        	}
    	        	if(sCadena.charAt(i+1) == ' ') {
    	        		a++;
    	        		p = false;
    	        	}
            }
            a = a +1+ idAmigo.length();
        	int idAmigoINT = Integer.parseInt(idAmigo);
        	intAmigos.add(idAmigoINT);
        }
        	System.out.println("Arraylist contains: " + intAmigos.toString()); 
        	return intAmigos;
    }
    
	public Document getGameEspecifico(int idAABuscar){
		// creo que nunca la usamos pero basicamente le tiras un id y busca que game tiene ese id y te lo tira
        Document gameBuscado = collectionGames.find(new Document("game_id", idAABuscar)).first();
        System.out.println("Game: " + gameBuscado.toJson());
        return gameBuscado;
	}
}
