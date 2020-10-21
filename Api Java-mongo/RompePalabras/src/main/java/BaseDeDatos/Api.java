package BaseDeDatos;

public class api {
	
	public static conexionMongoAtlas productService = new conexionMongoAtlas();
	
	public static void main(String[] args){
		/*
		Gson gson = new Gson();
		post("/add", (req, res) -> {
				res.type("application/json");
				Usuarios usuario1 = gson.fromJson(req.body(), Usuarios.class);
				return productService.addUsuario(usuario1);
		}, gson ::toJson);

		get("/", (req, res) -> {
			res.type("application/json");
			return productService.getAllUsuarios();
		}, gson ::toJson);
		*/
		
	}
}