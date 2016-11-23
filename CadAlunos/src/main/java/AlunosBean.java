import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.persistence.Column;

import model.Aluno;
import repository.Alunos;
import repository.Cursos;

@ManagedBean
@ViewScoped
public class AlunosBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	String ra;
	String nome;
	String endereco;
	String telefone;
	String cidade;
	String estado;
	
	List<Aluno> alunos;
	
	@PostConstruct
	public void iniciaPagina()
	{
		alunos = Alunos.pegarTodosAlunos();
	}
	
	public void Salvar()
	{	
		Aluno aluno = new Aluno();
		aluno.setRa(Integer.parseInt(ra));
		aluno.setNome(nome);
		aluno.setEndereco(endereco);
		aluno.setCidade(cidade);
		aluno.setTelefone(telefone);
		aluno.setEstado(estado);
		Alunos.salvarUsuario(aluno);
		org.primefaces.context.RequestContext.getCurrentInstance().execute("PF('aluno').hide()");
		try{
			alunos = Alunos.pegarTodosAlunos();
			org.primefaces.context.RequestContext.getCurrentInstance().update("frmTabelas:tblAlunos");
		}catch (Exception e) {
			
		}
	}
	
	public void excluir(Aluno aluno){
		Alunos.excluirAluno(aluno);
		alunos = Alunos.pegarTodosAlunos();
	}
	
	public void limpar()
	{ 
		ra = "";
		nome = "";
		endereco = "";
		telefone = "";
		cidade = "";
		estado = "";
	}
	
	
	public String getRa() {
		return ra;
	}

	public void setRa(String ra) {
		this.ra = ra;
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
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}

	public List<Aluno> getAlunos() {
		return alunos;
	}

	public void setAlunos(List<Aluno> alunos) {
		this.alunos = alunos;
	}
	
}
