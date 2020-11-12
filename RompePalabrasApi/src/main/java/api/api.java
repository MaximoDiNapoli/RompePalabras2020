package api;

import static spark.Spark.get;
import static spark.Spark.post;

import com.google.gson.Gson;



public class api {
	
	public static conexionMongoAtlas conexionMongoAtlas = new conexionMongoAtlas();
	
	public static void main(String[] args){
		
		Gson gson = new Gson();
		
		post("/agregarAmigo", (req, res) -> {
			res.type("application/json");
			String[] usuarios = gson.fromJson(req.body(), String[].class);
			int b = Integer.parseInt(usuarios[0]);
			int c = Integer.parseInt(usuarios[1]);
			return api.conexionMongoAtlas.agregarFriend(b, c);
		}, gson ::toJson);
		
		
		post("/obtenerIdsUsuariosGame", (req, res) -> {
			res.type("application/json");
			String partidaID = gson.fromJson(req.body(), String.class);
			int b = Integer.parseInt(partidaID);
			return api.conexionMongoAtlas.obtenerIdsUsuariosGame(b);
		}, gson ::toJson);
		
		get("/", (req, res) -> {
			res.type("application/json");
			return "Bienvenido ";
		}, gson ::toJson);

		post("/partidasDeUnUsuarioSinTerminar", (req, res) -> {
			res.type("application/json");
			String usuarioId = gson.fromJson(req.body(), String.class);
			int b = Integer.parseInt(usuarioId);
			return api.conexionMongoAtlas.partidasDeUnUsuarioSinTerminar(b);
	}, gson ::toJson);
		
		post("/buscarNombrePorId", (req, res) -> {
			res.type("application/json");
			String usuarioId = gson.fromJson(req.body(), String.class);
			int b = Integer.parseInt(usuarioId);
			return api.conexionMongoAtlas.buscarNombrePorId(b);
	}, gson ::toJson);
		
		post("/buscarIdPorDocument", (req, res) -> {
			res.type("application/json");
			String usuario = gson.fromJson(req.body(), String.class);
			return api.conexionMongoAtlas.buscarAmigosPorNombre(usuario);
	}, gson ::toJson);
		
		
		post("/buscarIdPorNombre", (req, res) -> {
			res.type("application/json");
			String usuario = gson.fromJson(req.body(), String.class);
			return api.conexionMongoAtlas.buscarIdPorNombre(usuario);
	}, gson ::toJson);
		
		post("/comprobarExistenciaDeUnUsuario", (req, res) -> {
			res.type("application/json");
			Usuario usuario = gson.fromJson(req.body(), Usuario.class);
			return api.conexionMongoAtlas.comprobarExistenciaDeUnUsuario(usuario.getUsername(), usuario.getEmail());
	}, gson ::toJson);
		
		post("/verPuntosDeUnUsuario", (req, res) -> {
			res.type("application/json");
			String[] a = gson.fromJson(req.body(), String[].class);
			int[] b = {Integer.parseInt(a[0]), Integer.parseInt(a[1])};
			return api.conexionMongoAtlas.verPuntosDeUnUsuario(b);
	}, gson ::toJson);
		
		get("/MejorUsuario", (req, res) -> {
			res.type("application/json");
			return api.conexionMongoAtlas.verUsuarioMasGrande();
	}, gson ::toJson);
		
		//suma puntos a un jugador en una partida
		post("/SumarPuntos", (req, res) -> {
			res.type("application/json");
			String[] a = gson.fromJson(req.body(), String[].class);
			int[] b = {Integer.parseInt(a[0]), Integer.parseInt(a[1])};
			return api.conexionMongoAtlas.agregarPuntosEnPartida(b);
	}, gson ::toJson);

			//quita puntos a un jugador en una partida
		post("/SumarPuntos", (req, res) -> {
			res.type("application/json");
			String[] a = gson.fromJson(req.body(), String[].class);
			int[] b = {Integer.parseInt(a[0]), Integer.parseInt(a[1])};
			return api.conexionMongoAtlas.quitarPuntosEnPartida(b);
	}, gson ::toJson);
		
		//Agregar usuario(recibe un json de un usuario y lo inserta)
		post("/AgregarUsuario", (req, res) -> {
				res.type("application/json");
				Usuario usuario = gson.fromJson(req.body(), Usuario.class);
				return api.conexionMongoAtlas.insertarUsuario(usuario);
		}, gson ::toJson);
		
		//agregar game(recibe un json de un game y lo inserta)
		post("/agregarGame", (req, res) -> {
			res.type("application/json");
			Game game = gson.fromJson(req.body(), Game.class);
			return api.conexionMongoAtlas.insertarGame(game);
		}, gson ::toJson);
		
		
		//cierra la partida(solo funciona si uno de los 2 usuarios tiene 100 pt)
		post("/cerrarPartida", (req, res) -> {
			res.type("application/json");
			String IdPartida = gson.fromJson(req.body(), String.class);
	        int IdPartidaI = Integer.parseInt(IdPartida);
			return api.conexionMongoAtlas.cerrarPartida(IdPartidaI);
		}, gson ::toJson);
		
		
		//actualizar Elo(basicamente recibe 1: El id del jugador y 2:La cantidad de elo a sumar(puede ser negativa))
		post("/actualizarElo", (req, res) -> {
			res.type("application/json");
			int[] pepe = gson.fromJson(req.body(), int[].class);
			return api.conexionMongoAtlas.actualizarElo(pepe);
		}, gson ::toJson);
		
		
		/*
		 * 
		//Usuario Especifico(recibe un id y te tira los datos del usuario)
		post("/UsuarioEspecifico", (req, res) -> {
			res.type("application/json");
			String username = gson.fromJson(req.body(), String.class);
	        return BaseDeDatos.conexionMongoAtlas.getUsuarioEspecifico(username);
		}, gson ::toJson);
		
		*/
		
		//Game Especifico (recibe un id y te tira los datos del game)
		post("/GameEspecifico", (req, res) -> {
			res.type("application/json");
			int idAABuscar = gson.fromJson(req.body(), int.class);
	        return api.conexionMongoAtlas.getGameEspecifico(idAABuscar);
		}, gson ::toJson);
		
		//el pepe (devuelve el pepe)
		get("/elpepe", (req, res) -> {
			res.type("application/json");
	        return "elpepe";
		}, gson ::toJson);
		
	}

}