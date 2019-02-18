package br.com.mongodb.dao;

public class Connection {

	private static MongoClient mongoClient = null;

	public static MongoDatabase getConnection(String dataBase) {

		MongoDatabase mongoDatabase = null;

		try {
			mongoClient = new MongoClient("localhost", 27017);
			mongoDatabase = mongoClient.getDatabase(dataBase);

		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
		}
		return mongoDatabase;
	}

	public static void closeDB() {

		mongoClient.close();

	}

}
