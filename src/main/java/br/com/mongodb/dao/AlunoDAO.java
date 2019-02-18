package br.com.mongodb.dao;

import java.util.Iterator;

import com.google.gson.Gson;
import br.com.mongodb.model.Aluno;

public class AlunoDAO {

	private static MongoCollection<Document> collection;

	static {
		new Connection();
		collection = Connection.getConnection("test").getCollection("alunos");
	}

	public void add(Aluno aluno) {

		Gson gson = new Gson();
		String json = gson.toJson(aluno);

		Document document = new Document().parse(json);
		collection.insertOne(document);
		Connection.closeDB();
	}

	public void listar() {

		FindIterable<Document> cursor = collection.find();
		// Getting the iterator
		Iterator iterator = cursor.iterator();

		while (iterator.hasNext()) {
			Document document = (org.bson.Document) iterator.next();
			Gson gson = new Gson();
			Aluno fromJson = gson.fromJson(document.toJson(), Aluno.class);
			System.out.println(fromJson);
		}
		Connection.closeDB();

	}
	
	public void buscaId(String id) {
		BasicDBObject query = new BasicDBObject("id", id);
		
		FindIterable<Document> iterDoc = collection.find(query); 
		// Getting the iterator
		Iterator iterator = iterDoc.iterator();
				
				while (iterator.hasNext()) {
					//Document document = (org.bson.Document) iterator.next();				
					//System.out.println(document);
					System.out.println(iterator.next()); 
				}		
		
		
	}

	
	public void delete(String id) {
		
		collection.deleteOne(Filters.eq("id", id));       
		System.out.println("Document deleted successfully...");
		
	}
}
