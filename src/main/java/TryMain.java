import br.com.mongodb.dao.AlunoDAO;
import br.com.mongodb.model.Aluno;

public class TryMain {

	public static void main(String[] args) {
		
			Aluno aluno = new Aluno();
			aluno.setId(10);
			aluno.setNome("Paulo");
			aluno.setDataNascimento("2019-02-15");
			
			AlunoDAO alunoDAO = new AlunoDAO();
			//alunoDAO.add(aluno);
			//alunoDAO.listar();
			//alunoDAO.buscaId("02");
alunoDAO.delete("01");
	}

	

}
