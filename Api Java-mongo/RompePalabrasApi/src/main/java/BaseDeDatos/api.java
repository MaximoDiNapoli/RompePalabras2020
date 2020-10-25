package BaseDeDatos;

import static spark.Spark.get;
import static spark.Spark.post;
import com.google.gson.Gson;



public class api {
	
	public static conexionMongoAtlas conexionMongoAtlas = new conexionMongoAtlas();
	
	public static void main(String[] args){
		
		Gson gson = new Gson();
		
		//Agregar usuario
		post("/AU", (req, res) -> {
				res.type("application/json");
				Usuarios usuario = gson.fromJson(req.body(), Usuarios.class);
				return BaseDeDatos.conexionMongoAtlas.insertarUsuario(usuario);
		}, gson ::toJson);
		
		//agregar game
		post("/AG", (req, res) -> {
			res.type("application/json");
			games game = gson.fromJson(req.body(), games.class);
			return BaseDeDatos.conexionMongoAtlas.insertarGame(game);
	}, gson ::toJson);
		
		
		/*
		//Obtener todos los usuarios
		get("/getU", (req, res) -> {
			res.type("application/json");
	        return BaseDeDatos.conexionMongoAtlas.getAllUsuarios();
		}, gson ::toJson);
		
		/*
		//obtener todos los games
		get("/getG", (req, res) -> {
			res.type("application/json");
			BaseDeDatos.conexionMongoAtlas.getAllGames();
			return "dea games";
		}, gson ::toJson);

		*/
		//Usuario Especifico
		post("/getUE", (req, res) -> {
			res.type("application/json");
			int idABuscar = gson.fromJson(req.body(), int.class);
	        return BaseDeDatos.conexionMongoAtlas.getUsuarioEspecifico(idABuscar);
		}, gson ::toJson);
		
		
		//Game Especifico
		post("/getGE", (req, res) -> {
			res.type("application/json");
			int idAABuscar = gson.fromJson(req.body(), int.class);
	        return BaseDeDatos.conexionMongoAtlas.getGameEspecifico(idAABuscar);
		}, gson ::toJson);
		
		//elpepe
		get("/elpepe", (req, res) -> {
			res.type("application/json");
	        return "elpepe";
		}, gson ::toJson);
		
	}
}