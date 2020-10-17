package BaseDeDatos;


import com.mongodb.DB;
import com.mongodb.MongoClient;

public class conexionMongo {
	
	public static void main(String[] args)throws Exception{
		try {
			MongoClient mongoClient = new MongoClient("localhost",27017);
			DB db = mongoClient.getDB("RompePalabras");
			System.out.println("Connected to database");
		}catch(Exception e){
			System.out.println(e);
		}
		
		System.out.println("Server is ready");
		
	}
}
