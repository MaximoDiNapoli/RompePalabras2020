package BaseDeDatos;

import static spark.Spark.get;
import static spark.Spark.post;

import javax.swing.text.Document;

import com.google.gson.Gson;

public class Api2 {

	public static ConexionMongoAtlas2 conexionMongoAtlas = new ConexionMongoAtlas2();

	public static void main(String[] args) {

		Gson gson = new Gson();

		post("/agregarAmigo", (req, res) -> {
			res.type("application/json");
			String[] usuarios = gson.fromJson(req.body(), String[].class);
			int b = Integer.parseInt(usuarios[0]);
			int c = Integer.parseInt(usuarios[1]);
			return BaseDeDatos.ConexionMongoAtlas2.agregarFriend(b, c);
		}, gson::toJson);

		post("/obtenerIdsUsuariosGame", (req, res) -> {
			res.type("application/json");
			String partidaID = gson.fromJson(req.body(), String.class);
			int b = Integer.parseInt(partidaID);
			return BaseDeDatos.ConexionMongoAtlas2.obtenerIdsUsuariosGame(b);
		}, gson::toJson);
		
		post("/verGanador", (req, res) -> {
			res.type("application/json");
			String partidaID = gson.fromJson(req.body(), String.class);
			int b = Integer.parseInt(partidaID);
			return BaseDeDatos.ConexionMongoAtlas2.verGanador(b);
		}, gson::toJson);

		get("/", (req, res) -> {
			res.type("application/json");
			return "Bienvenido ";
		}, gson::toJson);

		post("/partidasDeUnUsuarioSinTerminar", (req, res) -> {
			res.type("application/json");
			String usuarioId = gson.fromJson(req.body(), String.class);
			int b = Integer.parseInt(usuarioId);
			return BaseDeDatos.ConexionMongoAtlas2.partidasDeUnUsuarioSinTerminar(b);
		}, gson::toJson);

		post("/buscarNombrePorId", (req, res) -> {
			res.type("application/json");
			String usuarioId = gson.fromJson(req.body(), String.class);
			int b = Integer.parseInt(usuarioId);
			return BaseDeDatos.ConexionMongoAtlas2.buscarNombrePorId(b);
		}, gson::toJson);

		post("/buscarIdPorDocument", (req, res) -> {
			res.type("application/json");
			String usuario = gson.fromJson(req.body(), String.class);
			return BaseDeDatos.ConexionMongoAtlas2.buscarAmigosPorNombre(usuario);
		}, gson::toJson);

		post("/buscarIdPorNombre", (req, res) -> {
			res.type("application/json");
			String usuario = gson.fromJson(req.body(), String.class);
			return BaseDeDatos.ConexionMongoAtlas2.buscarIdPorNombre(usuario);
		}, gson::toJson);

		post("/comprobarExistenciaDeUnUsuario", (req, res) -> {
			res.type("application/json");
			Usuarios usuario = gson.fromJson(req.body(), Usuarios.class);
			return BaseDeDatos.ConexionMongoAtlas2.comprobarExistenciaDeUnUsuario(usuario.getUsername(),
					usuario.getEmail());
		}, gson::toJson);

		post("/verPuntosDeUnUsuario", (req, res) -> {
			res.type("application/json");
			String[] a = gson.fromJson(req.body(), String[].class);
			int[] b = { Integer.parseInt(a[0]), Integer.parseInt(a[1]) };
			return BaseDeDatos.ConexionMongoAtlas2.verPuntosDeUnUsuario(b);
		}, gson::toJson);

		get("/MejorUsuario", (req, res) -> {
			res.type("application/json");
			return BaseDeDatos.ConexionMongoAtlas2.verUsuarioMasGrande();
		}, gson::toJson);

		// suma puntos a un jugador en una partida
		post("/SumarPuntos", (req, res) -> {
			res.type("application/json");
			String[] a = gson.fromJson(req.body(), String[].class);
			int[] b = { Integer.parseInt(a[0]), Integer.parseInt(a[1]) };
			return BaseDeDatos.ConexionMongoAtlas2.agregarPuntosEnPartida(b);
		}, gson::toJson);

		// quita puntos a un jugador en una partida
		post("/quitarPuntos", (req, res) -> {
			res.type("application/json");
			String[] a = gson.fromJson(req.body(), String[].class);
			int[] b = { Integer.parseInt(a[0]), Integer.parseInt(a[1]) };
			return BaseDeDatos.ConexionMongoAtlas2.quitarPuntosEnPartida(b);
		}, gson::toJson);

		// Agregar usuario(recibe un json de un usuario y lo inserta)
		post("/AgregarUsuario", (req, res) -> {
			res.type("application/json");
			Usuarios usuario = gson.fromJson(req.body(), Usuarios.class);
			return BaseDeDatos.ConexionMongoAtlas2.insertarUsuario(usuario);
		}, gson::toJson);

		// agregar game(recibe un json de un game y lo inserta)
		post("/agregarGame", (req, res) -> {
			res.type("application/json");
			Games2 game = gson.fromJson(req.body(), Games2.class);
			return BaseDeDatos.ConexionMongoAtlas2.insertarGame(game);
		}, gson::toJson);

		// cierra la partida(solo funciona si uno de los 2 usuarios tiene 100 pt)
		post("/cerrarPartida", (req, res) -> {
			res.type("application/json");
			String IdPartida = gson.fromJson(req.body(), String.class);
			int IdPartidaI = Integer.parseInt(IdPartida);
			return BaseDeDatos.ConexionMongoAtlas2.cerrarPartida(IdPartidaI);
		}, gson::toJson);

		// actualizar Elo(basicamente recibe 1: El id del jugador y 2:La cantidad de elo
		// a sumar(puede ser negativa))
		post("/actualizarElo", (req, res) -> {
			res.type("application/json");
			int[] pepe = gson.fromJson(req.body(), int[].class);
			return BaseDeDatos.ConexionMongoAtlas2.actualizarElo(pepe);
		}, gson::toJson);

		/*
		 * 
		 * //Usuario Especifico(recibe un id y te tira los datos del usuario)
		 * post("/UsuarioEspecifico", (req, res) -> { res.type("application/json");
		 * String username = gson.fromJson(req.body(), String.class); return
		 * BaseDeDatos.conexionMongoAtlas.getUsuarioEspecifico(username); }, gson
		 * ::toJson);
		 * 
		 */

		// Game Especifico (recibe un id y te tira los datos del game)
		post("/GameEspecifico", (req, res) -> {
			res.type("application/json");
			int idAABuscar = gson.fromJson(req.body(), int.class);
			return BaseDeDatos.ConexionMongoAtlas2.getGameEspecifico(idAABuscar);
		}, gson::toJson);

		// el pepe (devuelve el pepe)
		get("/elpepe", (req, res) -> {
			res.type("application/json");
			return "elpepe";
		}, gson::toJson);

	}

}