package BaseDeDatos;

import static spark.Spark.get;
import static spark.Spark.post;
import com.google.gson.Gson;



public class api {
	
	public static conexionMongoAtlas conexionMongoAtlas = new conexionMongoAtlas();
	
	public static void main(String[] args){
		
		Gson gson = new Gson();
		
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
		
		
		//setear Ganador(recibe 1: id del game 2: el ganador)
		post("/setearGanador", (req, res) -> {
			res.type("application/json");
			int[] setearGanador = gson.fromJson(req.body(), int[].class);
			return BaseDeDatos.conexionMongoAtlas.setearGanador(setearGanador);
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