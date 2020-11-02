package BaseDeDatos;

import static spark.Spark.get;
import static spark.Spark.post;
import com.google.gson.Gson;



public class api {
	
	public static conexionMongoAtlas conexionMongoAtlas = new conexionMongoAtlas();
	
	public static void main(String[] args){
		
		Gson gson = new Gson();
		
		get("/", (req, res) -> {
			res.type("application/json");
			return "Bienvenido ";
		}, gson ::toJson);
		
		post("/verPuntosDeUnUsuario", (req, res) -> {
			res.type("application/json");
			int[] a = gson.fromJson(req.body(), int[].class);
			return BaseDeDatos.conexionMongoAtlas.verPuntosDeUnUsuario(a);
	}, gson ::toJson);
		
		get("/MejorUsuario", (req, res) -> {
			res.type("application/json");
			return BaseDeDatos.conexionMongoAtlas.verUsuarioMasGrande();
	}, gson ::toJson);
		
		//suma puntos a un jugador en una partida
		post("/SumarPuntos", (req, res) -> {
			res.type("application/json");
			int[] a = gson.fromJson(req.body(), int[].class);
			return BaseDeDatos.conexionMongoAtlas.agregarPuntosEnPartida(a);
	}, gson ::toJson);

			//quita puntos a un jugador en una partida
		post("/SumarPuntos", (req, res) -> {
			res.type("application/json");
			int[] a = gson.fromJson(req.body(), int[].class);
			return BaseDeDatos.conexionMongoAtlas.quitarPuntosEnPartida(a);
	}, gson ::toJson);
		
		//Agregar usuario(recibe un json de un usuario y lo inserta)
		post("/AgregarUsuario", (req, res) -> {
				res.type("application/json");
				Usuarios usuario = gson.fromJson(req.body(), Usuarios.class);
				return BaseDeDatos.conexionMongoAtlas.insertarUsuario(usuario);
		}, gson ::toJson);
		
		//agregar game(recibe un json de un game y lo inserta)
		post("/agregarGame", (req, res) -> {
			res.type("application/json");
			games game = gson.fromJson(req.body(), games.class);
			return BaseDeDatos.conexionMongoAtlas.insertarGame(game);
		}, gson ::toJson);
		
		
		//cierra la partida(solo funciona si uno de los 2 usuarios tiene 100 pt)
		post("/cerrarPartida", (req, res) -> {
			res.type("application/json");
			int IdPartida = gson.fromJson(req.body(), int.class);
			return BaseDeDatos.conexionMongoAtlas.cerrarPartida(IdPartida);
		}, gson ::toJson);
		
		
		//actualizar Elo(basicamente recibe 1: El id del jugador y 2:La cantidad de elo a sumar(puede ser negativa))
		post("/actualizarElo", (req, res) -> {
			res.type("application/json");
			int[] pepe = gson.fromJson(req.body(), int[].class);
			return BaseDeDatos.conexionMongoAtlas.actualizarElo(pepe);
		}, gson ::toJson);
		
		
		//Usuario Especifico(recibe un id y te tira los datos del usuario)
		post("/UsuarioEspecifico", (req, res) -> {
			res.type("application/json");
			int idABuscar = gson.fromJson(req.body(), int.class);
	        return BaseDeDatos.conexionMongoAtlas.getUsuarioEspecifico(idABuscar);
		}, gson ::toJson);
		
		
		//Game Especifico (recibe un id y te tira los datos del game)
		post("/GameEspecifico", (req, res) -> {
			res.type("application/json");
			int idAABuscar = gson.fromJson(req.body(), int.class);
	        return BaseDeDatos.conexionMongoAtlas.getGameEspecifico(idAABuscar);
		}, gson ::toJson);
		
		//el pepe (devuelve el pepe)
		get("/elpepe", (req, res) -> {
			res.type("application/json");
	        return "elpepe";
		}, gson ::toJson);
		
	}

}