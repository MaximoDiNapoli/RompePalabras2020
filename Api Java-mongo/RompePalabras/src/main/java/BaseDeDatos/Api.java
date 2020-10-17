package BaseDeDatos;

import static spark.Spark.get;
import static spark.Spark.post;

import com.google.gson.Gson;

public class Api {

	public static InteractuarUsuarios interactuarUsuarios = new InteractuarUsuarios();

	public static void main(String[] args){
		
		Gson gson = new Gson();
		post("/add", (req, res) -> {
				res.type("application/json");
				Usuarios usuario = gson.fromJson(req.body(), Usuarios.class);
				return interactuarUsuarios.addUsuario(usuario);
		}, gson ::toJson);

		get("/", (req, res) -> {
			res.type("application/json");
			return interactuarUsuarios.getAllUsuarios();
		}, gson ::toJson);
		get("/elpepe", (req, res) -> {
			res.type("application/json");
			return "el pepe";
		}, gson ::toJson);
	}
}