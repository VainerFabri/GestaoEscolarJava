import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.persistence.Column;

import model.Aluno;
import model.Professor;
import repository.Alunos;
import repository.Professores;

@ManagedBean
@ViewScoped
public class ProfessoresBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	String rg;
	String nome;
	String endereco;
	String telefone;
	
	List<Professor> professores;
	
	@PostConstruct
	public void iniciaPagina()
	{
		professores = Professores.pegarTodosProfessores();
	}
	
	public void Salvar()
	{	
		Professor professor = new Professor();
		professor.setRg(Integer.parseInt(rg));
		professor.setNome(nome);
		professor.setEndereco(endereco);
		professor.setTelefone(telefone);
		Professores.salvarUsuario(professor);
		org.primefaces.context.RequestContext.getCurrentInstance().execute("PF('professor').hide()");
		try{
			professores = Professores.pegarTodosProfessores();
			org.primefaces.context.RequestContext.getCurrentInstance().update("frmTabelas:tblProf");
		}catch (Exception e) {
			
		}
	}
	
	public void excluir(Professor professor){
		Professores.excluirProfessor(professor);
		professores = Professores.pegarTodosProfessores();
	}
	
	public void limpar()
	{ 
		rg = "";
		nome = "";
		endereco = "";
		telefone = "";
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public List<Professor> getProfessores() {
		return professores;
	}

	public void setProfessores(List<Professor> professores) {
		this.professores = professores;
	}
	
	
}
