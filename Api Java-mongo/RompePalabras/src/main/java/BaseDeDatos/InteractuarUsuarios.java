package BaseDeDatos;

import java.lang.System.Logger.Level;
import java.net.UnknownHostException;
import java.util.List;
import java.util.logging.Logger;

import javax.lang.model.element.UnknownDirectiveException;

import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.Mongo;
import com.mongodb.MongoClient;


public class InteractuarUsuarios {
	
	MongoClient client = new MongoClient("localhost", 27017); 
    Datastore datastore = new Morphia().createDatastore(client, "RompePalabras");
    
	/*
	DB db;
	DBCollection tablaUsuarios;
	try {
		Mongo mongo = new Mongo("LocalHost",27017);
		db=mongo.getDB("RompePalabras");
		tablaUsuarios=db.getCollection("usuarios");
	}
		catch(UnknownHostException ex) {
			Logger.getLogger(conexionMongo.class.getName()).log(Level.SEVERE, null, ex);
		}
	*/
	
	
 
	public String addUsuario(Usuarios usuario){
		datastore.save(usuario);
		return "usuario agregado";
	}
	
	public List<Usuarios> getAllUsuarios(){
		List<Usuarios> list = datastore.find(Usuarios.class).asList();
		if(list != null){
			return list;
		}
		return null;
	}
}